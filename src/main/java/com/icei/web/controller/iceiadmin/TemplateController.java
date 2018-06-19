package com.icei.web.controller.iceiadmin;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icei.domain.Template;
import com.icei.service.adminService.TemplateService;
import com.icei.utils.ResultUtil;
/**
 * 优惠券控制层
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("admin/discounts")
public class TemplateController {
	
	@Autowired
	private TemplateService ts;
	/**
	 * 进入优惠券页面
	 * @return
	 */
	@GetMapping("/template.html")
	public String toTemplate() {
		return "/iceiAdmin/discounts/template";
	}
	/**
	 * 条件查询平台优惠券
	 * @return
	 */
	@ResponseBody
	@GetMapping("/ByIDgetDiscounts.json")
	public Object ByIDgetTemplate(HttpServletRequest req,@Param("page")int page,@Param("limit")int limit) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize", limit);
		//ID非空判断
		if(req.getParameter("discountTemplateId")!=null && !req.getParameter("discountTemplateId").equals("")) {
			int num=Integer.parseInt(req.getParameter("discountTemplateId"));
			map.put("discountTemplateId", num);
		}else {
			map.put("discountTemplateId", null);
		}
		//开始日期非空判断
		if(!req.getParameter("discountsStartTime").equals("")&&req.getParameter("discountsStartTime")!=null) {
			map.put("discountsStartTime", req.getParameter("discountsStartTime"));
		}else {
			map.put("discountsStartTime",null);
		}
		//结束日期非空判断
		if(!req.getParameter("discountsEndTime").equals("")&&req.getParameter("discountsEndTime")!=null) {
			map.put("discountsEndTime", req.getParameter("discountsEndTime"));
		}else {
			map.put("discountsEndTime",null);
		}
		return ResultUtil.success(ts.getTemplate(map),ts.byConditionGetCount(map));
	}
	/**
	 * 添加一个模板信息
	 * @param template
	 * @return
	 */
	@ResponseBody
	@GetMapping("/ToAddTemplate")
	public int toAddTemplate(@ModelAttribute Template template) {
	
		return ts.toAddTemplate(template);
	}
	/**
	 * 修改模板信息
	 * @param template
	 * @return
	 */
	@ResponseBody
	@PostMapping("/UpdateTemplate")
	public int updataTemplate(@ModelAttribute Template data) {
		System.out.println(data.getDiscountTemplateId());
		return ts.updataTemplate(data);
	}
	/**
	 * 删除模板
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dateleTemplate")
	public int deteleTemplate(@Param("id") int id) {
		return ts.deteleTemplate(id);
	}
	
	
	
}
