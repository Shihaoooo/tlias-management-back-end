package com.itheima.filter;


import com.itheima.utils.JWTUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
//@Component
//@WebFilter(urlPatterns = {"/*"})
public class TokenFilter implements Filter {

//    @Autowired
//    private JWTUtils jwtUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 获取到请求路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        // 2.判断是否是登陆请求（/login）
        if (requestURI.contains("/login")) {
            // 登陆请求放行(因为没有登陆就没有令牌，没有令牌就不用校验）
            filterChain.doFilter(request, response);
            return;
        }

        // 3.获取请求头中的token
        String token = request.getHeader("token");

        // 4.判断token是否存在，若不存在则用户未登陆
        if (token == null || !token.isEmpty()) {
            log.info("用户未登陆");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 5.如果token存在，则开始校验令牌，解析失败 -》 404页面
        try {
//            jwtUtils.parseJWT(token);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 6.解析成功 放行
        filterChain.doFilter(request, response);
    }
}
