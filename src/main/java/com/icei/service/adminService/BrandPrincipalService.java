package com.icei.service.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.BrandPrincipal;
import com.icei.mapper.BrandPrincipalMapper;

/**
 * 店铺负责人信息Service
 * @author 小诺诺
 *
 */
@Service
public class BrandPrincipalService {
	@Autowired
	private BrandPrincipalMapper brandPrincipalMapper;
	/**
	 * 添加负责人信息
	 * @param brandPrincipal
	 * @return
	 */
	public int addBrandPrincipal(BrandPrincipal brandPrincipal) {
		return brandPrincipalMapper.insertSelective(brandPrincipal);
	}
}
