package com.tian.dao;

import com.tian.domain.Dorm;
import com.tian.domain.EvaRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EvaRecordDao {

    @Insert("insert into evarecord(title,content) values(#{title},#{content}) ")
    public void insertRec(EvaRecord record);

    @Delete("delete from evarecord where evaRecordid = #{recid}")
    public void deleteRec(Integer recid);

    @Update("update evarecord set title = #{title} , content = #{content} where evaRecordid = #{evaRecordid}")
    public Integer updateRec(EvaRecord rec);

    /*
    * 这个拿到List<Dorm> dorms
    * */
    @Select("select * from evarecord ")
    @Results(id = "evaRecordMap",value = {
            @Result(id = true,column = "evaRecordid",property = "evaRecordid"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "evaRecordid",property = "dorms",many = @Many(
                    select = "com.tian.dao.DormDao.getDormByEvaid",
                    fetchType = FetchType.LAZY
            ))
    })
    public List<EvaRecord> findAll();

    @Select("select * from evarecord where evaRecordid = #{evaRecordid}")
    @ResultMap("evaRecordMap")
    public EvaRecord findByRecId(Integer recId);

    //根据寝室id查询所有评价
    @Select("select * from evarecord where evaRecordid in ( select evarecordid from dormtoevarecord where dormid = #{dormid} )")
    public List<EvaRecord> getEvaRecordByDormid(Integer dormid);

    @Select("select * from evarecord where concat(evaRecordid,IFNULL(title,''),IFNULL(content,'')) like #{str}")
    public List<EvaRecord> fuzzyQuery(String str);

    @Select("select distinct dormid from dormtoevarecord where evarecordid = #{evarecordid}")
    public List<Integer> getDormidByevarecordid(Integer evarecordid);

}
