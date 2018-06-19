package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.BrandGoods;
import com.icei.domain.Result;
import com.icei.enums.ResultEnums;
import com.icei.mapper.BrandGoodsMapper;
import com.icei.utils.ResultUtil;
import com.icei.exception.IceiExeption;

@Service
public class BrandGoodsService {
	@Autowired
	public BrandGoodsMapper brandGoodsMapper;

	/**
	 * 查看所有商品信息
	 * 
	 * @return
	 */
	public List<BrandGoods> getAllMessage(int page, int limit, int typeDetailId, int goodsId,int typeid) {
		page = (page - 1) * limit;
		return brandGoodsMapper.selectAllmsg(page, limit, typeDetailId, goodsId,typeid);
	}
	
	
	/**
	 * 查询所有条数
	 * 
	 * @return
	 */
	public int getselectAllmsgCount(int typeDetailId, int goodsId,int typeid) {
		return brandGoodsMapper.selectAllmsgCount(typeDetailId, goodsId,typeid);
	}

	/**
	 * 根据ID删除数据
	 * 
	 * @param goodsId
	 * @return
	 */
	public int deleteByPrimaryKey(int goodsId) {
		return brandGoodsMapper.deleteByPrimaryKey(goodsId);
	}
	
	/**
	 * 判断该店铺是否存在这个商品
	 * 
	 * @param brandid
	 * @param goodsid
	 * @return
	 */
	public int selectByBrandHot(int brandid, int goodsid) {
		return brandGoodsMapper.selectByhotid(brandid, goodsid);
	}

	public int InsertintoByKey(BrandGoods record) {
		return brandGoodsMapper.insertSelective(record);
	}

	/**
	 * 根据对象修改信息
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(BrandGoods record) {
		return brandGoodsMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 前台首页商品展示方法
	 * 
	 * @param typeId
	 * @return
	 */
	public List<BrandGoods> byTypeIdGetGoodsInfo(int typeid) {
		return brandGoodsMapper.byTypeIdGetGoodsInfo(typeid);
	}

	public List<BrandGoods> byTypeIdGetGoodsInfos() {
		return brandGoodsMapper.byTypeIdGetGoodsInfos();
	}

	/**
	 * 个人中心关注的商品
	 */
	public List<BrandGoods> getUserLikeGoods(int userId) {
		return brandGoodsMapper.getUserLikeGoods(userId);
	}

	public Result selectByBrandId(Integer brandId, String keyword, Integer page, Integer size) {
		List<BrandGoods> list = brandGoodsMapper.selectByBrandId(brandId, keyword, (page - 1) * size, size);
		int count=brandGoodsMapper.selectCountByBrandId(brandId, keyword);
		if(list!=null) {
			return ResultUtil.success(list, count);
		}
		throw new IceiExeption(ResultEnums.UNKNOWN_ERROR);
	}

	public List<BrandGoods> GetGoodsInfos() {
		return brandGoodsMapper.GetGoodsInfos();
	}

	public List<BrandGoods> ByBrandIdGetGoodsInfos(int brandId) {
		return brandGoodsMapper.ByBrandIdGetGoodsInfos(brandId);
	}


}
