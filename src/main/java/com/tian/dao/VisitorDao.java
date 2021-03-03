package com.tian.dao;

import com.tian.domain.Visitor;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Vector;

@Component
public interface VisitorDao {
    @Select("select * from visitor ")
    @Results(id = "visitorMap",value = {
            @Result(id = true,column = "vid",property = "vid"),
            @Result(column = "viname",property = "viname"),
            @Result(column = "vitime",property = "vitime"),
            @Result(column = "telephone",property = "telephone"),
            @Result(column = "remark",property = "remark")
    })
    public List<Visitor> findAll();

    @Insert("insert into visitor(viname,vitime,telephone,remark) values(#{viname},#{vitime},#{telephone},#{remark})")
    public void add(Visitor visitor);

    @Delete("delete from visitor where vid = #{vid}")
    public void  delete(Integer vid);

    @Update("update visitor set viname = #{viname} ,vitime = #{vitime}, telephone = #{telephone} ,remark = #{remark} where vid = #{vid}")
    public void update(Visitor visitor);

    @Select("select * from where concat(vid,IFNULL(viname,''),IFNULL(vitime,''),IFNULL(telephone,''),IFNULL(remark,'')) like #{str}")
    public List<Visitor> fuzzyQuery(String str);

    @Select("select * from visitor where vid = #{vid}")
    public Visitor findOne(Integer vid);
}
