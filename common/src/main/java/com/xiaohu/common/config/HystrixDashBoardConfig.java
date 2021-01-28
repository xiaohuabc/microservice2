package com.xiaohu.common.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author ChenHu
 * @Date 2021/1/13 - 1:17
 * @Describe 要被HystrixDashBoard监控到，服务要修改，下面俩属性
 * registrationBean.addUrlMappings("/hystrix.stream");
 * registrationBean.setName("HystrixMetricsStreamServlet");
 **/
@Configuration
public class HystrixDashBoardConfig {

    /*@Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }*/
}
