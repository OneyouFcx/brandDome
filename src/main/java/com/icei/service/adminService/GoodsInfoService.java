package com.icei.service.adminService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icei.domain.AssessTag;
import com.icei.domain.BrandGoods;
import com.icei.domain.GoodsSize;
import com.icei.domain.OrderAssess;
import com.icei.mapper.AssessTagMapper;
import com.icei.mapper.BrandGoodsMapper;
import com.icei.mapper.GoodsModelMapper;
import com.icei.mapper.GoodsSizeMapper;
import com.icei.mapper.OrderAssessMapper;
/**
 * 商品详情业务逻辑层
 * @author YU生俱来
 *
 */
@Service
public class GoodsInfoService {
	@Autowired
	private BrandGoodsMapper bg;//商品详情
	@Autowired
	private OrderAssessMapper oa;//商品评论
	@Autowired
	private AssessTagMapper am;//评论类型
	@Autowired
	private GoodsModelMapper gmm;//商品model
	/**
	 * 根据商品id获取商品Model
	 * @param goodsId
	 * @return
	 */
	public Object byGoodsIdGetGoodsModel(int goodsId) {
		return gmm.ByGoodIdGetGoodsModel(goodsId);
	}
	/**
	 * 根据商品id获取商品详情数据
	 * @param goodsId
	 * @return
	 */
	public BrandGoods getOneGoodsInfo(int goodsId) {
		return bg.selectByPrimaryKey(goodsId);
	}
	/**
	 * 通过商品Id获取全部评论(需要商品ID参数)
	 * @return
	 */
	public List<OrderAssess> byGoodsIdGetInfo(int goodsId){
		return oa.byGoodsIdGetInfo(goodsId);
	}
	/**
	 * 根据评论ID增加点赞数
	 * @param o
	 * @return
	 */
	public int byAssessIdAddLikeCount(OrderAssess o) {
		return oa.updateByPrimaryKeySelective(o);
	}
	/**
	 * 得到全部评论类型
	 * @return
	 */
	public List<AssessTag> getAllAssessTag(){
		return am.getAll();
	}
	/**
	 * 根据商品ID获取该商品满意总人数
	 * @param goodsId
	 * @return
	 */
	public int getAssessCount(int goodsId) {
		return bg.getAssessCount(goodsId);
	}
}
