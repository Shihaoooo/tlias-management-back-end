package com.itheima.controller;

import com.itheima.pojo.emp.Emp;
import com.itheima.pojo.login.LoginInfo;
import com.itheima.pojo.result.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    // 登陆接口
    @PostMapping("")
    public Result login(@RequestBody Emp emp) {
        log.info("用户登陆{}",emp.getUsername());

        LoginInfo loginInfo = empService.login(emp);

        if (loginInfo != null) {
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");
    }
}
