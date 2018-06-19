package com.icei.web.controller.icei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.icei.domain.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.GoodsInfoService;
import com.icei.service.adminService.GoodsMediaService;
import com.icei.service.adminService.GoodsSizeService;
import com.icei.service.adminService.GoodsTypeDetailService;
import com.icei.service.adminService.LikeGoodsService;
import com.icei.utils.ResultUtil;
/**
 * 商品详情控制层
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("icei")
public class IceiGoodsInfoController {
	@Autowired
	private GoodsInfoService goodsInfoService;//商品信息
	@Autowired
	private LikeGoodsService likeGoodsService;//商品收藏
	@Autowired
	private GoodsMediaService goodsMediaService;//商品图片
	@Autowired
	private GoodsSizeService goodsSizeService;//商品尺寸
	@Autowired
	private GoodsTypeDetailService goodsTypeDetailService;//商品详细类型
	
	/**
	 * 进入商品详情页面
	 * @return
	 */
	@GetMapping("/goodsinfo.html")
	public String toGoodsInfo(Map<String, Object> map,@Param("goodsId")int goodsId) {
		BrandGoods brandGoods=goodsInfoService.getOneGoodsInfo(goodsId);//商品
		map.put("goods",brandGoods);
		//System.out.println(brandGoods.toString());//打印商品
		//System.out.println(brandGoods.getGoodsPrice());
		if(brandGoods!=null){
			map.put("goodsModel", goodsInfoService.byGoodsIdGetGoodsModel(goodsId));
			map.put("goodsSize", goodsSizeService.byGoodsId(goodsId));//尺寸
			List<GoodsMedia> list=goodsMediaService.getAllBygoodsid(goodsId);
			if(list.size()>=1){
				map.put("goodsmedia",list);//商品所有图片集合
			}else {
				map.put("goodsmedia",null);
			}
			map.put("goodsTypeDetail",goodsTypeDetailService.getAllTypeDetailNameBygoodsid(brandGoods.getTypeDetailId()));
		}
		return "/icei/goodsinfo";
	}
	/**
	 * 测试上面的方法返回值
	 * @return
	 */
	@GetMapping("/sgoodsinfo")
	@ResponseBody
	public Object toGoodsInfo() {
		return goodsInfoService.byGoodsIdGetGoodsModel(1);
	}
	/**
	 * 通过商品id获取全部评论
	 * @return
	 */
	@GetMapping("/byGoodsIdGetInfo")
	@ResponseBody
	public Object byGoodsIdGetInfo(@Param("goodsId")int goodsId) {
		return goodsInfoService.byGoodsIdGetInfo(goodsId);
	}
	/**
	 * 根据评论ID修改点赞数量
	 * @param assessId
	 * @param likeCount
	 * @return
	 */
	@PutMapping("/byAssessIdAddLikeCount")
	@ResponseBody
	public Object byAssessIdAddLikeCount(@Param("assessId")int assessId,@Param("likecount")int likeCount) {
		if(assessId!=0||likeCount!=0) {
			OrderAssess o=new OrderAssess();
			o.setAssessId(assessId);
			o.setLikeCount(likeCount);
			return ResultUtil.success(goodsInfoService.byAssessIdAddLikeCount(o));
		}else {
			throw new IceiExeption(ResultEnums.LACK_ERROR);
		}
	}
	/**
	 * 得到全部评论类型
	 * @return
	 */
	@GetMapping("/getAllAssessTag")
	@ResponseBody
	public Object getAllAssessTag() {
		return goodsInfoService.getAllAssessTag();
	}
	/**
	 * 根据商品id获取商品满意总人数
	 * @param goodsId
	 * @return
	 */
	@GetMapping("/getAssessCount")
	@ResponseBody
	public int getAssessCount(@Param("goodsId")int goodsId) {
		return goodsInfoService.getAssessCount(goodsId);
		
	}
	/**
	 * 商品收藏
	 * @param goodsId
	 * @param userId
	 * @return
	 */
	@GetMapping("/addLikeGoods")
	@ResponseBody
	public int addLikeGoods(@Param("goodsId")int goodsId,@Param("userId")int userId) {
		LikeGoods likeGoods=new LikeGoods();
		likeGoods.setUserId(userId);
		likeGoods.setGoodsId(goodsId);
		return likeGoodsService.addLikeGoods(likeGoods);
	}
	/**
	 * 验证是否已经收藏
	 * @param goodsId
	 * @param userId
	 * @return
	 */
	@GetMapping("/search")
	@ResponseBody
	public int  search(@Param("goodsId")int goodsId,@Param("userId")int userId) {
		LikeGoods likeGoods=new LikeGoods();
		likeGoods.setUserId(userId);
		likeGoods.setGoodsId(goodsId);
		return likeGoodsService.search(likeGoods);
	}
	
	
}
