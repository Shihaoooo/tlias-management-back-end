package com.itheima.service;

import com.itheima.pojo.clazz.Clazz;
import com.itheima.pojo.clazz.ClazzContainDataStatistics;
import com.itheima.pojo.clazz.ClazzQueryParam;
import com.itheima.pojo.result.PageResult;

import java.util.List;

public interface ClazzService {

    // 查询所有班级信息
    PageResult<Clazz> getClazz(ClazzQueryParam clazzQueryParam);

    // 删除班级
    void deleteClazz(Integer id);

    // 添加班级
    void addClazz(Clazz clazz);

    // 根据id查询班级信息
    Clazz getClazzById(Integer id);

    // 修改班级信息
    void updateClazz(Clazz clazz);

    // 获取全部班级信息
    List<Clazz> getClazzList();

    // 统计各班级人数
    ClazzContainDataStatistics getClazzContainData();
}
