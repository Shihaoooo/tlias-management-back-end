package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.dept.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    // 查询全部部门信息
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    // 根据部门id删除部门信息
    @Override
    @Transactional
    public Integer deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }

    // 添加部门
    @Override
    @Transactional
    public Integer addDept(String deptName) {
        return deptMapper.addDept(deptName);

    }

    // 根据部门id查询部门信息
    @Override
    public Dept getById(Integer id){

        return deptMapper.getById(id);
    }

    // 根据部门id修改部门信息
    @Override
    @Transactional
    public Integer updateById(Integer id, String newDeptName) {

        return deptMapper.updateById(id, newDeptName);
    }
}
