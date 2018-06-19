package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.domain.Template;
import com.icei.domain.AwardType;
import com.icei.mapper.AwardTypeMapper;

@Service
public class AwardTypeService {
	@Autowired
	public AwardTypeMapper awardTypeMapper;
	/**
	 * 查询奖励类型
	 * @return
	 */
	public List<AwardType> getName(int page,int limit) {
		page=(page-1)*limit;
		return awardTypeMapper.getName(page,limit);
	}
	/**
	 * 查询总条数
	 * @return
	 */
	public int getNameCount() {
		return awardTypeMapper.getNameCount();
	}
	
	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	public int insert(AwardType record) {
		return awardTypeMapper.insert(record);
	}
	
	/**
	 * 删除
	 * @param awardTypeId
	 * @return
	 */
	public int delete(Integer awardTypeId) {
		return awardTypeMapper.deleteByPrimaryKey(awardTypeId);
	}
	
	/**
	 * 修改数据
	 * @param record
	 * @return
	 */
	public int update(AwardType record) {
		return awardTypeMapper.updateByPrimaryKeySelective(record);
	}
}

