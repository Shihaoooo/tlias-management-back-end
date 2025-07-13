package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    // 新增员工工作经历
    Integer addEmpExpr(List<EmpExpr> exprList);

    // 删除员工经历
    void deleteEmpExprByIds(List<Integer> ids);
}
