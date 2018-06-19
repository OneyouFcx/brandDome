package com.icei.web.controller.iceiBrand;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 定制信息
 * @author YU生俱来
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.DiyMouldService;
@Controller
@RequestMapping("brand")
public class DiyMouldController {
	@Autowired
	private DiyMouldService diyMouldService;
	/**
	 * 根据定制id获取定制信息
	 * @param diyId
	 * @return
	 */
	@GetMapping("ByDiyIdGetDiyMould")
	@ResponseBody
	public Object ByDiyIdGetDiyMould(@Param("diyId")int diyId) {
		return diyMouldService.ByIdGetDiyMould(diyId);
	}
}
