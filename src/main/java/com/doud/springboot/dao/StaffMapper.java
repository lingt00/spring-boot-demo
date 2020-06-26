package com.doud.springboot.dao;

import com.doud.springboot.model.Staff;
import com.doud.springboot.model.StaffCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {
    /**
     *
     * @mbg.generated 2020-06-25
     */
    long countByExample(StaffCriteria example);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int deleteByExample(StaffCriteria example);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int insert(Staff record);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int insertSelective(Staff record);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    List<Staff> selectByExample(StaffCriteria example);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    Staff selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffCriteria example);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int updateByExample(@Param("record") Staff record, @Param("example") StaffCriteria example);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int updateByPrimaryKeySelective(Staff record);

    /**
     *
     * @mbg.generated 2020-06-25
     */
    int updateByPrimaryKey(Staff record);
}