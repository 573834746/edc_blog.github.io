package com.blog.orderserver01.service.impl;

import com.blog.orderserver01.pojo.*;
import com.blog.orderserver01.mapper.BlogMapper;
import com.blog.orderserver01.pojo.BlogsExtends;
import com.blog.orderserver01.service.BlogService;
import com.blog.orderserver01.utils.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;
    @Override
    public List<BlogsExtends> selectObjects(BlogsVo blogsVo) {
        List<BlogsExtends> list = blogMapper.selectObjects(blogsVo);
        //手动缩略文章内容
        for (BlogsExtends blog:list) {
            if(blog.getContent().length()>=60){
                String content_list = blog.getContent().substring(0, 60)+"...";
                blog.setContent(content_list);
            }
        }
        return list;
    }

    @Override
    public List<AskExtends> selectAskObjects(AskVo askVo) {
        return blogMapper.selectAskObjects(askVo);
    }

    @Override
    public List<AskExtends> selectAskMoneyObjects() {
        return blogMapper.selectAskMoneyObjects();
    }

    @Override
    public void insertAsk(AskExtends askExtends) throws Exception{
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        askExtends.setDate(time);
        String ask_types = askExtends.getAsk_types();
        StringBuffer askType = new StringBuffer();
        StringBuffer realTypes = new StringBuffer();
        String[] types = ask_types.trim().split(" ");
        for (int i = 0; i < types.length; i++) {
            if(types[i].length()>0){
                realTypes.append(types[i]+" ");
            }
        }
        String[] realTypesArray = realTypes.toString().trim().split(" ");
        askExtends.setAsk_typesArray(realTypesArray);
        blogMapper.insertAsk(askExtends);
        blogMapper.insertAsk_type(askExtends);
    }

    @Override
    public Boolean checkInfo(UsersVo usersVo) {

        String pwd = usersVo.getUsername()+usersVo.getPassword();

        System.out.println(">>>>>>>>>>>>前台字符串>>>>>>>>>>>>\n"+usersVo.getPassword());
        int hashCode = usersVo.getPassword().hashCode();
        System.out.println(">>>>>>>>>>>>取字符串的hashCode值>>>>>>>>>>>>\n"+hashCode);
        //转成字符串
        String hashPwd = String.valueOf(hashCode);
        //把hashCode值再一次进行普通MD5加密
        String userMd5 = Md5Util.MD5(hashPwd);

        //注册时用
        //动态盐加密MD5，存入数据库
        String dynamicSaltMd5 = Md5Util.generateDynamicSaltMd5(userMd5);
        System.out.println(">>>>>>>>>>>>hashCode值进行动态盐加密>>>>>>>>>>>>\n"+dynamicSaltMd5);

        String userDynamicSaltMd5 = blogMapper.selectPwdByName(usersVo);
        System.out.println(">>>>>>>>>>>>用户动态盐MD5>>>>>>>>>>>>>>>>>\n"+userDynamicSaltMd5);

        if(userDynamicSaltMd5!=null){
            //校验密码，md5追溯到最开始是用户输入的密码，dynamicSaltMd5从数据库查取
            boolean verify = Md5Util.verify(userMd5, userDynamicSaltMd5);
            System.out.println(">>>>>>>>>>>>校验密码true为正确>>>>>>>>>>>>\n"+verify);

            if(verify){
                //把用户信息放入session

            }

            return verify;
        }else{
            return false;
        }

    }

    @Override
    public String selectPwdByName(UsersVo usersVo) {
        return blogMapper.selectPwdByName(usersVo);
    }

    @Override
    public Boolean registerUser(Users users) {
        Boolean flag = true;
        try {

            String pwd = users.getUsername()+users.getPassword();

            System.out.println(">>>>>>>>>>>>前台字符串>>>>>>>>>>>>\n"+users.getPassword());
            int hashCode = pwd.hashCode();
            System.out.println(">>>>>>>>>>>>取字符串的hashCode值>>>>>>>>>>>>\n"+hashCode);
            //转成字符串
            String hashPwd = String.valueOf(hashCode);
            //把hashCode值再一次进行普通MD5加密
            String userMd5 = Md5Util.MD5(hashPwd);

            //动态盐加密MD5，存入数据库
            String dynamicSaltMd5 = Md5Util.generateDynamicSaltMd5(userMd5);
            System.out.println(">>>>>>>>>>>>hashCode值进行动态盐加密>>>>>>>>>>>>\n"+dynamicSaltMd5);
            users.setPassword(dynamicSaltMd5);

            blogMapper.registerUser(users);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
