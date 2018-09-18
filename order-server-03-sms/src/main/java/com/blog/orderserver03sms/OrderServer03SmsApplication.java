package com.blog.orderserver03sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@RestController
public class OrderServer03SmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServer03SmsApplication.class, args);
    }
}
