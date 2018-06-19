package com.icei.web.controller.iceiadmin;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.AssessReportService;
import com.icei.utils.ResultUtil;

/**
 * 评论审核
 * @author 小诺诺
 *
 */
@Controller
@RequestMapping("/admin/audit")
public class AssessReportController {
	
	@Autowired
	private AssessReportService assessReport;
	/**
	 * 评论审核映射访问
	 * @return
	 */
	@GetMapping("assessReport.html")
	public String home() {
		return "/iceiAdmin/audit/assessReport";
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param id
	 * @param val
	 * @param statusId
	 * @return
	 */
	@ResponseBody
	@GetMapping("getAssessReportPage.json")
	public Object getAssessReportPage(@Param("page")int page,@Param("limit")int limit,
			@Param("id")int id,@Param("val")String val) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize", limit);
		map.put("id", id);
		map.put("val", val);
		return ResultUtil.success(assessReport.getReportPage(map),assessReport.getCount(id,val));
	}
	/**
	 * 和谐评论
	 * @param auditId
	 * @param assessId
	 * @return
	 */
	@ResponseBody
	@PutMapping("updAssessReport")
	public Object updAssessReport(@Param("auditId")int auditId) {
		return ResultUtil.success(assessReport.updAssessReport(auditId));
	}
	/**
	 * 删除评论
	 * @param auditId
	 * @return
	 */
	@ResponseBody
	@DeleteMapping("delAssessReport")
	public Object delAssessReport(@Param("auditId")Integer auditId) {
		return ResultUtil.success(assessReport.delAssessReport(auditId));
	}
	/**
	 * 驳回举报评论
	 * @param auditId
	 * @return
	 */
	@ResponseBody
	@DeleteMapping("delAssess")
	public Object delAssess(@Param("auditId")Integer auditId) {
		System.out.println(auditId);
		return ResultUtil.success(assessReport.delAssess(auditId));
	}
}