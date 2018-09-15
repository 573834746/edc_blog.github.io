package com.blog.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "order",fallback = SchedualServiceHystric.class)
public interface SchedualServiceHystricHi {

    @RequestMapping(value = "/xuran/hi")
    String sayHiFromClientOne();

}
