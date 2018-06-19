package com.icei.web.controller.iceiBrand;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.Result;
import com.icei.service.adminService.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LordMasterKing
 */
@Controller
@RequestMapping("/brand/finance")
public class BrandFinanceController {
	@Autowired
	private FinanceService financeService;

	@GetMapping("/OrderFinance.html")
	public String toOrderFinancePage() {
		return "iceiBrand/finance/OrderFinance.html";
	}
	@ResponseBody
	@PostMapping("/getOrderFinanceDetail")
	public String getOrderFinanceInfo(Integer brandId, String startDate, String endDate){
		Result result= financeService.findTargetOrderInfoByBrandIdAndDate(1, startDate, endDate);
		return JSONArray.toJSONString(result);
	}

	@ResponseBody
	@PostMapping("/getOrderFinanceInfoDetail")
	public String getTargetOrderDetailInfo(Integer brandId, String startDate, String endDate){
		Result result=financeService.findTargetOrderByBrandIdAndDate(1, startDate, endDate);
		return JSONArray.toJSONString(result);
	}
}
