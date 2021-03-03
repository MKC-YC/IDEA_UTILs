package com.tian.dao;

import com.tian.domain.Dorm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface DormDao {
    /*
    * 联合查询宿舍和学生和宿舍评比
    * 宿舍1->学生n
    * 宿舍n->评比n
    * o
    * */
    @Select("select * from dorm")
    @Results(id = "dormMap",value = {
            @Result(id = true,column = "dormid",property = "dormid"),
            @Result(column = "apartmentid",property = "apartmentid"),
            @Result(column = "door",property = "door"),
            @Result(column = "lamp",property = "lamp"),
            @Result(column = "bed",property = "bed"),
            @Result(column = "watertap",property = "watertap"),
            @Result(column = "shower",property = "shower"),
            @Result(column = "toilet",property = "toilet"),
            @Result(column = "comment",property = "comment"),
            @Result(column = "dormid",property = "students",many = @Many(
                    select = "com.tian.dao.StudentDao.findbydormid",
                    fetchType = FetchType.LAZY
            )),
            @Result(column = "dormid",property = "evaRecords",many = @Many(
                    select = "com.tian.dao.EvaRecordDao.getEvaRecordByDormid",
                    fetchType = FetchType.LAZY
            ))
    })
    List<Dorm> findAll();

    //ok
    @Insert("insert into dorm(apartmentid,door,lamp,bed,watertap,shower,toilet,comment) values(#{apartmentid},#{door},#{lamp},#{bed},#{watertap},#{shower},#{toilet},#{comment}) ")
    public void addDorm(Dorm dorm);
    //o
    @Delete("delete from dorm where dormid = #{dormid}")
    public void delete(Integer dormid);
    //o
    @Update("update dorm set apartmentid= #{apartmentid},door = #{door},lamp = #{lamp},bed = #{bed},watertap = #{watertap},shower = #{shower}, toilet = #{toilet},comment= #{comment} where dormid = #{dormid}")
    public Integer updateDorm(Dorm dorm);
    //o
    @Select("select * from dorm where dormid = #{dormid}")
    @ResultMap("dormMap")
    public Dorm findOne(Integer dormid);

    //根据evaid查询dorm
    @Select("select * from dorm where dormid in (select distinct dormid from dormtoevarecord where evarecordid = #{evarecordid})")
    @Results(id = "dormbase",value = {
            @Result(id = true,column = "dormid",property = "dormid"),
            @Result(column = "apartmentid",property = "apartmentid"),
            @Result(column = "door",property = "door"),
            @Result(column = "lamp",property = "lamp"),
            @Result(column = "bed",property = "bed"),
            @Result(column = "watertap",property = "watertap"),
            @Result(column = "shower",property = "shower"),
            @Result(column = "toilet",property = "toilet"),
            @Result(column = "comment",property = "comment")
    }
    )
    public List<Dorm> getDormByEvaid(Integer evaRecordid);

    @Insert("insert into dormtoevarecord(evarecordid,dormid) values(#{param1},#{param2})")
    public void addDormAndEva(Integer evarecordid,Integer dormid);

    @Delete("delete from dormtoevarecord where evarecordid = #{evaRecordId} and dormid = #{dormId}")
    public void deleteDormAndRec(Integer evaRecordId,Integer dormId);

    @Insert("update student set dormid =#{dormId} where stuid = #{stuId}")
    public void addDormAndStudent(Integer dormId,Integer stuId);

    @Select("select count(*) from student where dormid = #{dormId}")
    public Integer currentNumber(Integer dormId);

    @Select("select * from dorm where concat(dormid,apartmentid,IFNULL(comment,'')) like #{str}")
    @ResultMap("dormMap")
    public List<Dorm> fuzzyQuery(String str);

    @Select("select dormid from dorm ")
    public List<Integer> selectDormId();

    @Select("select * from dorm where door = 0 or lamp = 0 or bed = 0 or watertap = 0 or shower = 0 or toilet = 0")
    public List<Dorm> findDamagedDorm();



    @Select("select * from dorm where dormid  not in (select distinct dormid from dormtoevarecord where evarecordid = #{evarecordid} )")
    @ResultMap("dormbase")
    public List<Dorm> getnotDormByEvarecordid(Integer evarecordid);
}
