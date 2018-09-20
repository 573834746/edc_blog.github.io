//package com.blog.servicefeign.filter;
//
//import javax.servlet.*;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletResponseWrapper;
//import java.io.IOException;
//
//public class UrlFilter implements Filter {
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest)request;
//        HttpServletResponseWrapper httpResponse = new HttpServletResponseWrapper((HttpServletResponse) response);
//
//
//        Cookie cookie = new Cookie("testcookie", "123");
//        cookie.setPath("/");
//        cookie.setMaxAge(-1);
//        httpResponse.addCookie(cookie);
//
//
//        String path=httpRequest.getRequestURI();
//
//        String type_path = "//new//watchers//news//ai//cloud//blockchain//db//career//game//engineering//web//mobile//iot//ops//fund//lang//arch//avi//sec//other";
//
//        String[] split = path.split("/");
//        String realpath = split[split.length-1];
//
////        /**
////         * 解决跨域访问问题
////         * 如果服务器端可以确定是要被哪些域名访问，
////         * 最好是能把以上代码中的“*”代替为具体的域名，这样做可以相应的增强安全性。
////         */
////        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//
//        if(type_path.contains("/"+realpath)){
//            if(path.indexOf("index")>-1){
//                path=path.replace("/"+realpath,"");
//            }
//            httpRequest.getRequestDispatcher(path).forward(request,response);
//            return;
//        }else {
//            chain.doFilter(request,response);
//        }
//    }
//}