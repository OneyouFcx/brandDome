package com.icei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.Award;

public interface AwardMapper {
	
	/**
	 * 根据Id查询全部
	 * @return
	 */
	List<Award> getAllmsg(@Param("userName")String userName,@Param("awardTypeId")int awardTypeid,@Param("page")int page,@Param("limit")int limit);
	
	/**
	 * 查询总条数/根据id
	 * @param awardTypeid
	 * @return
	 */
	int getAllmsgCount(@Param("userName")String userName,@Param("awardTypeId")int awardTypeid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int deleteByPrimaryKey(Integer awardId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int insert(Award record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int insertSelective(Award record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    Award selectByPrimaryKey(Integer awardId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int updateByPrimaryKeySelective(Award record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated Sun May 20 11:21:13 CST 2018
     */
    int updateByPrimaryKey(Award record);
}