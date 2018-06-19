package com.icei.web.controller.iceiadmin;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.Result;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.GoodsAuditService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("admin/audit")
public class GoodsAuditController {
	@Autowired
	private GoodsAuditService goodsAuditService;

	/**
	 * 页面映射
	 * @author:LordMasterKing
	 * @date:2018年4月23日
	 */
	@GetMapping("/goodsAudit.html")
	public String getToGoodsAuditPage() {
		return "iceiAdmin/audit/goodsAudit.html";
	}

	/**
	 * 按照参数获取申请信息
	 * @author:LordMasterKing
	 * @date:2018年4月23日
	 */
	@ResponseBody
	@GetMapping("/getGoodsAudit")
	public Object findGoodsAudit(@Param("page") Integer page, @Param("limit") Integer limit,
			@Param("keyword") Integer keyword, @Param("searchType") Integer searchType) {
		Result result = goodsAuditService.findGoodsAudit(page, limit, keyword, searchType);
		return JSONArray.toJSONString(result);
	}

	/**
	 * 更新申请状态
	 * @author:LordMasterKing
	 * @date:2018年4月23日
	 */
	@ResponseBody
	@PostMapping("/updateStatus")
	public String updateStatus(@Param("id") Integer id,@Param("type")String type) throws IceiExeption {
		int option=-1;
		if(type.equals("pass")) {
			option=1;
		}else if(type.equals("cancel")) {
			option=3;
		}else if(type.equals("wfp")){
			option=4;
		}else {
			throw new IceiExeption(ResultEnums.UNKNOWN_ERROR);
		}
		Result result = goodsAuditService.updateStatus(id,option);
		return JSONArray.toJSONString(result);
	}
}
