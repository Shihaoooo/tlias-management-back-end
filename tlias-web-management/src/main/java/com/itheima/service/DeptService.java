package com.itheima.service;

import com.itheima.pojo.dept.Dept;

import java.util.List;

public interface DeptService {

    // 查询所有的数据
    List<Dept> findAll();

    // 根据id查询数据
    Dept getById(Integer id);

    // 根据id删除数据
    Integer deleteById(Integer id);

    // 根据部门名增加数据
    Integer addDept(String deptName);

    // 根据id修改部门名
    Integer updateById(Integer id, String newDeptName);
}
