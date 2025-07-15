package com.itheima.controller;

import com.itheima.pojo.stu.Stu;
import com.itheima.pojo.stu.StuQueryParam;
import com.itheima.pojo.result.PageResult;
import com.itheima.pojo.result.Result;
import com.itheima.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")

// 分页查询
public class StuController {
    @Autowired
    private StuService stuService;

    // 分页查询学生信息
    @GetMapping("")
    public Result getStu(StuQueryParam stuQueryParam) {
        log.info("分页查询学生数据{}", stuQueryParam);

        PageResult<Stu> stuList = stuService.getStu(stuQueryParam);

        return Result.success(stuList);
    }



    /*
    * 当路径参数的值以逗号分隔时，才能自动封装为List，否则
    * 只能封装为一个数组，要么就自定义一个转换器*/
    // 删除学员信息
    @DeleteMapping("/{ids}")
    public Result deleteStu(@PathVariable List<Integer> ids) {
        log.info("删除学员ids：{}",ids);

        stuService.deleteStu(ids);

        return Result.success();

    }

    @PostMapping("")
    public Result addStu(@RequestBody Stu stu) {
        log.info("添加学员：{}",stu);

        stuService.addStu(stu);

        return Result.success();
    }

    // 根据id查询学生信息
    @GetMapping("/{id}")
    public Result getStuById(@PathVariable Integer id) {
        log.info("查询学生信息,id:{}",id);

        Stu stu = stuService.getstuById(id);

        return Result.success(stu);
    }

    // 修改学生信息
    @PutMapping("")
    public Result updateStu(@RequestBody Stu stu) {
        log.info("修改学生的信息为：{}",stu);

        stuService.updateStu(stu);

        return Result.success();
    }

    // 学生违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable("id") Integer id, @PathVariable("score") Integer score) {
        log.info("记录学生违纪信息，id:{},score:{}",id,score);

        stuService.violation(id,score);

        return Result.success();
    }

}
