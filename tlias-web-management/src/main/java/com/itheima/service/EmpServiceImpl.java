
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
import org.springframework.util.CollectionUtils;

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
    public Integer addEmp(Emp emp){
        // 1.保存员工基本信息
        Integer affectedOnEmp =  empMapper.addEmp(emp);

        // 2.当员工工作经历不为空时，才添加工作经历
        if (CollectionUtils.isEmpty(emp.getEmpExpr())){
            addEmpExpr(emp);
        }

        return affectedOnEmp;
    }

    // 保存员工工作经历(是由方法，保证不会被外部意外调用)
    private void addEmpExpr(Emp emp){
        // 循环逐个添加
        for(EmpExpr empExpr:emp.getEmpExpr()){
            Integer affected = empExprMapper.addEmpExpr(empExpr);
            if (affected > 0){
                log.info("员工经历添加成功");
            }
            else{
                log.error("员工经历添加失败");
            }
        }
    }
}
