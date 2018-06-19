package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.GoodsMedia;
import com.icei.mapper.GoodsMediaMapper;

@Service
public class GoodsMediaService {
	@Autowired
	public GoodsMediaMapper goodsMediaMapper;
	
	/**
	 * 根据id删除
	 * @param introId
	 * @return
	 */
	public int deleteByid(int introId) {
		return goodsMediaMapper.deleteByPrimaryKey(introId);
	}
	
	/**
	 * 查询全部
	 * @return
	 */
	public Object selectAlls(int brandid) {
		return goodsMediaMapper.selectAlls(brandid);
	}
	/**
	 * 根据商品编号查询所有相关图片
	 * @param goodsid
	 * @return
	 */
	public List<GoodsMedia> getAllBygoodsid(int goodsid){
		return goodsMediaMapper.selectByGoodsId(goodsid);
	}
	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	public int insertinto(GoodsMedia record) {
		return goodsMediaMapper.insertSelective(record);
	}
}
