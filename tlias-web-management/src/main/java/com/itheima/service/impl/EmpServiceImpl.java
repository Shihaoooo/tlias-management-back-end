
package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.emp.Emp;
import com.itheima.pojo.emp.EmpExpr;
import com.itheima.pojo.emp.EmpJobDataStatistics;
import com.itheima.pojo.emp.EmpQueryParam;
import com.itheima.pojo.login.LoginInfo;
import com.itheima.pojo.result.PageResult;
import com.itheima.service.EmpService;
import com.itheima.utils.JWTUtils;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private JWTUtils jwtUtils;

    // 分页查询
    @Override
    public PageResult<Emp> queryEmp(EmpQueryParam empQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(empQueryParam.getCurrentPage(),empQueryParam.getPageSize());
        //2.执行查询,并解释查询结果(将List强转位Page对象，因为Page对象继承了ArrayList，可以实现强转)
        Page<Emp> p = (Page<Emp>) empMapper.queryEmp(empQueryParam);

        return new PageResult<>(p.getResult(),p.getTotal());
    }

    // 添加员工
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addEmp(Emp emp){
        // 1.保存员工基本信息
        Integer affectedOnEmp =  empMapper.addEmp(emp);

        // 2.当员工工作经历不为空时，才添加工作经历
        if (!CollectionUtils.isEmpty(emp.getEmpExprList())){
            _addEmpExpr(emp);
        }

        return affectedOnEmp;
    }

    // 保存员工工作经历(保证不会被外部意外调用)
    @Transactional(rollbackFor = Exception.class)
    public void _addEmpExpr(Emp emp){
        // 1.批量为Expr对象的empId赋值（emp的id已用主键返回获取并封装）
        for(EmpExpr expr : emp.getEmpExprList()){
            expr.setEmpId(emp.getId());
        }

        // 2.判断
        Integer affected = empExprMapper.addEmpExpr(emp.getEmpExprList());

        if (affected!=null && affected > 0){
            log.info("员工经验插入成功");
        }
        else{
            log.error("员工经验插入失败");
        }

    }

    // 根据Id删除员工
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteEmpByIds(List<Integer> ids){

        // 1.删除员工基本信息
        empMapper.deleteEmpByIds(ids);

        // 2.删除员工经历信息
        empExprMapper.deleteEmpExprByIds(ids);
    }

    // 根据id查询员工
    @Override
    public Emp queryEmpById(Integer id){
        return empMapper.queryEmpById(id);
    }

    // 修改员工
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Emp emp){
        // 1.根据Id修改员工基本信息
        empMapper.update(emp);

        // 2.根据Id修改员工工作经历信息(先删，后加)
        empExprMapper.deleteEmpExprByIds(Arrays.asList(emp.getId()));

        empExprMapper.addEmpExpr(emp.getEmpExprList());
    }

    // 统计员工岗位人数
    public EmpJobDataStatistics getEmpJobData() {
        // 1 调用mapper接口，获取统计数据
        List<Map<String,Object>> list = empMapper.countEmpJobData();

        List<Object> jobList = list.stream().map(dataMap ->dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap ->dataMap.get("num")).toList();

        return new EmpJobDataStatistics(jobList,dataList);

    }

    // 统计员工性别人数
    @Override
    public List<Map<Object, Object>> getEmpGenderData() {
        return empMapper.getEmpGenderData();
    }

    // 员工登陆
    @Override
    public LoginInfo login(Emp emp) {
        // 1.调用mapper接口
        Emp e = empMapper.selectByUsernameAndPassword(emp);

        if (e != null){
            log.info("登陆,员工信息{}",emp);

            // 生成Jwt令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUserName());

            String jwt = jwtUtils.createJWT(claims);
            return new LoginInfo(e.getId(),e.getUserName(),e.getEmpName(),jwt);
        }
        log.info("登陆失败");
        return null;

    }


}
