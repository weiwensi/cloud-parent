package com.tom.mq;

// Demo01Consumer.java

import com.tom.config.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Constant.myQueue2,concurrency = "5")
public class Consumer2 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage( String message) {
        logger.info("myQueue2收到消息{}", message);
    }


}