package com.icei.web.controller.iceiadmin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.icei.domain.Brand;
import com.icei.domain.Result;
import com.icei.service.adminService.BrandService;
/**
 * 后台店铺相关
 * @author 
 *
 */
@Controller
@RequestMapping("storeLocator")
public class StoreController {
	
	@Autowired
	public BrandService stroreService;//自动适配接口
	
	
	/**
	 * 进入店铺反射地址
	 * @return
	 */
	@GetMapping("shopinfo.html")
	public String come() {
		return "/iceiAdmin/shop/shops";
	}
	
	/**
	 * 根据ID修改店铺的状态信息
	 * @return
	 */
	@PostMapping("update")
	@ResponseBody
	public int updateByid(@Param("id")int id,@Param("num")int num) {
		int nmb=stroreService.updateByid(id, num);	
		return nmb;
	}
	
	/**
	 * 模糊查询店铺信息+分页显示
	 * @param page
	 * @param end
	 * @param id
	 * @param name
	 * @return
	 */
	@GetMapping("getAll")
	@ResponseBody
	public Object getAllmessage(@Param("page")int page,@Param("limit")int limit,@Param("id")int id,@Param("name")String name) {
		page=(page-1)*limit;
		Result result=stroreService.getAllMessageService(page, limit, id, name);
		return JSON.toJSON(result);
	}
	
	@PostMapping("BrandaddMsg")
	@ResponseBody
	public int addBrand(@Param("record")Brand record) {
		return stroreService.addBrand(record);
	}
	
}
