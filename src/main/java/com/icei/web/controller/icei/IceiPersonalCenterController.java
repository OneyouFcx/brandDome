package com.icei.web.controller.icei;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.BrandGoodsService;
import com.icei.service.adminService.BrandService;
import com.icei.service.adminService.LikeBrandService;
import com.icei.service.adminService.LikeGoodsService;

@Controller
@RequestMapping("icei")
public class IceiPersonalCenterController {
	
	@Autowired
	private BrandGoodsService brandGoodsService;//商品
	@Autowired
	private BrandService brandService;//商铺
	@Autowired
	private LikeBrandService likeBrandService;
	@Autowired
	private LikeGoodsService likeGoodsService;
	
   
    /**
     * 个人中心关注商品
     * @param userId
     * @return
     */
    @GetMapping("/getUserLikeGoods")
    @ResponseBody
    public Object getUserLikeGoods(@Param("userId") int userId) {
    	return brandGoodsService.getUserLikeGoods(userId);
    }
    /**
     * 个人中心关注店铺
     * @param userId
     * @return
     */
    @GetMapping("/getUserLikeBrand")
    @ResponseBody
    public Object getUserLikeBrand(@Param("userId") int userId) {
    	return brandService.getUserLikeBrand(userId);
    }
    
    /**
     * 取消收藏店铺
     * @param userId
     * @param brandId
     * @return
     */
    @PutMapping("/cancelLikeBrand")
    @ResponseBody
    public Object cancelLikeBrand(@Param("userId") int userId,@Param("brandId")int brandId) {
    	return likeBrandService.cancelLikeBrand(userId, brandId);
    }
    
    /**
     * 取消收藏商品
     * @param userId
     * @param goodsId
     * @return
     */
    @PutMapping("/cancelLikeGoods")
    @ResponseBody
    public Object cancelLikeGoods(@Param("userId") int userId,@Param("goodsId")int goodsId) {
    	return likeGoodsService.cancelLikeGoods(userId, goodsId);
    }
    
}
