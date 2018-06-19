package com.icei.web.controller.iceiBrand;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.domain.GoodsSize;
import com.icei.service.adminService.BrandGoodsService;
import com.icei.service.adminService.GoodsSizeService;
import com.icei.utils.ResultUtil;
/**
 * 店铺商品尺寸管理
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsSizeController {
	@Autowired
	private GoodsSizeService gs;
	
	/**
	 * 进入商品尺寸管理界面
	 * @return
	 */
	@GetMapping("/goodsSize.html")
	public String toBrandGoodsSize() {
		return "iceiBrand/goods/goodsSize";
	}
	/**
	 * 查询全部，带分页，带条件查询
	 * @param page
	 * @param limit
	 * @param goodsId
	 * @param sizeName
	 * @return
	 */
	@GetMapping("/getAll")
	@ResponseBody
	public Object getAll(@Param("page")int page,@Param("limit")int limit,@Param("goodsId")int goodsId,@Param("sizeName")String sizeName) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize",limit);
		map.put("brandId", 1);
		if(goodsId==-1) {
			map.put("goodsId", null);
		}else {
			map.put("goodsId", goodsId);
		}
		if(sizeName==""||sizeName==null) {
			map.put("sizeName", null);	
		}else {
			map.put("sizeName", sizeName);	
		}
		return ResultUtil.success(gs.getAll(map), gs.getCount(map));
	}
	/**
	 * 商品尺寸修改
	 * @param g
	 * @return
	 */
	@PutMapping("/UpdateOne")
	@ResponseBody
	public int UpdateOne(@ModelAttribute GoodsSize data) {
		return gs.UpdateOne(data);
	}
	/**
	 * 商品尺寸删除
	 * @param g
	 * @return
	 */
	@PostMapping("/deteleOne")
	@ResponseBody
	public int deteleOne(@Param("sizeId")int sizeId) {
		return gs.deteleOne(sizeId);
	}
	/**添加商品尺寸
	 * 
	 * @param g
	 * @return
	 */
	@PostMapping("/addOneGoodsSize")
	@ResponseBody
	public int addOneGoodsSize(@ModelAttribute GoodsSize g) {
		return gs.addOne(g);
	}
	
	
	
}
