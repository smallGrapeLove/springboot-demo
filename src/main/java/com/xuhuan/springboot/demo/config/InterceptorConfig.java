package com.xuhuan.springboot.demo.config;

import com.xuhuan.springboot.demo.Interceptor.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huan.xu
 * @ClassName InterceptorConfig
 * @date 2021/1/4 19:59
 * @Description 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor2())
                .addPathPatterns("/**");
//                .excludePathPatterns("/static/login.html");
    }
}
