package com.icei.web.controller.icei;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.domain.BrandGoods;
import com.icei.service.adminService.BrandGoodsService;
import com.icei.service.adminService.GoodsTypeDetailService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("/icei")
public class IceiUsuallyController {
	@Autowired
	public BrandGoodsService brandGoodsService ;
	@Autowired
	public GoodsTypeDetailService goodsTypeDetailService;
	/**
	 * 根据类型/查询全部商品
	 * @param page
	 * @param limit
	 * @param typeDetailId
	 * @return
	 */
	@PostMapping("/getusuallymsg")
	@ResponseBody
	public Object getAllMsg(@Param("page")int page,@Param("limit")int limit,@Param("typeDetailId")int typeDetailId,@Param("typeid")int typeid) {
		return  ResultUtil.success(brandGoodsService.getAllMessage(page, limit, typeDetailId, 0,typeid), brandGoodsService.getselectAllmsgCount(typeDetailId, 0,typeid));
	}
	
	@PostMapping("/selectByDetailTypeIdCount")
	@ResponseBody
	public int selectByDetailTypeIdCount(@Param("typeDetailId")int typeDetailId,@Param("typeid")int typeid){
		return brandGoodsService.getselectAllmsgCount(typeDetailId, 0,typeid);
	}
	@PostMapping("/goodsTypeDetailService")
	@ResponseBody
	public Object goodsTypeDetailService(int typeid) {
		return ResultUtil.success(goodsTypeDetailService.getAllTypeDetailNameByid(typeid));
	}
}
