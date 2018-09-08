package com.blog.orderserver.mapper;

import com.blog.orderserver.pojo.BlogsExtends;
import com.blog.orderserver.pojo.BlogsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogMapper {

    List<BlogsExtends> selectObjects(@Param("blogsVo") BlogsVo blogsVo);
}
