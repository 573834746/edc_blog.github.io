package com.blog.orderserver.service;

import com.blog.orderserver.pojo.Blogs;

import java.util.List;

public interface BlogService {
    List<Blogs> selectObjects();
}
