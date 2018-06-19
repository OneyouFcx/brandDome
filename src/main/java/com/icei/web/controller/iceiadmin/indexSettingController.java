package com.icei.web.controller.iceiadmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.domain.Result;
import com.icei.domain.SystemGeneralize;
import com.icei.service.adminService.IndexSettingService;
import com.icei.utils.ResultUtil;
/**
 * 推广位置设置
 * @author 
 *
 */
@Controller
@RequestMapping("/setting")
public class indexSettingController {
	@Autowired
	public IndexSettingService indexSettingService;
	/**
	 * 映射推广页面
	 * @return
	 */
	@GetMapping("/indexSetting.html")
	public String getshow() {
		return "iceiAdmin/sys/indexSetting";
	}
	/**
	 * 返回推广信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/echodata")
	@ResponseBody
	public Object TheEchoData(@Param("page")int page,@Param("limit")int limit,@Param("assessid")int assessid) {
		Result result=indexSettingService.getAllMessage(page, limit,assessid);
		return result;
	}
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	@PostMapping("/del")
	@ResponseBody
	public Object delByid(@Param("id")int id) {
		return indexSettingService.delByid(id);
	}
	/**
	 *	修改数据
	 * @return
	 */
	@PostMapping("/update")
	@ResponseBody
	public Object updateAll(@Param("record")SystemGeneralize record) {
		return ResultUtil.success(indexSettingService.updateAll(record), 0);
	}
	/**
	 *	添加数据
	 * @return
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object addMesssage(@Param("record")SystemGeneralize record) {
		return ResultUtil.success(indexSettingService.addMesssage(record), 0);
	}
	/**
	 *	根据id查询数据
	 * @return
	 */
	@PostMapping("/selectByid")
	@ResponseBody
	public Object updateByid(@Param("generalizeId")Integer generalizeId) {
		return ResultUtil.success(indexSettingService.selectByid(generalizeId),0);
	}
}
