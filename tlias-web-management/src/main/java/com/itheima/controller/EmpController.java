package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RequestMapping("/emps")
@RestController
@CrossOrigin(origins = {"http://localhost:90"
        ,"http://localhost:5173"}) //允许特定源跨域
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("")
    public Result queryEmp(String name,
                           Integer gender,
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                           @RequestParam(defaultValue = "1") Integer currentPage,
                           @RequestParam(defaultValue = "20") Integer pageSize){

        PageResult<Emp> page = empService.queryEmp(name,gender,date,currentPage,pageSize);

        if(page != null){
            log.info("条件分页查询第{}页",currentPage);
            log.info("查询条件:name={},gender={},date={}",name,gender,date);

            return Result.success(page);
        }
        else{
            log.error("查询失败");
            return Result.error("查询失败");
        }
    }


}
