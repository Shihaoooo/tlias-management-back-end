package com.itheima.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@ConfigurationProperties("jwt")
public class JWTUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private Long expire;

    public String createJWT(Map<String,Object> dataMap) {
        return Jwts.builder().
                signWith(SignatureAlgorithm.HS256,secret).
                addClaims(dataMap).
                setExpiration(new Date(System.currentTimeMillis() + expire)).
                compact();
    }

    public Map<String,Object> parseJWT(String jwt) {
        return Jwts.parser().
                setSigningKey(secret).
                parseClaimsJws(jwt).
                getBody();
    }
}
