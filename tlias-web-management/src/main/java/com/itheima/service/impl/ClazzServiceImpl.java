package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.clazz.Clazz;
import com.itheima.pojo.clazz.ClazzQueryParam;
import com.itheima.pojo.result.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    // 查询全部班级信息
    @Override
    public PageResult<Clazz> getClazz(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getCurrentPage(), clazzQueryParam.getPageSize());

        Page<Clazz> p = (Page<Clazz>) clazzMapper.getClazz(clazzQueryParam);

        return new PageResult<>(p.getResult(),p.getTotal());
    }

    // 根据班级id查询信息
    @Override
    public Clazz getClazzById(Integer id){
        return clazzMapper.getClazzById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    // 删除班级
    @Override
    public void deleteClazz(Integer id) {
        clazzMapper.deleteClazz(id);

    }

    @Transactional(rollbackFor = Exception.class)
    // 添加班级
    @Override
    public void addClazz(Clazz clazz) {
        clazzMapper.addClazz(clazz);
    }

    // 修改班级信息
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateClazz(Clazz clazz) {
        clazzMapper.updateClazz(clazz);
    }

    // 获取全部班级信息
    @Override
    public List<Clazz> getClazzList() {
        return clazzMapper.getClazzList();
    }


}
