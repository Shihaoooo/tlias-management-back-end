package com.itheima.mapper;

import com.itheima.pojo.emp.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    // 新增员工工作经历
    Integer addEmpExpr(List<EmpExpr> empExprList);

    // 删除员工经历
    void deleteEmpExprByIds(List<Integer> ids);
}
