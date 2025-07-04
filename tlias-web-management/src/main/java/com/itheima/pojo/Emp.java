package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Emp {
    // 员工基本信息
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String phone;
    private Integer job;
    private Integer salary;
    private String image;
    private LocalDate date;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 额外封装部门名称
    private String deptName;
    // 额外封装员工名称
    private String empName;
    // 封装员工的经历信息（因为可能有多段，故用列表）
    private List<EmpExpr> empExpr;
}

