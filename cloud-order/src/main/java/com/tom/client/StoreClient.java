package com.tom.client;


import com.tom.dto.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("cloud-store")
public interface StoreClient {

    @GetMapping("/product/store")
    public Store getProductStroe();

}
