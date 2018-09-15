package com.blog.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * 断路器
 */
@Component
public class SchedualServiceHystric implements SchedualServiceHystricHi{

    @Override
    public String sayHiFromClientOne() {
        return "服务暂时关停维护";
    }

}