package com.icei.web.controller.iceiBrand;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icei.service.adminService.BrandAdminSublevelService;
import com.icei.utils.ResultUtil;

@RequestMapping("/subordinate")
@Controller
public class subordinateController {
	@Autowired
	public BrandAdminSublevelService subordinateController;
	
	@GetMapping("/subordinate.html")
	public String getHome() {
		return "iceiBrand/subordinate/subordinate";
	}
	
	@GetMapping("/selectByid")
	public Object getAllMsg(@Param("id")int id) {
		return ResultUtil.success(subordinateController.getAll(id),subordinateController.getAllCount(id));
	}
}
