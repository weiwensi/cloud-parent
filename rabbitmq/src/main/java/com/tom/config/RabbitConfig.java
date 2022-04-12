package com.tom.config;


import com.tom.message.Demo01Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * Direct Exchange 示例的配置类
     */
    public static class DirectExchangeDemoConfiguration {

        // 创建 Queue
        //点对点发布
        @Bean
        public Queue demo01Queue() {
            return new Queue(Demo01Message.QUEUE, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Direct Exchange
        @Bean
        public DirectExchange demo01Exchange() {
            return new DirectExchange(Demo01Message.EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

        // 创建 Binding
        // Exchange：Demo01Message.EXCHANGE
        // Routing key：Demo01Message.ROUTING_KEY
        // Queue：Demo01Message.QUEUE
        @Bean
        public Binding demo01Binding() {
            return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(Demo01Message.ROUTING_KEY);
        }

    }

    /**
     * 下面的配置为通配符发布 topic发布
     */
    public static  class LogExchangeConfiguration{
        // 创建 Queue
        @Bean
        public Queue logQueue1() {
            return new Queue(Constant.myQueue1, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }
        @Bean
        public Queue logQueue2() {
            return new Queue(Constant.myQueue2, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Topic Exchange
        @Bean
        public TopicExchange logExchange() {
            return new TopicExchange(Constant.myExchange,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

        // 创建 Binding
        //一个queue 多个
        @Bean
        public Binding BindingLogQueue1() {
            return BindingBuilder.bind(logQueue1()).to(logExchange()).with("a.b");
        }
        @Bean
        public Binding bindingLogQueue2() {
            return BindingBuilder.bind(logQueue2()).to(logExchange()).with("a.*");
        }
    }

}