package com.blog.orderserver.service;

import com.blog.orderserver.pojo.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> selectObjects();
}
