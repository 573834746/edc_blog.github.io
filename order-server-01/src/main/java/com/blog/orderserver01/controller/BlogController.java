package com.blog.orderserver01.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.orderserver01.pojo.*;
import com.blog.orderserver01.service.BlogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("/check")
    public UsersVo checkInfo(@RequestBody UsersVo usersVo){
        usersVo = blogService.checkInfo(usersVo);
        return usersVo;
    }

    @RequestMapping("/registerUser")
    public Boolean registerUser(@RequestBody Users users){
        return blogService.registerUser(users);
    }

    /**
     * 根据uuid获取redis信息再去获取对象信息
     * @param user_uuid
     * @return
     */
    @RequestMapping("/selectUser")
    public Users selectUser(String user_uuid){
        return blogService.selectUser(user_uuid);
    }


}
