package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    public PageResult<Emp> queryEmp(String name, Integer gender , LocalDate date , Integer currentPage , Integer pageSize) {
        //1.设置分页参数
        PageHelper.startPage(currentPage,pageSize);
        //2.执行查询,并解释查询结果(将List强转位Page对象，因为Page对象继承了ArrayList，可以实现强转)
        Page<Emp> p = (Page<Emp>) empMapper.queryEmp(name,gender,date);

        return new PageResult<Emp>(p.getResult(),p.getTotal());
    }
}
