package com.icei.service.adminService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.GoodsAudit;
import com.icei.domain.Result;
import com.icei.enums.ResultEnums;
import com.icei.mapper.GoodsAuditMapper;
import com.icei.utils.ResultUtil;

/**
 * 商品推广审核
 * 
 * @author:LordMasterKing
 * @date:2018年4月22日
 */
@Service
public class GoodsAuditService {
	@Autowired
	private GoodsAuditMapper goodsAuditMapper;

	/**
	 * 根据参数查询
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月22日
	 */
	public Result findGoodsAudit(int page, int limit, Integer keyword, Integer searchType) {
		int start = (page - 1) * limit;
		int count = goodsAuditMapper.findGoodsAuditCountByParams(page, limit, keyword, searchType);
		List<GoodsAudit> list = goodsAuditMapper.findGoodsAuditByParams(page, limit, keyword, searchType);
		List<Object> resultList = new ArrayList<Object>();
		for (GoodsAudit ga:list) {
			Map<Object,Object> map = new HashMap<Object,Object>();
			map.put("recordId", ga.getRecordId());
			map.put("brandGoods", ga.getBrandGoods());
			map.put("startTime", ga.getStartTime());
			map.put("endTime", ga.getEndTime());
			map.put("auditStatus", ga.getAuditStatus());
			map.put("generalizeAddress", ga.getGeneralizeAddress());
			map.put("auditDetail", JSONArray.parse(ga.getAuditDetail()));
			map.put("systemGeneralize", ga.getSystemGeneralize());
			resultList.add(map);
		}
		return ResultUtil.success(resultList, count);
	};
	
	/**
	 * 更新审核状态
	 * @author:LordMasterKing
	 * @date:2018年4月23日
	 */
	public Result updateStatus(Integer id,Integer option) {
		int i=goodsAuditMapper.updateStatus(id,option);
		if(i>0) {
			return ResultUtil.success();
		}else {
			return ResultUtil.error(ResultEnums.UNKNOWN_ERROR.getCode(), ResultEnums.UNKNOWN_ERROR.getMsg());
		}
	}
}
