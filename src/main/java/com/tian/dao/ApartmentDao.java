package com.tian.dao;

import com.tian.domain.Apartment;
import com.tian.domain.Dorm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApartmentDao {
    @Select("select * from apartment")
    @Results(id = "apartmentMap",value = {
            @Result(id = true,column = "apartmentid",property = "apartmentid"),
            @Result(column = "fee",property = "fee"),
            @Result(column = "maxoccupancy",property = "maxoccupancy"),
            @Result(column = "apartmentid",property = "dorms",many = @Many(
                    select = "com.tian.dao.ApartmentDao.selectDormid",
                    fetchType = FetchType.LAZY
            ))
    })
    public List<Apartment> findAll();

    @Insert("insert into apartment(fee,maxoccupancy) values(#{fee},#{maxoccupancy})")
    public void add(Apartment ap);


    @Update("update apartment set fee = #{fee}, maxoccupancy = #{maxoccupancy} where apartmentid = #{apartmentid}")
    public Integer update(Apartment ap);

    @Select("select * from dorm where apartmentid = #{apartmentId}")
    public List<Dorm> selectDormid(Integer apartmentId);

    //当前在公寓的学生人数
    @Select("select count(*) from student where dormid in (SELECT dormid from apartment where apartmentid = #{apartmentId})")
    public Integer currentNumber(Integer apartmentId);

    @Select("select * from apartment where apartmentid = #{apartmentid}")
    @ResultMap("apartmentMap")
    public Apartment findOne(Integer apartmentid);

    @Select("select apartmentid from apartment ")
    public List<Integer> selectApartmentId();

    @Delete("delete from apartment where apartmentid = #{apartmentid}")
    public  void  delete(Integer apartmentid);
}
