package com.icei.web.controller.icei;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.LikeBrand;
import com.icei.domain.Result;
import com.icei.mapper.LikeBrandMapper;
import com.icei.service.adminService.BrandService;
import com.icei.service.adminService.BrandShowService;
import com.icei.service.adminService.LikeBrandService;
import com.icei.utils.ResultUtil;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("icei")
public class IceiBrandController {
	@Autowired
	private BrandService brandService;

	@Autowired
	private BrandShowService brandShowService;
	
	@Autowired
	private LikeBrandService likeBrandService;//收藏店铺

	/**
	 * 获取所有店铺
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping("getBrandAll")
	public Object getBrandAll() {
		return ResultUtil.success(brandService.getBrandAll());
	}

	/**
	 * 获取买家秀
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("getBrandShow/{id}")
	public String getBrandShow(@PathVariable("id") Integer id) throws Exception {
		Result result = brandShowService.getBrandShow(id);
		return JSONArray.toJSONString(result);
	}
	
	/**
	 * 验证是否收藏该店铺
	 * @param record
	 * @return
	 */
	@GetMapping("/verification")
	@ResponseBody
	public int verification(@Param("brandId")int brandId,@Param("userId")int userId) {
		LikeBrand likeBrand=new LikeBrand();
		likeBrand.setBrandId(brandId);
		likeBrand.setUserId(userId);
		return likeBrandService.verification(likeBrand);
	}
	
	/**
	 * 收藏店铺
	 * @param record
	 * @return
	 */
	@PutMapping("/addLikeBrand")
	@ResponseBody
	public int addLikeBrand(@Param("brandId")int brandId,@Param("userId")int userId) {
		LikeBrand likeBrand=new LikeBrand();
		likeBrand.setBrandId(brandId);
		likeBrand.setUserId(userId);
		System.out.println(brandId);
		return likeBrandService.addLikeBrand(likeBrand);
	}
}
