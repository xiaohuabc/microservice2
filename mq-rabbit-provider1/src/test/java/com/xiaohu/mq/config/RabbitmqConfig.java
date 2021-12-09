package com.xiaohu.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ChenHu
 * @Date 2021/1/29 - 0:23
 * @Describe
 **/
@Configuration
public class RabbitmqConfig {

    /** 交换机名称 */
    public static String Exchange_Name = "topicExchange";
    /** 队列名称  */
    public static String Queue_Name1 = "topic1";
    /** 队列名称  */
    public static String Queue_Name2 = "topic2";
    /** 队列名称  */
    public static String Queue_Name3 = "topic3";
    /** 队列名称 存放对象*/
    public static String Queue_Name4 = "topic4";
    /** 批量队列名称  */
    public static String Queue_Batch_Name = "topicQueueBatch";

    /** 路由键 */
    public static String Rout_key1 = "*.china.*";
    public static String Rout_key2 = "boy.#";
    public static String Rout_key3 = "#.sing";
    public static String Rout_key4 = "obj.user.*";
    public static String Rout_key_Batch = "topic.batch";

    /**
     * 声明队列
     * @return
     */
    @Bean
    Queue myQueue1() {
        return new Queue(Queue_Name1);
    }
    @Bean
    Queue myQueue2() {
        return new Queue(Queue_Name2);
    }
    @Bean
    Queue myQueue3() {
        return new Queue(Queue_Name3);
    }
    @Bean
    Queue myQueue4() {
        return new Queue(Queue_Name4);
    }
    @Bean
    Queue batchQueueTopic() {
        return new Queue(Queue_Batch_Name);
    }

    /**
     * SpringAMQP 提供了各种类型的交换机类型
     * DirectExchange  1v1队列
     * FanoutExchange  广播模式
     * HeadersExchange  头模式 不是很了解这个模式
     * TopicExchange   模糊匹配模式 正在使用
     * @return
     */
    @Bean
    TopicExchange bindTopicExchange(){
        /**
         * 构造一个新的Exchange，并为其指定名称，持久性标志和自动删除标志以及*参数。
         * @param name 交换的名称。
         * @param durable 如果我们声明一个持久交换（交换将在服务器重启后保留），则为true
         * @param autoDelete 如果服务器在不再使用该交换时应删除该交换，则为true
         * @param arguments 用于声明交换的参数
         */
        return new TopicExchange(Exchange_Name,false,true,null);
    }

    /**
     * 将交换机与队列绑定同时设置路由键
     * @return
     */
    @Bean
    Binding topicBindingOne(){
        return BindingBuilder.bind(myQueue3()).to(bindTopicExchange()).with(Rout_key3);
    }
    @Bean
    Binding topicBindingtwo(){
        return BindingBuilder.bind(myQueue2()).to(bindTopicExchange()).with(Rout_key2);
    }
    @Bean
    Binding topicBindingthere(){
        return BindingBuilder.bind(myQueue1()).to(bindTopicExchange()).with(Rout_key1);

    }
    @Bean
    Binding topicBindingFour(){
        return BindingBuilder.bind(myQueue4()).to(bindTopicExchange()).with(Rout_key4);

    }
    @Bean
    Binding topicBindingBatch(){
        return BindingBuilder.bind(batchQueueTopic()).to(bindTopicExchange()).with(Rout_key_Batch);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connection = new CachingConnectionFactory();
        connection.setAddresses("localhost:5672");
        connection.setUsername("guest");
        connection.setPassword("guest");
        connection.setVirtualHost("/");
        return connection;
    }

    // 配置RabbitAdmin来管理rabbit
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        //用RabbitAdmin一定要配置这个，spring加载的时候，就会加载这个类================特别重要
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    //参考资料：https://blog.csdn.net/future_spring/article/details/106690434
    //暂没时间考虑，这个getTypeIds是干啥用的

    //这里试一下，用jackson可以，用fastjson看行不行
    /*@Bean
    public MessageConverter messageConverter(ObjectMapper mapper) {
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter(mapper);
//        DefaultJackson2JavaTypeMapper javaTypeMapper = new DefaultJackson2JavaTypeMapper();
        // 跟方案1 一样，只不过这个Map是通过注解扫描自动生成的
//        javaTypeMapper.setIdClassMapping(getTypeIds());
//        messageConverter.setJavaTypeMapper(javaTypeMapper);
        return messageConverter;
    }*/

    //使用Jackson2JsonMessageConverter进行序列化，但是不推荐，因为效率没jdk自带的序列化方式高
    //只是在消息队列里，可读性更强
    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        return messageConverter;
    }
}
