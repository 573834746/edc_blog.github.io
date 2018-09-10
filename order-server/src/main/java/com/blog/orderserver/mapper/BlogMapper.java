package com.blog.orderserver.mapper;

import com.blog.orderserver.pojo.AskExtends;
import com.blog.orderserver.pojo.BlogsExtends;
import com.blog.orderserver.pojo.BlogsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogMapper {
    /**
     * 主页列表查询
     * @param blogsVo
     * @return
     */
    List<BlogsExtends> selectObjects(@Param("blogsVo") BlogsVo blogsVo);

    /**
     * 悬赏列表查询
     * @param rules
     * @return
     */
    List<AskExtends> selectAskObjects(@Param("rules") String rules);
}
