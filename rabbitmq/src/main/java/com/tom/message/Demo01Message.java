package com.tom.message;

import java.io.Serializable;

public class Demo01Message implements Serializable {
 //注意要实现java的serializable
    // 因为rabbitTemplate默认使用java自带的序列化方式，进行序列化pojo类型的消息

    public static final String QUEUE = "QUEUE_DEMO_01";

    public static final String EXCHANGE = "EXCHANGE_DEMO_01";

    public static final String ROUTING_KEY = "ROUTING_KEY_01";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo01Message{" +
                "id=" + id +
                '}';
    }
}
