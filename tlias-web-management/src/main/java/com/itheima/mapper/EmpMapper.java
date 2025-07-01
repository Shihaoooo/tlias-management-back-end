package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.time.LocalDate;
import java.util.List;

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
    List<Emp> queryEmp(String name, Integer gender, LocalDate date);


    // 添加员工
    @Insert("insert into emp value(#{name},#{gender},#{image},#{deptName},#{job},now(),now())")
    boolean addEmp(String name, String gender, String image, String deptName, String job);

    // 删除员工
    @Delete("#")
    boolean deleteEmp();



}
