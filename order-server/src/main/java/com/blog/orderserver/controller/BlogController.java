package com.blog.orderserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.orderserver.pojo.AskExtends;
import com.blog.orderserver.pojo.AskVo;
import com.blog.orderserver.pojo.BlogsExtends;
import com.blog.orderserver.pojo.BlogsVo;
import com.blog.orderserver.service.BlogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public List<BlogsExtends> selectObjects(BlogsVo blogsVo){
        List<BlogsExtends> blogs = blogService.selectObjects(blogsVo);
        return blogs;
    }

    @RequestMapping("/ask_list")
    public List<AskExtends> selectAskObjects(@RequestBody AskVo askVo){
        //AskVo askVo = JSONObject.parseObject(json, AskVo.class);
        System.out.println(askVo.getRules()+"==================================");
        List<AskExtends> askObjects = blogService.selectAskObjects(askVo);
        return askObjects;
    }

    @RequestMapping("/ask_money_list")
    public List<AskExtends> selectAskMoneyObjects(){
        List<AskExtends> askMoneyObjects = blogService.selectAskMoneyObjects();
        return askMoneyObjects;
    }

    @PostMapping("/insertAsk")
    public Boolean insertAsk(String json){
        Boolean flag = true;
        //json转对象
        AskExtends askExtends = JSONObject.parseObject(json, AskExtends.class);
        try {
            blogService.insertAsk(askExtends);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

}
