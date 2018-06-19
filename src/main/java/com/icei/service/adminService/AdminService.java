package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.Admin;
import com.icei.domain.Result;
import com.icei.enums.ResultEnums;
import com.icei.mapper.AdminMapper;
import com.icei.utils.ResultUtil;

/**
 * @author:LordMasterKing
 * @date:2018年4月20日
 */
@Service
public class AdminService {
	/**
	 * 获取查询结果总数
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	@Autowired
	private AdminMapper adminMapper;
	
	/**
	 * 通过参数查询管理员
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	public Result getAdminByParams(Integer page,Integer limit,String keyword,String searchType) {
		int count=adminMapper.getResultsCount(keyword, searchType);
		List<Admin>list=adminMapper.getTargetResult((page-1)*limit, limit, keyword, searchType);
		return ResultUtil.success(list, count);
	}
	/**
	 * 改变管理员角色
	 * @author:LordMasterKing
	 * @date:2018年4月20日
	 */
	public Result changeAdminRole(Integer adminId, Integer targetRoleId) {
		int i = adminMapper.updateRoleIdByAdminId(adminId, targetRoleId);
		if (i > 0) {
			return ResultUtil.success(null);
		}
		return ResultUtil.error(ResultEnums.UNKNOWN_ERROR.getCode(), ResultEnums.UNKNOWN_ERROR.getMsg());
	}
}
