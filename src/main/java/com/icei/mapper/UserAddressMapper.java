package com.icei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.UserAddress;

public interface UserAddressMapper {
	
	/**
	 * 根据地址Id获取地址信息
	 * @param addressId
	 * @return
	 */
	 UserAddress ByOrderIdGetAddress(@Param("addressId")int addressId);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_address
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int deleteByPrimaryKey(Integer addressId);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_address
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insert(UserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_address
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insertSelective(UserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_address
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    UserAddress selectByPrimaryKey(Integer addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_address
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKeySelective(UserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_address
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKey(UserAddress record);
    
    /**
     * 获取用户所有地址
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddress(@Param("userId")Integer userId);

    /**
     * 删除用户地址
     * @param addressId
     * @param userId
     * @return
     */
    int delUserAdress(@Param("addressId") Integer addressId,@Param("userId") Integer userId);
}