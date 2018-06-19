package com.icei.web.controller.icei;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icei.domain.BrandGoods;
import com.icei.domain.BrandHot;
import com.icei.domain.DiyMould;
import com.icei.domain.GoodsModel;
import com.icei.mapper.DiyMouldMapper;
import com.icei.service.adminService.*;
import com.icei.utils.Arith;
import com.icei.utils.MoneyUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 客户端网页映射
 */
@Controller
@RequestMapping("icei")
public class HtmlController {
	
	@Autowired
	private SlideshowService slideshowService;//轮播
	@Autowired
	private GoodsTypeService goodsTypeService;//商品分类
	@Autowired
	private BrandService brandService;//店铺
	@Autowired
	private BrandHotService brandHotService;//店铺
	@Autowired
	private GoodsInfoService goodsInfoService;//商品详情
	@Autowired
	private DiyMouleService diyMouleService;//用户定制模板
	@Autowired
	private GoodsModelService goodsModelService;//商品型号模板

	/**
	 * 首页映射
	 * @param map
	 * @return
	 */
	@GetMapping({"/"})
	public String indexMain(Map<String, Object> map) {
		map.put("slide", slideshowService.getSlideAll());
		return "/icei/spoons";
	}

	/**
	 * 店铺
	 * @param map
	 * @param id
	 * @return
	 */
	@GetMapping({"brand.html","shop.html"})
	public String home(Map<String, Object> map,@Param("id")int id) {
		List<BrandHot> list=brandHotService.getBrandHotAll(id);
		map.put("brand",brandService.getABrand(id));
		if(list.size()>=1){
			map.put("brandHot",list);//店铺热门轮播
		}else {
			map.put("brandHot",null);
		}
		return "/icei/shop";
	}
	/**
	 * 商品分类界面
	 * @return
	 */
	@GetMapping("/usually.html")
	public String toGoodsType(Map<String,Object> map) {
		map.put("type", goodsTypeService.getGoodsTypeAll());//获取商品列表
		return "/icei/usually";
	}

	/**
	 * 订单生成页面
	 * @param goodsId 商品id
	 * @param modelId 模板id(可以为空)
	 * @param diyId 定制模板id(可以为空)
	 * @param sizeId 尺寸id(可以为空)
	 * @return
	 */
	@GetMapping("/payorder.html")
	public String toPayOrder(Map<String,Object> map,@Param("goodsId")int goodsId,
							 @RequestParam(value = "modelId", required =false)Integer modelId ,
							 @RequestParam(value = "diyId", required =false)Integer diyId,
							 @RequestParam(value = "sizeId", required =false)Integer sizeId){
		System.out.println("商品id:"+goodsId+" 模板id:"+modelId+" 定制id:"+diyId+" 尺寸id:"+sizeId);

		DiyMould diymode=diyMouleService.getADiyMould(diyId);//定制模板id
		GoodsModel mode=goodsModelService.getAGoodsModel(modelId);//系统模板id
		BrandGoods goodsInfo=goodsInfoService.getOneGoodsInfo(goodsId);//商品
		double goodsPrice=goodsInfo.getGoodsPrice();//商品价格
		double diyPrice=goodsInfo.getDiyPrice();//定制价格
		double goodsDiscount=goodsInfo.getGoodsDiscount();//折扣价格
		double discount=Arith.sub(goodsPrice,Arith.mul(goodsDiscount,goodsPrice));//活动折扣优惠
		map.put("goods",goodsInfo);//商品id
		map.put("sizeId",sizeId);//尺寸id
		map.put("discounts",discount);//活动优惠  折扣
		if(diyId!=null){//判断是否为定制
			map.put("diy",diymode);//模型
			map.put("mpdelImg",diymode.getMouldImg());
			map.put("isdiy",true);
			map.put("SunPrice",Arith.add(goodsPrice,diyPrice));//金额合计
			map.put("payPrice",Arith.add(Arith.sub(goodsPrice,discount),diyPrice));//应付
		}else{
			map.put("model",mode);//模型
			map.put("mpdelImg",mode.getModelImg());
			map.put("isdiy",false);
			map.put("SunPrice",goodsPrice);//金额合计
			map.put("payPrice",Arith.sub(goodsPrice,discount));//应付
		}
		return "/icei/payorder";
	}
}