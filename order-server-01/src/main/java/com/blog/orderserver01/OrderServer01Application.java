package com.blog.orderserver01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan(basePackages = {"com.blog.orderserver01.mapper"})
@EnableEurekaClient
@RestController
public class OrderServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderServer01Application.class, args);
    }

    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(){
        return "======================="+"来自:"+port+"端口=======================";
    }
}
