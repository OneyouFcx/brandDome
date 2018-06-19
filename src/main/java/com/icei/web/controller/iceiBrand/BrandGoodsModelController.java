package com.icei.web.controller.iceiBrand;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.GoodsMediaService;
import com.icei.service.adminService.GoodsModelService;
import com.icei.service.adminService.GoodsTypeService;

@Controller
@RequestMapping("brand")
public class BrandGoodsModelController {
	
	@Autowired
	private GoodsModelService goodsModelService;
	/**
	 * 根据类型id获取信息
	 * @param typeId
	 * @return
	 */
	@GetMapping("BymodelIdGetInfo")
	@ResponseBody
	public Object ByTypeIdGetInfo(@Param("modelId")int modelId) {
		return goodsModelService.getAGoodsModel(modelId);
	}
}
