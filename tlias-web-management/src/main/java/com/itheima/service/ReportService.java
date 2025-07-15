package com.itheima.service;

import com.itheima.pojo.emp.EmpJobDataStatistics;

import java.util.List;
import java.util.Map;

public interface ReportService {

    EmpJobDataStatistics getEmpJobData();

    List<Map<Object, Object>> getEmpGenderData();
}
