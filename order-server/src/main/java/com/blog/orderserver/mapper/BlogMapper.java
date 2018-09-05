package com.blog.orderserver.mapper;

import com.blog.orderserver.pojo.BlogsExtends;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    List<BlogsExtends> selectObjects();
}
