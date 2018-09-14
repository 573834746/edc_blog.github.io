package com.blog.servicezuul.filter.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostZuulFilter extends ZuulFilter {
    @Override  
    public Object run() {
        System.out.println("Post执行了");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        System.out.println(String.format("%s PostZuulFilter request to %s", request.getMethod(),
                request.getRequestURL().toString()));  
          
        ctx.setSendZuulResponse(false);
        try {
            response.sendRedirect("/api-a/xuran/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  
    }  
  
    @Override  
    public boolean shouldFilter() {
        return true;
    }
  
    @Override  
    public int filterOrder() {  
        return 0;  
    }  
  
    @Override  
    public String filterType() {  
        return "post";// 在请求被处理之后，会进入该过滤器  
    }  
} 