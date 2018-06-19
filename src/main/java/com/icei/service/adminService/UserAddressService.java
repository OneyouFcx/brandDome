package com.icei.service.adminService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.icei.domain.UserAddress;
import com.icei.mapper.UserAddressMapper;
import org.springframework.stereotype.Service;

/**
 * 用户地址
 * @author 小诺诺
 *
 */
@Service
public class UserAddressService {
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	/**
	 * 获取用户所有地址
	 * @param userId
	 * @return
	 */
	public List<UserAddress> getUserAddress(Integer userId){
		return userAddressMapper.getUserAddress(userId);
	}
	/**
	 * 添加用户地址返回插入列
	 * @param userAddress
	 * @return
	 */
	public UserAddress addUserAddress(UserAddress userAddress) {

		System.out.println(userAddressMapper.insertSelective(userAddress));
		System.out.println(userAddress.getAddressId());
		return userAddressMapper.selectByPrimaryKey(userAddress.getAddressId());
	}
	/**
	 * 删除用户地址
	 * @param addressId
	 * @return
	 */
	public int delUserAddress(Integer addressId,Integer userId){
		return userAddressMapper.delUserAdress(addressId,userId);
	}
	/**
	 * 根据地址id获取地址信息
	 * @param addressId
	 * @return
	 */
	public  UserAddress ByOrderIdGetAddress(int addressId){
		return userAddressMapper.ByOrderIdGetAddress(addressId);
	}
}
