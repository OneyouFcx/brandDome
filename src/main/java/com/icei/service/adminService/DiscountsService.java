package com.icei.service.adminService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.Discounts;
import com.icei.mapper.DiscountsMapper;
/**
 * 优惠券业务逻辑层
 * @author YU生俱来
 *
 */
@Service
public class DiscountsService {
	@Autowired
	private DiscountsMapper discountsMapper;
	/**
	 * 根据店铺id查询优惠券
	 * @param brandId
	 * @return
	 */
	public List<Discounts> byBrandIdGetAll(Map<String, Object> map){
		return discountsMapper.byBrandIdGetDiscount(map);
	}
	/**
	 * 根据店铺id查询优惠券总条数
	 * @param map
	 * @return
	 */
	public int byBrandIdGetAllCounnt(Map<String,Object> map) {
		return discountsMapper.byBrandIdGetAllCounnt(map);
	}
	//平台方法
	/**
	 * 查询优惠券
	 * @param brandId
	 * @return
	 */
	public List<Discounts> GetAll(Map<String, Object> map){
		return discountsMapper.GetDiscount(map);
	}
	/**
	 * 查询优惠券总条数
	 * @param map
	 * @return
	 */
	public int GetAllCounnt(Map<String,Object> map) {
		return discountsMapper.GetAllCounnt(map);
	}
}
