package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.PowerRole;
import com.icei.domain.PowerRoleAuth;
import com.icei.domain.Result;
import com.icei.enums.ResultEnums;
import com.icei.mapper.PowerRoleAuthMapper;
import com.icei.mapper.PowerRoleMapper;
import com.icei.utils.ResultUtil;

/**
 * 
 * @author:LordMasterKing
 * @date:2018年4月19日
 */
@Service
public class RolesPowerService {

	@Autowired
	private PowerRoleMapper powerRoleMapper;
	@Autowired
	private PowerRoleAuthMapper powerRoleAuthMapper;

	/**
	 * 获取全部角色
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月19日
	 */
	public Result getAllRoles() {
		List<PowerRole> list = powerRoleMapper.getAllRoles();

		return list == null ? ResultUtil.error(ResultEnums.UNKNOWN_ERROR.getCode(), ResultEnums.UNKNOWN_ERROR.getMsg())
				: ResultUtil.success(list);
	}

	/**
	 * 根据角色ID获取权限
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月19日
	 */
	public List<PowerRoleAuth> getPowersByRoleId(int roleId) {
		return powerRoleAuthMapper.getRelationByRoleId(roleId);
	}

	/**
	 * 改变角色权限
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	public Result changeRolesPower(int powerId, boolean flag, int roleId) {
		PowerRoleAuth powerRoleAuth = new PowerRoleAuth();
		powerRoleAuth.setAuthorityId(powerId);
		powerRoleAuth.setRoleId(roleId);
		Result result = null;
		int i = (flag == true ? powerRoleAuthMapper.insert(powerRoleAuth) : powerRoleAuthMapper.delete(powerRoleAuth));
		if (i > 0) {
			result = ResultUtil.success();
		} else {
			result = ResultUtil.error(ResultEnums.UNKNOWN_ERROR.getCode(), ResultEnums.UNKNOWN_ERROR.getMsg());
		}
		return result;
	}

	/**
	 * 添加新用户
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	public Result addNewRole(String name) {
		int i=powerRoleMapper.addNewRole(name);
		if(i>0) {
			return ResultUtil.success();
		}else {
			return ResultUtil.error(ResultEnums.UNKNOWN_ERROR.getCode(), ResultEnums.UNKNOWN_ERROR.getMsg());
		}
	}
	
	/**
	 * 删除角色
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	public Result delRole(int roleId) {
		int i=powerRoleMapper.delRole(roleId);
		if(i>0) {
			return ResultUtil.success();
		}else {
			return ResultUtil.error(ResultEnums.UNKNOWN_ERROR.getCode(), ResultEnums.UNKNOWN_ERROR.getMsg());
		}
	}
}
