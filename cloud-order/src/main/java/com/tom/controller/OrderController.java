package com.tom.controller;

import com.tom.client.StoreClient;
import com.tom.dto.Order;
import com.tom.dto.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class OrderController {

    @Autowired
    private StoreClient storeClient;

    @GetMapping("/list/order/")
    public ResponseEntity getOrder() {
        Store productStroe = storeClient.getProductStroe();

        Order order = new Order();
        order.setName("我的订单");
        order.setType("电子产品");
        order.setStore(productStroe);
        return ResponseEntity.ok(order);
    }

    /**
     * 测试nacos配置中心
     * nacos 配置文件名称默认为当前应用名.properties
     */


    @Value("${order.user.name}")
    private String  name;
    @GetMapping("testNacos")
    public ResponseEntity testNacos() {
        String result = name;
        return ResponseEntity.ok(result);
    }

}
