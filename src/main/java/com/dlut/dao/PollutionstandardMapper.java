package com.dlut.dao;

import com.dlut.pojo.Pollutionstandard;
import com.dlut.pojo.PollutionstandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PollutionstandardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    int countByExample(PollutionstandardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    int deleteByExample(PollutionstandardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    @Delete({
        "delete from pollutionstandard",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    @Insert({
        "insert into pollutionstandard (id, ph_low, ",
        "ph_high, Cr, Ni, ",
        "Cu, Zn, _As, ",
        "Cd, Hg, Pb)",
        "values (#{id,jdbcType=INTEGER}, #{phLow,jdbcType=REAL}, ",
        "#{phHigh,jdbcType=REAL}, #{cr,jdbcType=REAL}, #{ni,jdbcType=REAL}, ",
        "#{cu,jdbcType=REAL}, #{zn,jdbcType=REAL}, #{as,jdbcType=REAL}, ",
        "#{cd,jdbcType=REAL}, #{hg,jdbcType=REAL}, #{pb,jdbcType=REAL})"
    })
    int insert(Pollutionstandard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    int insertSelective(Pollutionstandard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    List<Pollutionstandard> selectByExample(PollutionstandardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, ph_low, ph_high, Cr, Ni, Cu, Zn, _As, Cd, Hg, Pb",
        "from pollutionstandard",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Pollutionstandard selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Pollutionstandard record, @Param("example") PollutionstandardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Pollutionstandard record, @Param("example") PollutionstandardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Pollutionstandard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollutionstandard
     *
     * @mbggenerated
     */
    @Update({
        "update pollutionstandard",
        "set ph_low = #{phLow,jdbcType=REAL},",
          "ph_high = #{phHigh,jdbcType=REAL},",
          "Cr = #{cr,jdbcType=REAL},",
          "Ni = #{ni,jdbcType=REAL},",
          "Cu = #{cu,jdbcType=REAL},",
          "Zn = #{zn,jdbcType=REAL},",
          "_As = #{as,jdbcType=REAL},",
          "Cd = #{cd,jdbcType=REAL},",
          "Hg = #{hg,jdbcType=REAL},",
          "Pb = #{pb,jdbcType=REAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Pollutionstandard record);
}