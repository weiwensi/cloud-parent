package com.tom.controller;

import com.tom.dto.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @GetMapping("/product/store")
    public Store getProductStroe() {
        Store store = new Store();
        store.setProductName("小米");
        store.setCount(100);
        return store;
    }
}
