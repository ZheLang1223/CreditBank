package com.cbank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.cbank.mapper")
@SpringBootApplication
public class CbankApplication {
    public static void main(String[] args) {
        SpringApplication.run(CbankApplication.class, args);
    }
}
