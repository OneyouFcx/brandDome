package com.icei.web.controller.iceiBrand;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.domain.BrandHot;
import com.icei.service.adminService.BrandGoodsService;
import com.icei.service.adminService.BrandHotService;
import com.icei.utils.ResultUtil;

@RequestMapping("/brand")
@Controller
public class BrandHotController {
	@Autowired
	public BrandHotService  brandHotService;
	@Autowired
	public BrandGoodsService brandGoodsService;
	/**
	 * 映射
	 * @return
	 */
	@RequestMapping("brandhot.html")
	public String getHome() {
		return "/iceiBrand/hot/brandhot";
	}
	/**
	 * 查询
	 * @param hotid
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getAllmsg")
	@ResponseBody
	public Object getAllmsg(@Param("hotid")Integer hotid,@Param("page")int page,@Param("limit")int limit){
		int count=brandHotService.getAllcount(hotid);
		List<BrandHot> list=brandHotService.getAllmsg(hotid,page,limit);
		return ResultUtil.success(list,count);
	}

	/**
	 * 	 * 删除
	 * @param hotid
	 * @return
	 */
	@PostMapping("/delByidse")
	@ResponseBody
	public Object delByid(@RequestParam(value = "hotid", required = false)Integer hotid) {
		System.out.println(hotid);
		return brandHotService.delByid(hotid);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insertInto(@Param("record")BrandHot record) {
		int num=brandGoodsService.selectByBrandHot(record.getBrandId(), record.getGoodsId());//该店铺是否存在该商品信息
		int goodsnum=brandHotService.selectBygoodsid( record.getGoodsId());
		if(num==1&&goodsnum==0) {
			return brandHotService.insertinto(record);
		}else if(num==0){
			return 2;
		}else if(goodsnum==1){
			return 3;
		}
		return 0;
	}
	
}
