package com.tian.dao;

import com.tian.domain.Administrator;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorDao {

    @Select("select * from administrator ")
    public List<Administrator> findAll();

    @Insert("insert into administrator(ad_name,password,permission) values(#{ad_name},#{password},#{permission})")
    public void addAdministrator(Administrator administrator);

    @Select("select * from administrator where ad_name = #{ad_name} and password = #{password}")
    public Administrator selectOne(String ad_name,String password);

    @Select("select * from administrator where ad_name = #{ad_name}")
    public Administrator findByAd_name(String ad_name);

    @Update("update administrator set ad_name = #{ad_name} ,password = #{password} ,permission = #{permission} where ad_id = #{ad_id}")
    public void  update(Administrator administrator);

    @Delete("delete from administrator where ad_id = #{ad_id}")
    public void delete(Integer ad_id);

    @Select("select * from administrator where ad_id = #{ad_id}")
    public Administrator findOne(Integer ad_id);
}
