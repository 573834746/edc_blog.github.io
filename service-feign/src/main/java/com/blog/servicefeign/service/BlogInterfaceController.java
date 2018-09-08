package com.blog.servicefeign.service;

import com.blog.servicefeign.pojo.BlogsExtends;
import com.blog.servicefeign.pojo.BlogsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 该接口内的 @RequestMapping内须填写自己的路径   如： @RequestMapping(value = "xuran/list"）
 */
@FeignClient(value = "order")
public interface BlogInterfaceController {
    @RequestMapping(value = "xuran/list",method = RequestMethod.GET)
    List<BlogsExtends> selectObjects(@RequestParam(value = "alias") String alias);
}
