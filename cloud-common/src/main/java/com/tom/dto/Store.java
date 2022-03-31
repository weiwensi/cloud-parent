package com.tom.dto;

import lombok.Data;

@Data
public class Store {

    /**
     * 商品名字
     */
    private String productName;
    /**
     * 商品数量
     */
    private Integer count;

}
