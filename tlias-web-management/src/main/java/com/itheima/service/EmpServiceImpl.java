
package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    // 分页查询
    public PageResult<Emp> queryEmp(EmpQueryParam empQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(empQueryParam.getCurrentPage(),empQueryParam.getPageSize());
        //2.执行查询,并解释查询结果(将List强转位Page对象，因为Page对象继承了ArrayList，可以实现强转)
        Page<Emp> p = (Page<Emp>) empMapper.queryEmp(empQueryParam);

        return new PageResult<Emp>(p.getResult(),p.getTotal());
    }

    // 添加员工
    @Transactional
    public Integer addEmp(Emp emp){
        // 1.保存员工基本信息
        Integer affectedOnEmp =  empMapper.addEmp(emp);

        // 2.当员工工作经历不为空时，才添加工作经历
        if (CollectionUtils.isEmpty(emp.getEmpExpr())){
            _addEmpExpr(emp);
        }

        return affectedOnEmp;
    }

    // 保存员工工作经历(保证不会被外部意外调用)
    @Transactional
    public void _addEmpExpr(Emp emp){
        // 1.批量为Expr对象的empId赋值（emp的id已用主键返回获取并封装）
        for(EmpExpr expr : emp.getEmpExpr()){
            expr.setEmpId(emp.getId());
        }

        // 2.判断
        Integer affected = empExprMapper.addEmpExpr(emp.getEmpExpr());

        if (affected!=null && affected > 0){
            log.info("员工经验插入成功");
        }
        else{
            log.error("员工经验插入失败");
        }

    }

    @Transactional
    public void deleteEmpByIds(List<Integer> ids){

        // 1.删除员工基本信息
        empMapper.deleteEmpByIds(ids);

        // 2.删除员工经历信息
        empExprMapper.deleteEmpExprByIds(ids);
    }
}
