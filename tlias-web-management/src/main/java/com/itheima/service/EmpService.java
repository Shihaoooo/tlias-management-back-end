package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {


    // 条件分页查询
    PageResult<Emp> queryEmp(String name, Integer gender , LocalDate date , Integer currentPage , Integer pageSize);
}
