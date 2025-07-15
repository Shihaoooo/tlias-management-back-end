package com.itheima.controller;

import com.itheima.pojo.emp.Emp;
import com.itheima.pojo.emp.EmpQueryParam;
import com.itheima.pojo.result.PageResult;
import com.itheima.pojo.result.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
@CrossOrigin(origins = {"http://localhost:90"
        ,"http://localhost:5173"}) //允许特定源跨域
public class EmpController {

    @Autowired
    private EmpService empService;

    //    @GetMapping("")
//    public Result queryEmp(String name,
//                           Integer gender,
//                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
//                           @RequestParam(defaultValue = "1") Integer currentPage,
//                           @RequestParam(defaultValue = "20") Integer pageSize){
//
//
//        PageResult<Emp> page = empService.queryEmp(name,gender,date,currentPage,pageSize);
//
//        if(page != null){
//            log.info("条件分页查询第{}页",currentPage);
//            log.info("查询条件:name={},gender={},date={}",name,gender,date);
//
//            return Result.success(page);
//        }
//        else{
//            log.error("查询失败");
//            return Result.error("查询失败");
//        }
//    }
    // 分页查询
    @GetMapping("")
    public Result queryEmp(EmpQueryParam empQueryParam) {

        log.info("分页查询:{},{},{},{},{}",empQueryParam.getName(),empQueryParam.getGender(),empQueryParam.getDate(),empQueryParam.getCurrentPage(),empQueryParam.getPageSize());
        System.out.println(empQueryParam.getName());
        PageResult<Emp> pageResult = empService.queryEmp(empQueryParam);

        if(pageResult !=null){
            log.info("查询成功");
            return Result.success(pageResult);
        }
        else{
            log.error("查询失败");
            return Result.error("查询失败");
        }
    }

    // 添加员工
    @PostMapping("")
    public Result addEmp(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);

        Integer affected = empService.addEmp(emp);
        if(affected > 0){
            log.info("新增成功");
            return Result.success();
        }
        else{
            log.error("添加失败");
            return Result.error("添加失败");
        }
    }

    // 删除员工
    @DeleteMapping("")
    public Result deleteEmp(@RequestParam("ids") List<Integer> ids){
        // 1. 删除员工基本信息 和 员工经验信息
        empService.deleteEmpByIds(ids);

        return Result.success();

    }

    // 查询回显
    @GetMapping("/{id}")
    public Result queryEmpById(@PathVariable Integer id){
        log.info("根据ID:{}查询员工信息",id);

        Emp emp = empService.queryEmpById(id);

        return Result.success(emp);

    }

    // 修改员工信息
    @PutMapping("")
    public Result update(@RequestBody Emp emp){
        log.info("修改员工:\n{}",emp);

        empService.update(emp);

        return Result.success();
    }

}
