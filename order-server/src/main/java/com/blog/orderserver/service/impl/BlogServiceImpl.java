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
        return blogMapper.selectObjects();
    }
}
