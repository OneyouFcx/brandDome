package com.icei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.PowerRole;

public interface PowerRoleMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table power_role
	 *
	 * @mbg.generated Thu Apr 19 10:27:54 CST 2018
	 */
	int deleteByPrimaryKey(Integer roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table power_role
	 *
	 * @mbg.generated Thu Apr 19 10:27:54 CST 2018
	 */
	int insert(PowerRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table power_role
	 *
	 * @mbg.generated Thu Apr 19 10:27:54 CST 2018
	 */
	int insertSelective(PowerRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table power_role
	 *
	 * @mbg.generated Thu Apr 19 10:27:54 CST 2018
	 */
	PowerRole selectByPrimaryKey(Integer roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table power_role
	 *
	 * @mbg.generated Thu Apr 19 10:27:54 CST 2018
	 */
	int updateByPrimaryKeySelective(PowerRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table power_role
	 *
	 * @mbg.generated Thu Apr 19 10:27:54 CST 2018
	 */
	int updateByPrimaryKey(PowerRole record);

	List<PowerRole> getAllRoles();
	
	int addNewRole(@Param("name")String name);
	
	int delRole(@Param("roleId")int roleId);
}