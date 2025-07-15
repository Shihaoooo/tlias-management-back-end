package com.itheima.mapper;

import com.itheima.pojo.clazz.Clazz;
import com.itheima.pojo.clazz.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    // 查询所有班级
    List<Clazz> getClazz(ClazzQueryParam clazzQueryParam);

    // 删除班级
    @Delete("delete from clazz where id =#{id}")
    void deleteClazz(Integer id);

    //新增班级
    @Insert("insert into clazz(name,room,begin_date,end_date,master_id,subject,create_time,update_time)" +
            "value(#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},current_date(),current_date())")
    void addClazz(Clazz clazz);

    // 根据id查询班级信息
    @Select("select id,name,room,begin_date,end_date,master_id,subject,create_time,update_time from clazz where id = #{id}")
    Clazz getClazzById(Integer id);

    // 修改班级信息
    void updateClazz(Clazz clazz);

    // 获取全部班级信息
    @Select("select * from clazz;")
    List<Clazz> getClazzList();
}
