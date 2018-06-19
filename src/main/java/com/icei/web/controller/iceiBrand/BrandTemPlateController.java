package com.icei.web.controller.iceiBrand;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.TemplateService;
import com.icei.utils.ResultUtil;
/**
 * 店铺优惠券模板
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("/discounts")
public class BrandTemPlateController {
	@Autowired
	private TemplateService templateService;
	
	/**
	 * 进入优惠券模板
	 * @return
	 */
	@GetMapping("/template.html")
	public String toTemplate() {
		return "iceiBrand/discounts/template";
	}
	
	/**
	 * 条件查询店铺优惠券
	 * @return
	 */
	@ResponseBody
	@GetMapping("/ByIDgetBrandTemplate.json")
	public Object ByIDgetBrandTemplate(HttpServletRequest req,@Param("page")int page,@Param("limit")int limit) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize", limit);
		map.put("brandId",1);
		//ID非空判断
		if(req.getParameter("discountTemplateId")!=null && !req.getParameter("discountTemplateId").equals("")) {
			int num=Integer.parseInt(req.getParameter("discountTemplateId"));
			map.put("discountTemplateId", num);
		}else {
			map.put("discountTemplateId", null);
		}
		//开始日期非空判断
		if(!req.getParameter("discountsStartTime").equals("")&&req.getParameter("discountsStartTime")!=null) {
			map.put("discountsStartTime", req.getParameter("discountsStartTime"));
		}else {
			map.put("discountsStartTime",null);
		}
		//结束日期非空判断
		if(!req.getParameter("discountsEndTime").equals("")&&req.getParameter("discountsEndTime")!=null) {
			map.put("discountsEndTime", req.getParameter("discountsEndTime"));
		}else {
			map.put("discountsEndTime",null);
		}
		return ResultUtil.success(templateService.getBrandTemplate(map),templateService.byConditionGetBrandCount(map));
	}
	
}
