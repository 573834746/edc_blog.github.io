package com.blog.orderserver.service.impl;

import com.blog.orderserver.mapper.BlogMapper;
import com.blog.orderserver.pojo.BlogsExtends;
import com.blog.orderserver.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;
    @Override
    public List<BlogsExtends> selectObjects() {
        List<BlogsExtends> list = blogMapper.selectObjects();
        //手动缩略文章内容
        for (BlogsExtends blog:list) {
            if(blog.getContent().length()>=60){
                String content_list = blog.getContent().substring(0, 60)+"...";
                blog.setContent(content_list);
            }
        }
        return list;
    }
}
