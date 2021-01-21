package com.xuhuan.springboot.demo.Interceptor;

import com.xuhuan.springboot.demo.util.RequestUtil;
import com.xuhuan.springboot.demo.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author huan.xu
 * @ClassName MyInterceptor
 * @date 2021/1/4 19:56
 * @Description 拦截器
 */

public class MyInterceptor2 implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(MyInterceptor2.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("request请求地址path[{}] ,uri[{}]", request.getServletPath(),request.getRequestURI());
        logger.info("request请求参数path[{}] ", request.getQueryString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
