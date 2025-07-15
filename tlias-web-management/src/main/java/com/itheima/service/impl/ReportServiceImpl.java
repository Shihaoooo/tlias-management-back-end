package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.emp.EmpJobDataStatistics;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    EmpMapper empMapper;

    @Override

    // 统计员工职位人数
    public EmpJobDataStatistics getEmpJobData() {
        // 1 调用mapper接口，获取统计数据
        List<Map<String,Object>> list = empMapper.countEmpJobData();

        List<Object> jobList = list.stream().map(dataMap ->dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap ->dataMap.get("num")).toList();

        return new EmpJobDataStatistics(jobList,dataList);

    }

    @Override
    public List<Map<Object, Object>> getEmpGenderData() {
        return empMapper.getEmpGenderData();
    }
}
