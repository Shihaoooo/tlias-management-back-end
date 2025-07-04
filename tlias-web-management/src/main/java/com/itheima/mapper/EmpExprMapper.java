package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpExprMapper {

    // 新增员工工作经历
    @Insert("insert into emp_expr(emp_id, date, company, job)" +
            "values(#{empId},#{date},#{company},#{job})")
    Integer addEmpExpr(EmpExpr empExpr);

}
