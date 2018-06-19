package com.icei.web.controller.icei;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icei.service.adminService.BrandGoodsService;
/**
 * 前台商品展示控制器
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("icei")
public class IceiSpoonsController {
	@Autowired
	private BrandGoodsService brandGoodsService;
	
	/**
	 * 前台展示商品
	 * @param typeId
	 * @return
	 */
	@GetMapping("/byTypeIdGetGoodsInfo")
	@ResponseBody
	public Object byTypeIdGetGoodsInfo(@Param("typeId") int typeId) {
		return brandGoodsService.byTypeIdGetGoodsInfo(typeId);
	}
	/**
	 * 前台展示商品
	 * @param typeId
	 * @return
	 */
	@GetMapping("/byTypeIdGetGoodsInfos")
	@ResponseBody
	public Object byTypeIdGetGoodsInfos() {
		return brandGoodsService.byTypeIdGetGoodsInfos();
	}
	/**
	 * 获取全部商品
	 * @return
	 */
	@GetMapping("/GetGoodsInfos")
	@ResponseBody
	public Object GetGoodsInfos() {
		return brandGoodsService.GetGoodsInfos();
	}
	
	/**
	 * 根据店铺id获取店铺商品
	 * @return
	 */
	@GetMapping("/byBrandIdGetGoodsInfos")
	@ResponseBody
	public Object byBrandIdGetGoodsInfos() {
		return brandGoodsService.ByBrandIdGetGoodsInfos(1);
	}
	
	
}
