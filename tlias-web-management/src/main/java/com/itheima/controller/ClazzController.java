package com.itheima.controller;

import com.itheima.pojo.clazz.Clazz;
import com.itheima.pojo.clazz.ClazzQueryParam;
import com.itheima.pojo.result.PageResult;
import com.itheima.pojo.result.Result;
import com.itheima.service.ClazzService;
import com.itheima.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    ClazzService clazzService;
    @Autowired
    private StuService stuService;

    // 查询班级信息
    @GetMapping("")
    public Result getClazz(ClazzQueryParam clazzQueryParam) {
        log.info("获取全部班级信息");

        PageResult<Clazz> clazz =  clazzService.getClazz(clazzQueryParam);

        return Result.success(clazz);
    }


    // 根据id查询班级信息
    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable("id") Integer id) {
        log.info("根据id{}查询班级信息",id);

        Clazz clazz = clazzService.getClazzById(id);

        return Result.success(clazz);
    }

    // 删除班级
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable("id") Integer id) {
        log.info("删除班级的id为{}",id);

        clazzService.deleteClazz(id);

        return Result.success();
    }

    // 添加班级
    @PostMapping("")
    public Result addClazz(@RequestBody Clazz clazz) {
        log.info("添加班级{}",clazz);

        clazzService.addClazz(clazz);

        return Result.success();
    }

    // 修改班级
    @PutMapping("")
    public Result updateClazz(@RequestBody Clazz clazz) {
        log.info("修改班级{}",clazz);

        clazzService.updateClazz(clazz);

        return Result.success();

    }

    // 查询所有班级
    @GetMapping("/list")
    public Result getClazzList() {
        log.info("获取全部班级信息");

        List<Clazz> clazzList = clazzService.getClazzList();

        return Result.success(clazzList);
    }


}
