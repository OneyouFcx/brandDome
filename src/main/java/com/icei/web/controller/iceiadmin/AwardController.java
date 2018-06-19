package com.icei.web.controller.iceiadmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.AwardService;
import com.icei.service.adminService.AwardTypeService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("/activity")
public class AwardController{
	@Autowired
	public AwardService awardController;
	@Autowired
	public AwardTypeService awardTypeController;
	/**
	 * 跳转奖励设置页面
	 * @return
	 */
	@GetMapping("/reward")
	public String showrewardset() {
		return "/iceiAdmin/recommendActivity/reward";
	}

	@GetMapping("/rewardtype")
	public String showrewardsetType() {
		return "/iceiAdmin/recommendActivity/rewardtype";
	}
	/**
	 * 查询总条数
	 * @param awardTypeId
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/getListMsg")
	@ResponseBody
	public Object getListMsg(String userName,int awardTypeId,int page,int limit) {
		return ResultUtil.success(awardController.GetAllMsg(userName,awardTypeId, page, limit), awardController.GetAllMsgCount(userName,awardTypeId));
	}
}
