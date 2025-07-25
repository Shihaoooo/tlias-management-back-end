package com.itheima.Interceptor;

import com.itheima.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取到请求路径
        String requestURI = request.getRequestURI();

        // 2. 判断是否为请求对象(已经在config中定以)
        if (requestURI.contains("/login")) {
            return true;
        }

        // 3. 判断token是否存在
        String token = request.getHeader("token");

        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 4. token存在，开始解析token
        try{
            jwtUtils.parseJWT(token);
        }catch (Exception e){
            log.info("令牌解析错误！",e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //相应 404
            return false;
        }

        // 5. 令牌存在且，解析成功，放行
        return true;




    }
}
