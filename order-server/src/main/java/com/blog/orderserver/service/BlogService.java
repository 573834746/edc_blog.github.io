package com.blog.orderserver.service;

import com.blog.orderserver.pojo.BlogsExtends;

import java.util.List;

public interface BlogService {
    List<BlogsExtends> selectObjects();
}
