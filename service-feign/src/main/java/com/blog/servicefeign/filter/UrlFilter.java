package com.blog.servicefeign.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class UrlFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponseWrapper httpResponse = new HttpServletResponseWrapper((HttpServletResponse) response);

        String path=httpRequest.getRequestURI();

        String type_path = "//new//watchers//news//ai//cloud//blockchain//db//career//game//engineering//web//mobile//iot//ops//fund//lang//arch//avi//sec//other";

        String[] split = path.split("/");
        String realpath = split[split.length-1];

        if(type_path.contains("/"+realpath)){
            if(path.indexOf("index")>-1){
                path=path.replace("/"+realpath,"");
            }
            httpRequest.getRequestDispatcher(path).forward(request,response);
            return;
        }else {
            chain.doFilter(request,response);
        }
    }
}