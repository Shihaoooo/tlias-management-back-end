package com.itheima.pojo.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 封装返回的登陆信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {

    private Integer id;
    private String username;
    private String name;
    private String token;
}
