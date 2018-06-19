package com.icei.service.adminService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.Result;
import com.icei.domain.SystemGeneralize;
import com.icei.mapper.SystemGeneralizeMapper;

@Service
public class IndexSettingService {
	@Autowired
	public SystemGeneralizeMapper systemGeneralizeMapper;
	/**
	 * 查询全部推广信息+分页显示
	 * @param page	页数
	 * @param limit	显示多少条数据
	 * @return
	 */
	public Result getAllMessage(int page,int limit,int assessid){
		int pages=(page-1)*limit;
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", pages);
		map.put("limit", limit);
		map.put("assessid",assessid);
		int count=systemGeneralizeMapper.selectByMaxCount(map);
		List<SystemGeneralize> list=systemGeneralizeMapper.getAllMessage(map);
		Result result=new Result();
		result.setCode(0);
		result.setCount(count);
		result.setData(list);
		result.setMsg("成功");
		return result;
	}
	/**
	 * 根据ID 删除数据
	 * @param id
	 * @return
	 */
	public int delByid(int generalizeId) {
		return systemGeneralizeMapper.deleteByPrimaryKey(generalizeId);
	}
	/**
	 * 修改数据
	 * @return
	 */
	public int updateAll(SystemGeneralize record) {
		return systemGeneralizeMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 添加数据
	 * @return
	 */
	public int addMesssage(SystemGeneralize record) {
		return systemGeneralizeMapper.insertSelective(record);
	}
	/**
	 * 根据id查询数据
	 * @param generalizeId
	 * @return
	 */
	public SystemGeneralize selectByid(Integer generalizeId) {
		return systemGeneralizeMapper.selectByPrimaryKey(generalizeId);
	}
}
