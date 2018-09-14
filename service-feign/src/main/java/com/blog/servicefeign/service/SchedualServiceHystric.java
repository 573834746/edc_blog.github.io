package com.blog.servicefeign.service;

import com.blog.servicefeign.pojo.AskExtends;
import com.blog.servicefeign.pojo.AskVo;
import com.blog.servicefeign.pojo.BlogsExtends;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 断路器
 */
@Component
public class SchedualServiceHystric implements BlogInterfaceController{
    @Override
    public String sayHiFromClientOne() {
        return "服务暂时关停维护";
    }

    @Override
    public List<BlogsExtends> selectObjects(String alias) {
        return null;
    }

    @Override
    public List<AskExtends> selectAskObjects(AskVo askVo) {
        return null;
    }

    @Override
    public List<AskExtends> selectAskMoneyObjects() {
        return null;
    }

    @Override
    public Boolean insertAsk(String json) {
        return null;
    }
}