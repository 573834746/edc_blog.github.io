package com.blog.orderserver.controller;

import com.blog.orderserver.pojo.BlogsExtends;
import com.blog.orderserver.service.BlogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 控制层类RequestMapping填写自己的路径地址   如：第一个@RequestMapping("/xuran")
 * 该Controller类内的方法 填写正常路径即可
 */
@RequestMapping("/xuran")
@RestController
public class BlogController {

    @Resource
    private BlogService blogService;

    @RequestMapping("/list")
    public List<BlogsExtends> selectObjects(String realpath){
        List<BlogsExtends> blogs = new ArrayList<>();
        System.out.print("===="+realpath);
        if("home".equals(realpath)){
            blogs = blogService.selectObjects();
        }
        return blogs;
    }


}
