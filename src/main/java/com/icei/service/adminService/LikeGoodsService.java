package com.icei.service.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.LikeGoods;
import com.icei.mapper.LikeGoodsMapper;
/**
 * 收藏商品
 * @author YU生俱来
 *
 */
@Service
public class LikeGoodsService {

	@Autowired
	private LikeGoodsMapper likeGoodsMapper;
	/**
	 * 添加商品收藏信息
	 * @param l
	 * @return
	 */
	public int addLikeGoods(LikeGoods l) {
		return likeGoodsMapper.insertSelective(l);
	}
	/**
	 *  验证是否已经收藏
	 * @param record
	 * @return
	 */
	public int search(LikeGoods record) {
		return likeGoodsMapper.search(record);
	}
	/**
	 * 取消商品收藏
	 * @param userId
	 * @param goodsId
	 * @return
	 */
	public int cancelLikeGoods(int userId,int goodsId) {
		return likeGoodsMapper.cancelLikeGoods(userId, goodsId);
	}
	
	
}
