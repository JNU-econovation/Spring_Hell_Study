package com.econovation.springstudy.config;

import com.econovation.springstudy.interceptor.CheckingLoginInterceptor;
import com.econovation.springstudy.interceptor.CreatingSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final CheckingLoginInterceptor checkingLoginInterceptor;
    private final CreatingSessionInterceptor creatingSessionInterceptor;

    public WebConfig(CheckingLoginInterceptor checkingLoginInterceptor, CreatingSessionInterceptor creatingSessionInterceptor) {
        this.checkingLoginInterceptor = checkingLoginInterceptor;
        this.creatingSessionInterceptor = creatingSessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkingLoginInterceptor)
                .excludePathPatterns("/login", "/signup");
        registry.addInterceptor(creatingSessionInterceptor)
                .addPathPatterns("/login", "/signup");

    }
}
