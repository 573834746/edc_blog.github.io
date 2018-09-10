package com.blog.orderserver.service;

import com.blog.orderserver.pojo.AskExtends;
import com.blog.orderserver.pojo.BlogsExtends;
import com.blog.orderserver.pojo.BlogsVo;

import java.util.List;

public interface BlogService {
    /**
     * 主页列表查询
     * @param blogsVo
     * @return
     */
    List<BlogsExtends> selectObjects(BlogsVo blogsVo);
    /**
     * 悬赏列表查询
     * @param rules
     * @return
     */
    List<AskExtends> selectAskObjects(String rules);
}
