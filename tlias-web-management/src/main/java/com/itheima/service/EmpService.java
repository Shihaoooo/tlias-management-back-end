package com.itheima.service;

import com.itheima.pojo.emp.Emp;
import com.itheima.pojo.emp.EmpJobDataStatistics;
import com.itheima.pojo.emp.EmpQueryParam;
import com.itheima.pojo.login.LoginInfo;
import com.itheima.pojo.result.PageResult;

import java.util.List;
import java.util.Map;

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

    // 统计员工岗位人数
    EmpJobDataStatistics getEmpJobData();

    // 统计员工性别人数
    List<Map<Object, Object>> getEmpGenderData();

    // 员工登陆接口
    LoginInfo login(Emp emp);
}
