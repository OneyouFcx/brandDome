package com.icei.web.controller.icei;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icei.domain.AssessReport;
import com.icei.domain.OrderAssess;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.AssessReportService;
import com.icei.utils.ResultUtil;

/**
 * 举报评论控制器
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("icei")
public class IceiAssessReportController {
	@Autowired
	private AssessReportService as;
	/**
	 * 添加一条评论举报
	 * @return
	*/
	@GetMapping("/addAssessReport")
	@ResponseBody
	public Object addAssessReport(@Param("reportContent")String reportContent,@Param("userId")int userId,@Param("assessId")int assessId) {
		if(reportContent!=""&&reportContent!=null) {
			AssessReport ar=new AssessReport();
			ar.setReportContent(reportContent);
			ar.setUserId(userId);
			ar.setAssessId(assessId);
			return ResultUtil.success(as.addAssessReport(ar));
		}else {
			throw new IceiExeption(ResultEnums.LACK_ERROR);
		}
	}
}
