package com.itheima.controller;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = {"http://localhost:90"
       ,"http://localhost:5173"}) //允许特定源跨域
public class DeptController {

    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    // 用 slf4j 注解来简化该对象的引入
    @Autowired //自动注入DeptService的bean（实现类）
    private DeptService deptService;

//    @RequestMapping(value = "/depts" ,produces = "application/json;charset=UTF-8", method = RequestMethod.GET)

    // 查询所有部门信息
    @GetMapping("/depts")
    public Result get(){

        //System.out.println("查询全部的部门数据");
        log.info("检索全部部门数据");
        List<Dept> deptList = deptService.findAll();
        if (!deptList.isEmpty()){
            log.info("检索成功");
            return Result.success(deptList);
        }
        else{
            log.error("检索失败");
            return Result.error("无可用数据");
        }
    }

    //根据id查询数据(拼接参数)
    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable("id") Integer id){
        //System.out.println("查询id为"+id+"的部门数据");
        log.info("检索id为{}的部门数据",id);
        Dept target = deptService.getById(id);

        if (target != null){
            log.info("查询成功");
            return Result.success(target.getName());
        }
        else{
            log.error("查询失败");
            return Result.error("没有找到该部门");
        }
    }

// delete方式一：   @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        String id_str = request.getParameter("id");
//        int id = Integer.parseInt(id_str);
//        System.out.println("删除id为"+id+"的部门");
//        return Result.success();
//    }


//    delete方式二：@DeleteMapping("/depts") //这是deletes请求
//    public Result delete(@RequestParam("id") Integer dept_id){
//        System.out.println("删除id为"+dept_id+"的部门");
//        return Result.success();
//
//    }

    // 根据id删除数据
    @Transactional
    @DeleteMapping("/depts")
    public Result delete( Integer id){
        //System.out.println("删除id为"+id+"的部门");
        log.info("删除id为{}的部门",id);
        Integer affected = deptService.deleteById(id);
        if(affected > 0){
            log.info("删除成功");
            return Result.success();
        }
        else{
            log.error("删除失败");
            return Result.error("删除失败");
        }
    }

    //添加部门(js对象)
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        String dept_name = dept.getName();
        //System.out.println("添加部门"+dept_name);
        log.info("添加部门{}",dept_name);

        Integer affected = deptService.addDept(dept_name);

        if (affected > 0){
            log.info("添加成功,{}条数据被影响",affected);
            return Result.success();
        }
        else{
            log.error("添加失败");
            return Result.error("添加失败");
        }
    }

    //通过id修改部门名称
    @PutMapping("/depts")
    public Result updateById(@RequestBody Dept dept){
        String newDeptName = dept.getName();

        Integer id = dept.getId();

        //System.out.println("修改id为"+id+"的部门名称为"+newDeptName);
        log.info("修改id为{}的部门名称为{}",id,newDeptName);

        Integer affected = deptService.updateById(id,newDeptName);

        if(affected > 0){
            log.info("修改成功，{}条数据被影响",affected);
            return Result.success();
        }
        else{
            log.error("修改失败");
            return Result.error("更新失败");
        }
    }
}
