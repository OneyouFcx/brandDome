package com.icei.service.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.LikeBrand;
import com.icei.mapper.LikeBrandMapper;
/**
 * 收藏店铺
 * @author YU生俱来
 *
 */
@Service
public class LikeBrandService {
	@Autowired
	private LikeBrandMapper likeBrandMapper;
	
	/**
	 * 验证是否收藏该店铺
	 * @param record
	 * @return
	 */
	public int verification(LikeBrand record) {
		return likeBrandMapper.verification(record);
	}
	
	/**
	 * 收藏店铺
	 * @param record
	 * @return
	 */
	public int addLikeBrand(LikeBrand record) {
		return likeBrandMapper.insertSelective(record);
	}
	/**
	 * 取消收藏店铺
	 * @param userId
	 * @param brandId
	 * @return
	 */
	public int cancelLikeBrand(int userId,int brandId) {
		return likeBrandMapper.cancelLikeBrand(userId, brandId);
	}
}
