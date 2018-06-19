package com.icei.service.adminService;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icei.domain.GoodsTypeDetail;
import com.icei.mapper.GoodsTypeDetailMapper;
/**
 * 商品子分类业务逻辑层
 * @author YU生俱来
 *
 */
@Service
public class GoodsTypeDetailService {
	
	@Autowired
	private GoodsTypeDetailMapper gtm;
	
	/**
	 * 得到全部商品分类信息
	 * @param map
	 * @return
	 */
	public List<GoodsTypeDetail> getAll(Map<String,Object> map){
		return gtm.getAllGoodsTypeDetail(map);
	}
	
	
	/**
	 * 得到商品信息数量
	 * @return
	 */
	public int getCount(Map<String,Object> map) {
		return gtm.getCount(map);
	}
	
	/**
	 * 修改商品分类信息
	 * @param gt
	 * @return
	 */
	public int update(GoodsTypeDetail gt) {
		return gtm.updateByPrimaryKeySelective(gt);
	}
	/**
	 * 添加商品分类
	 * @param gt
	 * @return
	 */
	public int addGoodsType(GoodsTypeDetail gt) {
		return gtm.insert(gt);
	}
	
	/**
	 * 删除商品分类
	 * @param id
	 * @return
	 */
	public int deleteGoodsType(int id) {
		return gtm.deleteByPrimaryKey(id);
	}
	
	/**
	 * 得到商品分类名称
	 * @param map
	 * @return
	 */
	public List<GoodsTypeDetail> getAllTypeDetailName(){
		return gtm.getAllTypeDetailName();
	}
	/**
	 * 根据ID查询商品分类
	 * @param id
	 * @return
	 */
	public List<GoodsTypeDetail> getAllTypeDetailNameByid(int id){
		return gtm.getAllTypeDetailNameByid(id);
	}
	
	/**
	 * 根据商品ID查询商品分类
	 * @param id
	 * @return
	 */
	public GoodsTypeDetail getAllTypeDetailNameBygoodsid(int typeDetailId){
		return gtm.selectByPrimaryKey(typeDetailId);
	}
	
	
}
