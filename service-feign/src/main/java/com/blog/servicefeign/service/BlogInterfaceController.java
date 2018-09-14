package com.blog.servicefeign.service;

import com.blog.servicefeign.pojo.AskExtends;
import com.blog.servicefeign.pojo.AskVo;
import com.blog.servicefeign.pojo.BlogsExtends;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 该接口内的 @RequestMapping内须填写自己的路径   如： @RequestMapping(value = "xuran/list"）
 */
@FeignClient(value = "order",fallback = SchedualServiceHystric.class)
public interface BlogInterfaceController {

    @RequestMapping(value = "/hi")
    String sayHiFromClientOne();

    /**
     * 主页列表查询
     * @param alias
     * @return
     */
    @RequestMapping(value = "xuran/list",method = RequestMethod.GET)
    List<BlogsExtends> selectObjects(@RequestParam(value = "alias") String alias);
    /**
     * 悬赏列表查询
     * @param rules
     * @return
     */
    @RequestMapping(value = "xuran/ask_list",method = RequestMethod.POST,consumes = "application/json")
    List<AskExtends> selectAskObjects(@RequestBody AskVo askVo);
    /**
     * 查询积分对照表
     * @return
     */
    @RequestMapping(value = "xuran/ask_money_list",method = RequestMethod.POST)
    List<AskExtends> selectAskMoneyObjects();

    /**
     * 添加悬赏问题
     */
    @RequestMapping(value = "xuran/insertAsk",method = RequestMethod.POST)
    Boolean insertAsk(@RequestParam(value = "json") String json);

}
