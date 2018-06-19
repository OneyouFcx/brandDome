package com.icei.web.controller.iceiadmin;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.icei.service.adminService.BrandAdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icei.domain.BrandAdmin;
import com.icei.utils.ResultUtil;
/**
 * 店铺用户管理
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("admin/user")
public class AdmBrandAdminController {
	@Autowired
	private BrandAdminService aba;
	/**
	 * 跳转进入店铺用户管理
	 * @return
	 */
	@GetMapping("/brandAdmin.html")
	public String toBrandAdmin() {
		return "/iceiAdmin/user/brandAdmin";
	}
	/**
	 * 分页+条件，查询全部
	 * @param req
	 * @param page
	 * @param limit
	 * @param brandAdminId 店铺账号ID
	 * @param brandId 店铺ID
	 * @return
	 */
	@GetMapping("getAllbrandAdmin")
	@ResponseBody
	public Object getAllBrandAdmin(HttpServletRequest req,@Param("page")int page,@Param("limit")int limit) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize", limit);
		//店铺账号ID非空判断
		if(req.getParameter("brandAdmId")!=null && !req.getParameter("brandAdmId").equals("")) {
			int Id=Integer.parseInt(req.getParameter("brandAdmId"));
			map.put("brandAdmId", Id);
		}
		//店铺ID非空判断
		if(req.getParameter("brandId")!=null && !req.getParameter("brandId").equals("")) {
			int bId=Integer.parseInt(req.getParameter("brandId"));
			map.put("brandId", bId);
		}
		System.out.println(map.get("brandAdmId"));
		return ResultUtil.success(aba.getAllBrandAdmin(map),aba.getCount(map));
	}
	/**
	 * 修改店铺账号
	 * @param ba
	 * @return
	 */
	@PutMapping("updatebrandAdmin")
	@ResponseBody
	public Object updateBrandAdmin(BrandAdmin data) {
		return ResultUtil.success(aba.updateBrandAdmin(data));
	}
}
