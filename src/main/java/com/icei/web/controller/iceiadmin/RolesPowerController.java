package com.icei.web.controller.iceiadmin;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.Result;
import com.icei.service.adminService.AdminService;
import com.icei.service.adminService.RolesPowerService;
import com.icei.utils.ResultUtil;

/**
 * @author:LordMasterKing
 * @date:2018年4月19日
 */
@Controller
@RequestMapping("/admin/user")
public class RolesPowerController {

	@Autowired
	private RolesPowerService rolesPowerService;

	@Autowired
	private AdminService adminService;

	/**
	 * 权限管理界面
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月19日
	 */
	@RequestMapping("/roleManage.html")
	public String getToRoleManage(Map<String, Object> map) {
		map.put("roles", rolesPowerService.getAllRoles().getData());
		return "iceiAdmin/user/roleManage";
	}

	/**
	 * 管理员管理界面
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	@RequestMapping("/admins.html")
	public String getToAdmins(Map<String, Object> map) {
		map.put("roles", rolesPowerService.getAllRoles().getData());
		return "iceiAdmin/user/admins";
	}

	/**
	 * 获取所有权限
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月19日
	 */
	@ResponseBody
	@PostMapping("/getRolesPower.json")
	public String getRolesPower(@Param("id") Integer id) {
		Result result = ResultUtil.success(rolesPowerService.getPowersByRoleId(id));
		return JSONArray.toJSONString(result);
	}

	/**
	 * 更改管理员权限
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月19日
	 */
	@ResponseBody
	@PostMapping("/changeRolesPower.json")
	public String changeRolesPower(@Param("powerId") int powerId, @Param("flag") boolean flag,
			@Param("roleId") int roleId) {
		Result result = rolesPowerService.changeRolesPower(powerId, flag, roleId);
		return JSONArray.toJSONString(result);
	}

	/**
	 * 获取所有管理员
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */

	@ResponseBody
	@PostMapping("/getAdmins")
	public String getAdminsByParam(@Param("page") Integer page, @Param("limit") Integer limit,
			@Param("keyword") String keyword, @Param("searchType") String searchType) {
		Result result = adminService.getAdminByParams(page, limit, keyword, searchType);
		return JSONArray.toJSONString(result);
	}

	/**
	 * 改变管理员权限
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	@ResponseBody
	@PostMapping("/changeAdminRole")
	public String changeAdminRole(@Param("adminId") Integer adminId, @Param("targetRoleId") Integer targetRoleId) {
		Result result = adminService.changeAdminRole(adminId, targetRoleId);
		return JSONArray.toJSONString(result);
	}

	/**
	 * 添加新角色
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	@ResponseBody
	@PostMapping("/addNewRole")
	public String addNewRole(@Param("name") String name) {
		Result result = rolesPowerService.addNewRole(name);
		return JSONArray.toJSONString(result);
	}

	/**
	 * 删除新角色
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	@ResponseBody
	@PostMapping("/delRole")
	public String delRole(@Param("roleId") Integer roleId) {
		Result result=rolesPowerService.delRole(roleId);
		return JSONArray.toJSONString(result);
	}
}
