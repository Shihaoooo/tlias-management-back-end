package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
//    @Results(
//            {
//                    @Result(column = "create_time",property = "createTime"),
//                    @Result(column = "update_time",property = "updateTime")
//            }
//    )

    //Select("select id, name, create_time ceateTime, update_time updateTime from dept order by update_time DESC")

    @Select("select id, name, create_time , update_time  from dept order by id ASC")
    List<Dept> findAll();

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    @Delete("delete from dept where id = #{id}")
    Integer deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time)" +
            " values(#{name}, now(), now())")
    Integer addDept(String deptName);

    @Update("update dept set name=#{newDeptName},update_time=now() where id=#{id}")
    Integer updateById(Integer id, String newDeptName);
}
