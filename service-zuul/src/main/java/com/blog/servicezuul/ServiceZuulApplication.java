package com.blog.servicezuul;

import com.blog.servicezuul.filter.pre.PreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

    /**
     * 即使其它配置都写好的话，那么不添加这个 Bean 的方法的话，还是不会执行任何过滤的方法；
     * @return
     */
    @Bean
    public PreZuulFilter preZuulFilter(){
        return new PreZuulFilter();
    }
//    @Bean
//    public PostZuulFilter PostZuulFilter(){
//        return new PostZuulFilter();
//    }
}
