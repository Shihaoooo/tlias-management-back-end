package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StuMapper;
import com.itheima.pojo.clazz.Clazz;
import com.itheima.pojo.stu.Degree;
import com.itheima.pojo.stu.Stu;
import com.itheima.pojo.stu.StuDegreeDataStatistics;
import com.itheima.pojo.stu.StuQueryParam;
import com.itheima.pojo.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.service.StuService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StuServiceImpl implements StuService{

    @Autowired
    private StuMapper stuMapper;

    // 分页查询学生数据
    @Override
    public PageResult<Stu> getStu(StuQueryParam stuQueryParam) {
        PageHelper.startPage(stuQueryParam.getCurrentPage(), stuQueryParam.getPageSize());

        Page<Stu> p = (Page<Stu>) stuMapper.getStu(stuQueryParam);

        return new PageResult<>(p.getResult(), p.getTotal());
    }

    // 删除学生信息
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteStu(List<Integer> ids) {
        stuMapper.deleteStu(ids);
    }

    // 添加学员
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addStu(Stu stu) {
        stuMapper.addStu(stu);
    }

    // 根据id查询学生信息
    @Override
    public Stu getstuById(Integer id) {
        return stuMapper.getStuById(id);
    }

    // 修改学生信息
    @Override
    public void updateStu(Stu stu) {
        stuMapper.updateStu(stu);

    }

    // 添加学生违纪信息
    @Override
    public void violation(Integer id, Integer score) {
        stuMapper.violation(id,score);

    }

    // 统计学生学历信息
    @Override
    public List<StuDegreeDataStatistics> getStuDegreeData() {
        return stuMapper.getStuDegreeData();
    }

    // 获取学历信息
    @Override
    public List<Degree> getDegree() {
        return stuMapper.getDegree();
    }

    // 获取班级信息
    @Override
    public List<Clazz> getClazz() {
        return stuMapper.getClazz();
    }
}
