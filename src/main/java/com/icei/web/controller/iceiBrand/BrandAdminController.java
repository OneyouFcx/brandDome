package com.icei.web.controller.iceiBrand;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.BrandAdminService;
import com.icei.utils.ResultUtil;
/**
 * 店铺账号
 * @author 小诺诺
 *
 */
@Controller
@RequestMapping("/brand/login")
public class BrandAdminController {
	@Autowired
	private BrandAdminService brandAdminService;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping({"/",""})
	public String loginHtml() {
		return "/iceiBrand/login/login";
	}

	/**
	 * 模拟登陆
	 * @return
	 */
	@ResponseBody
	@GetMapping("/denglu")
	public Object login(){
		return ResultUtil.success(1);
	}

	/**
	 * 注册后台管理
	 * @param code
	 * @param pwd
	 * @param serial
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@PostMapping("addBrandAdmin")
	public Object addBrandAdmin(@Param("code")String code,@Param("pwd")String pwd,
			@Param("serial")String serial,@Param("phone")String phone) {
		if(brandAdminService.getBrandAdminIs(code)!=1) {
			int result=brandAdminService.addBrandAdmin(code, pwd, serial, phone);
			return ResultUtil.success(result);
		}else {
			throw new IceiExeption(ResultEnums.IS_CODE);//账号已存在
		}
	}
	/**
	 * 查询账号是否存在
	 * @param adminCode
	 * @return
	 */
	@ResponseBody
	@GetMapping("getBrandAdminIs")
	public Object getBrandAdminIs(@Param("adminCode")String adminCode) {
		if(brandAdminService.getBrandAdminIs(adminCode)!=1) {
			return ResultUtil.success(0);
		}else {
			throw new IceiExeption(ResultEnums.IS_CODE);//账号已存在
		}
	}
}
