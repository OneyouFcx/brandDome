package com.icei.web.controller.icei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.Result;
import com.icei.service.adminService.BrandGoodsService;


@Controller
@RequestMapping("icei")
public class IceiBrandGoodsController {

	@Autowired
	private BrandGoodsService brandGoodsService;

	@PostMapping("/getGoods")
	@ResponseBody
	public String getGoods(Integer brandId, String keyword, Integer page, Integer size) {
		Result result = brandGoodsService.selectByBrandId(brandId, keyword, page, size);
		return JSONArray.toJSONString(result);
	}
}
