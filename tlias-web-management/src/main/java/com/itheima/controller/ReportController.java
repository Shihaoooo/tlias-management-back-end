package com.itheima.controller;

import com.itheima.pojo.emp.EmpJobDataStatistics;
import com.itheima.pojo.result.Result;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    //统计员工职位人数
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        EmpJobDataStatistics empJobDataStatistics = reportService.getEmpJobData();

        return Result.success(empJobDataStatistics);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<Object,Object>> genderData = reportService.getEmpGenderData();

        return Result.success(genderData);
    }
}
