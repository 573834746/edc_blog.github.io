package com.blog.orderserver.service.impl;

import com.blog.orderserver.mapper.BlogMapper;
import com.blog.orderserver.pojo.AskExtends;
import com.blog.orderserver.pojo.BlogsExtends;
import com.blog.orderserver.pojo.BlogsVo;
import com.blog.orderserver.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.lang.reflect.Array;
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
    public List<AskExtends> selectAskObjects(String rules) {
        return blogMapper.selectAskObjects(rules);
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
}
