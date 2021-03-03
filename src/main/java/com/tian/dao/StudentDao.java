package com.tian.dao;

import com.tian.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentDao {
    @Select("select * from student")
    @Results(id = "stuMap",
    value = {
            @Result(id = true,column = "stuid",property = "stuid"),
            @Result(column = "stupassword",property = "stupassword"),
            @Result(column = "stuname",property = "stuname"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "dormid",property = "dormid"),
            @Result(column = "college",property = "college"),
            @Result(column = "major",property = "major")
    })
    public List<Student> findAll();

    @Insert("insert into student (stupassword,stuname,gender,dormid,college,major) values (#{stupassword},#{stuname},#{gender},#{dormid},#{college},#{major})")
    public void saveStudent(Student stu);

    @Update("update student set stupassword=#{stupassword},stuname=#{stuname},gender=#{gender},dormid=#{dormid},college=#{college},major=#{major} where stuid = #{stuid} ")
    public Integer update(Student student);

    @Delete("delete from student where stuid = #{stuid}")
    public void delete(Integer stuid);

    @Select("select * from student where stuid = #{stuid}")
    @ResultMap("stuMap")
    public Student findbystuid(Integer stuid);

    @Select("select * from student where dormid = #{dormid}")
    @ResultMap("stuMap")
    public List<Student> findbydormid(Integer dormid);

    @Select("select * from student where concat(stuid,stupassword,IFNULL(stuname,''),IFNULL(gender,''),IFNULL(dormid,''),IFNULL(college,''),IFNULL(major,''),IFNULL(telephone,'')) like #{str}")
    @ResultMap("stuMap")
    public List<Student> fuzzyQuery(String str);

}
