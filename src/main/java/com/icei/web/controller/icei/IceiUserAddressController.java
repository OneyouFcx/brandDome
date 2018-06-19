package com.icei.web.controller.icei;


import alicom.api.utils.GeocodingUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.icei.domain.UserAddress;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.UserAddressService;
import com.icei.utils.ResultUtil;

/**
 * 用户地址
 * @author 小诺诺
 *
 */
@Controller
@RequestMapping("icei")
public class IceiUserAddressController {
	@Autowired
	private UserAddressService userAddressService;

	/**
	 * 逆地址
	 * @param precision
	 * @param dimensionality
	 * @return
	 */
	@ResponseBody
	@GetMapping("getGeocoding")
	public Object getGeocoding(@Param("precision") String precision,@Param("dimensionality")String dimensionality){
		return GeocodingUtil.Geocoding(precision,dimensionality);
	}
	/**
	 * 获取用户所有地址
	 * @return
	 */
	@ResponseBody
	@GetMapping("getUserAddress")
	public Object getUserAddress(){
		Integer userId=1;
		if(userId!=null) {
			return ResultUtil.success(userAddressService.getUserAddress(userId));
		}else {
			throw new  IceiExeption(ResultEnums.IS_LOGIN);//未登录
		}
	}

	/**
	 * 添加地址
	 * @param userAddress
	 * @return
	 */
	@ResponseBody
	@PostMapping("addUserAddress")
	public Object addUserAddress(@ModelAttribute UserAddress userAddress){
		Integer userId=1;
		if(userId!=null) {
			userAddress.setUserId(userId);
			return ResultUtil.success(userAddressService.addUserAddress(userAddress));
		}else {
			throw new  IceiExeption(ResultEnums.IS_LOGIN);//未登录
		}
	}

	/**
	 * 删除用户地址
	 * @param addressId
	 * @return
	 */
	@ResponseBody
	@PostMapping("delUserAddress")
	public Object delUserAddress(@Param("addressId") int addressId){
		Integer userId=1;
		if(userId!=null) {
			return ResultUtil.success(userAddressService.delUserAddress(addressId,userId));
		}else {
			throw new  IceiExeption(ResultEnums.IS_LOGIN);//未登录
		}
	}
}
