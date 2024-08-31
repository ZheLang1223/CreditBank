package com.wms;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径跨域访问
                .allowedOrigins("http://localhost:8080") // Vue开发服务器地址，可以替换为前端应用的域名或'*'表示允许所有源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // 允许的HTTP方法
                .allowedHeaders("*") // 允许的请求头，'*'表示允许所有请求头
                .allowCredentials(true) // 是否允许携带凭证（cookies, HTTP认证及客户端SSL证明等）
                .maxAge(3600); // 缓存预检请求的结果，单位为秒
    }
}