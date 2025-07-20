package com.itheima.service;

import com.itheima.pojo.stu.Stu;
import com.itheima.pojo.stu.StuDegreeDataStatistics;
import com.itheima.pojo.stu.StuQueryParam;
import com.itheima.pojo.result.PageResult;

import java.util.List;

public interface StuService {

    // 分页查询学生数据
    PageResult<Stu> getStu(StuQueryParam stuQueryParam);

    // 删除学生信息
    void deleteStu(List<Integer> ids);

    // 添加学员
    void addStu(Stu stu);

    // 根据id查询学生信息
    Stu getstuById(Integer id);

    // 修改学生信息
    void updateStu(Stu stu);

    // 添加学生违纪信息
    void violation(Integer id, Integer score);

    // 统计学生学历信息
    List<StuDegreeDataStatistics> getStuDegreeData();
}
