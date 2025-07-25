package com.itheima.mapper;

import com.itheima.pojo.emp.Emp;
import com.itheima.pojo.emp.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

//    // 分页查询(原始)
//    @Select("select e.name as username,e.gender,e.image,e.job,e.date,d.name as deptname,e.update_time from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{offset},#{pageSize}")
//    List<Emp> queryEmp(Integer offset, Integer pageSize);
    //    // 查询总记录数（原始）
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
//    Long getTotal();

    // 条件分页（PageHelper）查询(使用XML映射)
    //@Select("select e.name as username,e.gender,e.image,e.job,e.date,d.name as deptname,e.update_time from emp e left join dept d on e.dept_id = d.id " +
    //        "where username like '%#{name}%' and gender = #{gender} and date >= #{date} order by e.update_time desc")
    List<Emp> queryEmp(EmpQueryParam empQueryParam);

    // 添加员工
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, date, dept_id, create_time, update_time) "
    +"value(#{userName},#{empName},#{gender},#{phone},#{job},#{salary},#{image},#{date},#{deptId},current_date,current_date)")
    Integer addEmp(Emp emp);
    /*
     * 由于在添加员工的emp_id时，emp_id的值始终为空(因为id是先插入员工表后自动生成的id)
     * 这时候可以借助mybatis的主键返回功能来获取到id*/

    // 删除员工
    Integer deleteEmpByIds(List<Integer> ids);

    // 查询回显
    Emp queryEmpById(Integer id);

    // 修改员工
    void update(Emp emp);

    // 统计员工岗位信息
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    @MapKey("")
    List<Map<Object, Object>> getEmpGenderData();

    // 根据用户名和密码查询用户
    @Select("select id,username as userName,name from emp where username = #{userName} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
