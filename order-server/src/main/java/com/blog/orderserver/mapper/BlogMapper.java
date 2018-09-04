package com.blog.orderserver.mapper;

import com.blog.orderserver.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    List<Blog> selectObjects();
}
