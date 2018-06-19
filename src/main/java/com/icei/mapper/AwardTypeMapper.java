package com.icei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.AwardType;

public interface AwardTypeMapper {
	
	List<AwardType> getName(@Param("page")int page,@Param("limit")int limit);
	
	int getNameCount();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award_type
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int deleteByPrimaryKey(Integer awardTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award_type
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int insert(AwardType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award_type
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int insertSelective(AwardType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award_type
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    AwardType selectByPrimaryKey(Integer awardTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award_type
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int updateByPrimaryKeySelective(AwardType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award_type
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int updateByPrimaryKey(AwardType record);
}