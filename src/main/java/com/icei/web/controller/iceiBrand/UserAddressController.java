package com.icei.web.controller.iceiBrand;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.UserAddressService;
/**
 * 用户地址
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("brand")
public class UserAddressController {
	@Autowired
	private UserAddressService userAddressService;
	
	/**
	 * 根据地址id获取地址信息
	 * @param addressId
	 * @return
	 */
	@GetMapping("ByOrderIdGetAddress")
	@ResponseBody
	public Object ByOrderIdGetAddress(@Param("addressId")int addressId) {
		return userAddressService.ByOrderIdGetAddress(addressId);
	}
}
