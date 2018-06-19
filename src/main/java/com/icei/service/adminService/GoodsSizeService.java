package com.icei.service.adminService;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.GoodsSize;
import com.icei.mapper.GoodsSizeMapper;
/**
 * 店铺商品尺寸管理业务逻辑层
 * @author YU生俱来
 *
 */
@Service
public class GoodsSizeService {
	@Autowired
	private GoodsSizeMapper gm;
	/**
	 * 根据商品ID获取商品尺寸
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSize> byGoodsId(int goodsId){
		return gm.byGoodsId(goodsId);
	}
	
	/**
	 *  查询全部，带分页，带条件查询
	 * @param map
	 * @return
	 */
	public List<GoodsSize> getAll(Map<String,Object> map){
		return gm.getAll(map);
	}
	/**
	 * 得到全部商品
	 * @param map
	 * @return
	 */
	public int getCount(Map<String,Object> map) {
		return gm.getCount(map);
	}
	/**
	 * 修改商品尺寸信息
	 * @param g
	 * @return
	 */
	public int UpdateOne(GoodsSize g) {
		return gm.updateByPrimaryKeySelective(g);
	}
	/**
	 * 删除商品尺寸
	 * @param sizeId
	 * @return
	 */
	public int deteleOne(int sizeId) {
		return gm.deleteByPrimaryKey(sizeId);
	}
	/**
	 * 添加商品尺寸
	 * @param g
	 * @return
	 */
	public int addOne(GoodsSize g) {
		return gm.insert(g);
		
	}
}
