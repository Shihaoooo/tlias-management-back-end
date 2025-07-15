package com.itheima.service;

import com.itheima.pojo.emp.Emp;
import com.itheima.pojo.emp.EmpQueryParam;
import com.itheima.pojo.result.PageResult;

import java.util.List;

public interface EmpService {


    // 条件分页查询
    PageResult<Emp> queryEmp(EmpQueryParam empQueryParam);

    // 添加员工
    Integer addEmp(Emp emp);

    // 删除员工
    void deleteEmpByIds(List<Integer> ids);

    // 查询回显
    Emp queryEmpById(Integer id);

    // 修改员工
    void  update(Emp emp);
}
