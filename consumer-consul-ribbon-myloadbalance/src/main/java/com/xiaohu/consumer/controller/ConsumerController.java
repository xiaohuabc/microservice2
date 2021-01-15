package com.xiaohu.consumer.controller;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.consumer.config.MyLoadBalance;
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
import java.net.URI;
import java.util.List;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 19:03
 * @Describe
 **/
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${rest.url.provider}")
    String providerUrl;

    @Autowired
    RestTemplate restTemplate;

    //注意引入Spring的
    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    MyLoadBalance myLoadBalance;

    @GetMapping("/getPortByLb")
    public String getPortByLb(){

        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        ServiceInstance instance = myLoadBalance.getInstance(instances);

        if(instance == null){
            return "未找到服务";
        }

        URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/provider/getPort",String.class);
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
