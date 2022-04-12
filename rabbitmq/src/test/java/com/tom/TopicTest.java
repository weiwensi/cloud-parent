package com.tom;

import com.tom.config.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TopicTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {

        String  message="hello a--------------------->>>>>>>>>>>>>>>>>>>>>";
        rabbitTemplate.convertAndSend(Constant.myExchange,"a.b",message);
        System.out.println("发送消息success！！！！");
    }
}
