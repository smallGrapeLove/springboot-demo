package com.xuhuan.springboot.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author huan.xu
 * @ClassName MyFilter
 * @date 2021/1/4 19:47
 * @Description 过滤器
 */
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

    }
}
