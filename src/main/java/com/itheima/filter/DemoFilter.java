package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    //初始化方法，只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法执行了");
    }

    //拦截到请求之后调用，调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo 拦截到了请求");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        //放行后逻辑
        System.out.println("Demo 放行了");
    }

    //销毁方法，只调用一次
    @Override
    public void destroy() {
        System.out.println("销毁方法执行了");
    }
}
