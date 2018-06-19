package com.icei.service.adminService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icei.domain.AssessReport;
import com.icei.mapper.AssessReportMapper;
/**
 * 
 * @author 小诺诺
 *
 */
@Service
public class AssessReportService {
	@Autowired
	private AssessReportMapper assessReport;
	@Autowired
	private OrderAssessService orderAssess;
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @param id
	 * @param val
	 * @param statusId
	 * @return
	 */
	public List<AssessReport> getReportPage(Map<String, Object> map) {
		return assessReport.getAssessReportPage(map);
	}
	/**
	 * 查询总条数
	 * @param id
	 * @param val
	 * @param statusId
	 * @return
	 */
	public int getCount(int id,String val) {
		return assessReport.getCount(id,val);
	}
	/**
	 * 和谐评论
	 * @param auditId
	 * @param assessId
	 * @return
	 */
	public int updAssessReport(int auditId) {
		int result=0;
		AssessReport ar=assessReport.selectByPrimaryKey(auditId);
		if(ar!=null) {
			if(orderAssess.updHarmonious(ar.getAssessId())==1) {
				result=assessReport.deleteByPrimaryKey(auditId);
			}
		}
		return result;
	}
	/**
	 * 删除评论
	 * @param auditId
	 * @param assessId
	 * @return
	 */
	public int delAssessReport(Integer auditId) {
		int result=0;
		AssessReport ar=assessReport.selectByPrimaryKey(auditId);
		if(ar!=null) {
			result=orderAssess.delAssess(ar.getAssessId());
		}
		return result;
	}
	/**
	 * 驳回举报评论
	 * @param assessId
	 * @return
	 */
	public int delAssess(Integer auditId) {
		return assessReport.deleteByPrimaryKey(auditId);
	}
	/**
	 * 添加一条举报评论
	 * @param a
	 * @return
	 */
	public int addAssessReport(AssessReport a) {
		return assessReport.insert(a);
	}
}
