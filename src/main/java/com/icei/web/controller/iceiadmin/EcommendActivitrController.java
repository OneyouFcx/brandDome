package com.icei.web.controller.iceiadmin;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.domain.EcommendActivitr;
import com.icei.service.adminService.EcommendActivitrService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("/activity")
public class EcommendActivitrController {
	@Autowired
	public EcommendActivitrService ecommendActivitrService;
	/**
	 * 跳转到推荐有礼主界面
	 * @return
	 */
	@GetMapping("/home")
	public String showhome() {
		return "/iceiAdmin/recommendActivity/recommend";
	}
	
	@GetMapping("/subset")
	public String showEcho(int id,Model model) {
		model.addAttribute("id", id);
		return "/iceiAdmin/recommendActivity/subset";
	}
	/**
	 * 查询所有推荐人的信息
	 * @param page
	 * @param limit
	 * @param discountsid
	 * @return
	 */
	@GetMapping("getAll")
	@ResponseBody
	public Object getAll(@Param("page")int page,@Param("limit")int limit,@Param("discountsid")int discountsid) {
		page=(page-1)*limit;
		return ResultUtil.success(ecommendActivitrService.getAllmsg(page,limit,discountsid),ecommendActivitrService.selectcount(discountsid));
	}
	/**
	 * 查询推荐人的所有成功推荐者
	 * @param id
	 * @return
	 */
	@GetMapping("getByid")
	@ResponseBody
	public Object selectByid(@Param("page")int page,@Param("limit")int limit,@Param("id")int id) {
		return ResultUtil.success(ecommendActivitrService.selectByid(page,limit,id),ecommendActivitrService.selectByidCount(id));
	}
	/**
	 * 添加数据
	 * @param ecommendActivitr	对象
	 * @return
	 */
	@GetMapping("insertByObj")
	@ResponseBody
	public Object insertAll(@Param("ecommendActivitr")EcommendActivitr ecommendActivitr) {
		return ResultUtil.success(ecommendActivitrService.insertAllEcommend(ecommendActivitr));
	}
	/**
	 * 根据推荐总人数排序-从高到底
	 * @return
	 */
	@GetMapping("selectOrderByCount")
	@ResponseBody
	public Object selectorderByCount() {
		int a=0;
		String b=String.valueOf(a);
		return ResultUtil.success(ecommendActivitrService.selectorderByCount());
	}
	
	
	
}
