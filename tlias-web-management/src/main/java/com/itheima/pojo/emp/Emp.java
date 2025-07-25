package com.itheima.pojo.emp;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Emp {
    // 员工基本信息
    private Integer id;    // 员工id（empId）
    private String userName;
    private String password;
    private String empName;
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
    // 封装员工的经历信息（因为可能有多段，故用列表）
    private List<EmpExpr> empExprList;
}

