package com.lucian.vhr_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.lucian.vhr_server.dao")
@EnableCaching
public class VhrServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrServerApplication.class, args);
    }

}
