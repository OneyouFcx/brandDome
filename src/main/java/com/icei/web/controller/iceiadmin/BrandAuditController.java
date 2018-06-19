package com.icei.web.controller.iceiadmin;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.icei.domain.BrandAudit;
import com.icei.service.adminService.BrandAuditService;
import com.icei.utils.ResultUtil;

import alicom.api.enums.SmsEnums;
import alicom.api.utils.SmsUtil;

/**
 * 店铺审核
 * @author 小诺诺
 *
 */
@Controller
@RequestMapping("admin/audit")
public class BrandAuditController {
	@Autowired
	private BrandAuditService brandAuditService;
	@Autowired
	private SmsUtil smsUtil;//短信
	/**
	 * 店铺审核映射访问
	 * @return
	 */
	@GetMapping("brandAudit.html")
	public String home() {
		return "/iceiAdmin/audit/brandAudit";
	}

	/**
	 * 分页查询店铺审核
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@GetMapping("getBrandAuditPage.json")
	public Object getBrandAuditPage(@Param("page")int page,@Param("limit")int limit,
			@Param("id")int id,@Param("val")String val,@Param("statusId")int statusId) {
		return ResultUtil.success(brandAuditService.getAuditPage(page*limit-limit, limit,id,val,statusId),brandAuditService.getCount(id,val,statusId));
	}

	/**
	 * 更新审核状态
	 * @return
	 * @throws ClientException 
	 */
	@ResponseBody
	@PutMapping("updBrandStatus")
	public Object updBrandStatus(@Param("statusId")int statusId,@Param("brandId")int brandId) throws ClientException {
		int result=brandAuditService.updStatus(statusId,brandId);
		BrandAudit brandAudit=brandAuditService.getBrandAudit(brandId);
		/*审核通过通知*/
		if(brandAudit.getAuditStatusId()==1&&result==1) {
			Map<String,String> params = new HashMap<>();
	        params.put("name",brandAudit.getAuditName());
	        params.put("shop",brandAudit.getBrandName());
			smsUtil.sendSms(params, SmsEnums.店铺审核通过, brandAudit.getAuditTel());
		}
		return ResultUtil.success(result);
	}
	
}
