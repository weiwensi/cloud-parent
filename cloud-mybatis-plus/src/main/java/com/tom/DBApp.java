package com.tom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tom.mapper")
public class DBApp {
    public static void main(String[] args) {
        SpringApplication.run(DBApp.class, args);

    }
}
