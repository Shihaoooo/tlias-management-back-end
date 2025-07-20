package com.itheima.controller;

import com.itheima.pojo.clazz.ClazzContainDataStatistics;
import com.itheima.pojo.emp.EmpJobDataStatistics;
import com.itheima.pojo.result.Result;
import com.itheima.pojo.stu.StuDegreeDataStatistics;
import com.itheima.service.ClazzService;
import com.itheima.service.EmpService;
import com.itheima.service.StuService;
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
    private EmpService empService;
    @Autowired
    private StuService stuService;
    @Autowired
    private ClazzService clazzService;

    //统计员工职位人数
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        EmpJobDataStatistics empJobDataStatistics = empService.getEmpJobData();

        return Result.success(empJobDataStatistics);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<Object,Object>> genderData = empService.getEmpGenderData();

        return Result.success(genderData);
    }

    // 学员信息统计
    @GetMapping("/studentDegreeData")
    public Result getStuDegreeData(){
        log.info("统计学生学历信息");

        List<StuDegreeDataStatistics> list = stuService.getStuDegreeData();

        return Result.success(list);
    }

    // 班级人数统计
    @GetMapping("/studentCountData")
    public Result getClazzContainData(){
        log.info("统计班级人数");

        ClazzContainDataStatistics data = clazzService.getClazzContainData();

        return Result.success(data);
    }
}
