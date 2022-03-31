package com.tom.dto;

import lombok.Data;

import java.util.PrimitiveIterator;

@Data
public class Order {
    private String name;

    private String type;

    private Store store;
}
