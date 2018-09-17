package com.blog.orderserver01.service;

import com.blog.orderserver01.pojo.*;

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
     * @param askVo
     * @return
     */
    List<AskExtends> selectAskObjects(AskVo askVo);
    /**
     * 查询积分对照表
     * @return
     */
    List<AskExtends> selectAskMoneyObjects();

    /**
     * 添加悬赏问题
     */
    void insertAsk(AskExtends askExtends) throws Exception;

    /**
     * 核查用户信息
     * @param usersVo
     * @return
     */
    Boolean checkInfo(UsersVo usersVo);

    String selectPwdByName(UsersVo usersVo);

    /**
     * 注册用户
     * @param users
     * @return
     */
    Boolean registerUser(Users users);
}
