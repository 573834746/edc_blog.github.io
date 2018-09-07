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
        //System.out.println(httpRequest.getRequestURI());
        String path=httpRequest.getRequestURI();

        if(path.contains("/new")){
            path=path.replace("/new","");
            request.setAttribute("realpath","new");
            httpRequest.getRequestDispatcher(path).forward(request,response);
            //httpResponse.sendRedirect(path);
            return;
        }else if(0==1){

        }
        else {
            chain.doFilter(request,response);
        }
    }
}