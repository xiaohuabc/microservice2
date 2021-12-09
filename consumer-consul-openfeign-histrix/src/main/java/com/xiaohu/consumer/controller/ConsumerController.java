package com.xiaohu.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.consumer.service.MyFirstFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 19:03
 * @Describe 针对单个方法降级处理
 **/
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${rest.url.provider}")
    String providerUrl;

    @Value("${server.port}")
    String port;

    @Autowired
    RestTemplate restTemplate;

    //注意引入Spring的
    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    MyFirstFeignService myFirstFeignService;

    /**
     * @Author ChenHu
     * @Date 2021/1/12 - 15:55
     * @Description 自我降级
     * @Return
     **/
    @HystrixCommand(fallbackMethod = "mySelfFallbackHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/mySelfFallback")
    public String mySelfFallback() throws InterruptedException {
        System.out.println("privider1 timeout执行");
        try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace(); throw e;}

        return "HandleSuccess" + port;
    }

    /**
     * @Author ChenHu
     * @Date 2021/1/12 - 15:45
     * @Description @HystrixCommand注解fallbackMethod指定的兜底方法
     * @Return
     **/
    public String mySelfFallbackHandler(){
        return "消费者兜底方法" + port;
    }

    @GetMapping("/timeout")
    public String timeout(){
        System.out.println("timeout==============执行");
        return myFirstFeignService.timeout();
    }

    @GetMapping("/getMessage")
    public String getMessage(){
        System.out.println("getMessage==============执行");
        return myFirstFeignService.getMessage();
    }

    @GetMapping("/getPort")
    public String getPort(){
        return restTemplate.getForObject(providerUrl + "/provider/getPort",String.class);
    }

    @GetMapping("/showInstance")
    public ResponseObjectResult showInstance(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        List<ServiceInstance> providers = discoveryClient.getInstances("provider");

        for (ServiceInstance provider : providers) {
            log.info(provider.getInstanceId() + "\t" + provider.getHost() + "\t" + provider.getPort());
            log.info(provider.getUri().toString());
        }

        return new ResponseObjectResult(ResponseStatus.responseSuccess(),services);
    }

}
