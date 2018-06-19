package com.icei.web.controller.iceiadmin;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.Result;
import com.icei.service.adminService.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * LordMasterKing
 */
@Controller
@RequestMapping("/admin/finance")
public class FinanceController {
	@Autowired
	private FinanceService financeService;

	@GetMapping("/OrderFinance.html")
	public String toOrderFinancePage() {
		return "iceiAdmin/finance/OrderFinance.html";
	}
	@ResponseBody
	@PostMapping("/getOrderFinanceDetail")
	public String getOrderFinanceInfo(Integer brandId, String startDate, String endDate){
		Result result= financeService.findTargetOrderInfoByBrandIdAndDate(brandId, startDate, endDate);
		return JSONArray.toJSONString(result);
	}

	@ResponseBody
	@PostMapping("/getOrderFinanceInfoDetail")
	public String getTargetOrderDetailInfo(Integer brandId, String startDate, String endDate){
		Result result=financeService.findTargetOrderByBrandIdAndDate(brandId, startDate, endDate);
		return JSONArray.toJSONString(result);
	}
}
