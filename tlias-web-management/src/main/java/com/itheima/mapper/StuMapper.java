package com.itheima.mapper;

import com.itheima.pojo.clazz.Clazz;
import com.itheima.pojo.stu.Degree;
import com.itheima.pojo.stu.Stu;
import com.itheima.pojo.stu.StuDegreeDataStatistics;
import com.itheima.pojo.stu.StuQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {

    // 分页查询学生信息
    List<Stu> getStu(StuQueryParam stuQueryParam);

    // 删除学生信息
    void deleteStu(List<Integer> ids);

    // 添加学员
    void addStu(Stu stu);

    // 根据id查询学生信息
    @Select("select * from student where id = #{id};")
    Stu getStuById(Integer id);

    // 修改学生信息
    void updateStu(Stu stu);

    // 记录学生违纪信息
    @Update("update student set violation_count = violation_count + 1 , " +
            "violation_score = violation_score + #{score} " +
            "where id = #{id} ")
    void violation(Integer id, Integer score);

    // 统计学生学历信息
    List<StuDegreeDataStatistics> getStuDegreeData();

    // 获取学历信息
    @Select("select * from degreeMapping")
    List<Degree> getDegree();

    // 获取班级信息
    @Select("select id,name from clazz")
    List<Clazz> getClazz();
}
