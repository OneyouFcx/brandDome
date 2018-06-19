package com.icei.service.adminService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.GoodsType;
import com.icei.mapper.GoodsTypeMapper;
/**
 * 商品分类业务逻辑层
 * @author YU生俱来
 *
 */
@Service
public class GoodsTypeService {
	@Autowired
	private GoodsTypeMapper gtm;
	/**
	 * 得到全部商品分类信息-分页
	 * @param map
	 * @return
	 */
	public List<GoodsType> getAll(Map<String,Object> map){
		return gtm.getAllGoodsType(map);
	}
	/**
	 * 获取所有分类
	 * @return
	 */
	public List<GoodsType> getGoodsTypeAll(){
		return gtm.getGoodsTypeAll();
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
	public int update(GoodsType gt) {
		return gtm.updateByPrimaryKeySelective(gt);
	}
	/**
	 * 添加商品分类
	 * @param gt
	 * @return
	 */
	public int addGoodsType(GoodsType gt) {
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
	 * 只用到其中的一条数据，类型名称
	 * @return
	 */
	public List<GoodsType> getAlls(){
		return gtm.getAllGoodsTypes();
	}
	/**
	 * 根据类型id得到信息
	 * @param typeId
	 * @return
	 */
	public GoodsType bytypeidgetgoodstype(int typeId) {
		return gtm.selectByPrimaryKey(typeId);
	}
}
