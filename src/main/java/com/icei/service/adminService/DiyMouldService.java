package com.icei.service.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.DiyMould;
import com.icei.mapper.DiyMouldMapper;

/**
 * 
 * @author YU生俱来
 *
 */
@Service
public class DiyMouldService {

	@Autowired
	private DiyMouldMapper diyMouldMapper;
	/**
	 * 根据定制id获取定制信息
	 * @param diyId
	 * @return
	 */
	public DiyMould ByIdGetDiyMould(int diyId) {
		return diyMouldMapper.selectByPrimaryKey(diyId);
	}
}
