package com.doll.doll_mall.config;

import com.doll.doll_mall.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/3 20:18*/

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")//静态资源也会被拦截
                .excludePathPatterns("/","/goLogin","/login","/static/**","/register","/out"
                ,"/getCode","/repeat","/eml","/YZCode","/test","/json","/lx","/adduser");//放行的请求
    }
}
