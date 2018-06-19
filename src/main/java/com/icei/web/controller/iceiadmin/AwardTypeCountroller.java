package com.icei.web.controller.iceiadmin;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.domain.AwardType;
import com.icei.mapper.AwardTypeMapper;
import com.icei.service.adminService.AwardTypeService;
import com.icei.service.adminService.TemplateService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("/activity")
public class AwardTypeCountroller {
	@Autowired
	public AwardTypeService awardTypeService;
	@Autowired
	public TemplateService templateService;
	/**
	 * 分页查询全部
	 * @return
	 */
	@GetMapping("/getNameAll")
	@ResponseBody
	public Object getNameAll(@Param("page")int page,@Param("limit")int limit) {
		return ResultUtil.success(awardTypeService.getName(page,limit), awardTypeService.getNameCount());
	}
	/**
	 * 查询优惠券
	 * @param discountsScope   平台/店铺
	 * @return
	 */
	@GetMapping("/selectAlldiscounts")
	@ResponseBody
	public Object getAllDiscounts(int discountsScope) {
		return ResultUtil.success(templateService.selectAll(discountsScope));
	}
	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	@GetMapping("/insert")
	@ResponseBody
	public Object insert(AwardType record) {
		return 	ResultUtil.success(awardTypeService.insert(record));
	}
	/**
	 * 删除数据
	 * @param awardTypeId
	 * @return
	 */
	@PostMapping("/deleteByawardTypeId")
	@ResponseBody
	public Object delete(Integer awardTypeId) {
		return 	ResultUtil.success(awardTypeService.delete(awardTypeId));
	}
	/**
	 * 修改数据
	 * @param record
	 * @return
	 */
	@PostMapping("/updateByKey")
	@ResponseBody
	public Object update(AwardType record) {
		return ResultUtil.success(awardTypeService.update(record));
	}
}
