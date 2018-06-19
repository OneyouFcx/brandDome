package com.icei.web.controller.iceiBrand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icei.utils.UpYunTopUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.icei.domain.GoodsModel;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.GoodsModelService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("/goods")
public class GoodsModelController {

	@Autowired
	private GoodsModelService gs;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	
	 @GetMapping("/goodsmodel.html")
	 public String toGoodsModel() {
	    return "iceiBrand/goods/goodsmodel";
	 }
	 
	/**
	 * 查询全部，带分页，带条件查询
	 * @param page
	 * @param limit
	 * @param goodsId
	 * @param modelName
	 * @return
	 */
	@GetMapping("/getAllGoodsModel")
	@ResponseBody
	public Object getAll(@Param("page")int page,@Param("limit")int limit,@Param("goodsId")int goodsId,@Param("modelName")String modelName) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize",limit);
		map.put("brandId", 1);
		if(goodsId==0) {
			map.put("goodsId", null);
		}else {
			map.put("goodsId", goodsId);
		}
		if(modelName==""||modelName==null) {
			map.put("modelName", null);	
		}else {
			map.put("modelName", modelName);	
		}
		return ResultUtil.success(gs.getAll(map), gs.getCount(map));
	}
	
	/**
	 * 商品模型修改
	 * @param g
	 * @return
	 */
	@PutMapping("/UpdateOneGoodsModel")
	@ResponseBody
	public int UpdateOne(@ModelAttribute GoodsModel data) {
		return gs.update(data);
	}
	/**
	 * 商品模型删除
	 * @param g
	 * @return
	 */
	@PostMapping("/deteleOneGoodsModel")
	@ResponseBody
	public int deteleOne(@Param("modelId")int modelId) {
		return gs.detele(modelId);
	}
	/**添加商品模型
	 * 
	 * @param g
	 * @return
	 */
	@PostMapping("/addOneGoodsModel")
	@ResponseBody
	public Object addOneGoodsSize(@Param("modelName")String modelName,@Param("modelImg")String modelImg,@Param("goodsId")int goodsId,
			@RequestParam("file")MultipartFile attachs) {
		if(attachs!=null) {
			String url=new String();
			url="/icei/goods/modelimg/";
			String file=upYunTopUtils.MultipartFile(attachs, url);//返回图片地址
			GoodsModel g=new GoodsModel();
			g.setModelName(modelName);
			g.setModelImg(file);
			g.setGoodsId(goodsId);
			return ResultUtil.success(gs.add(g));
		}else {
			throw new IceiExeption(ResultEnums.LACKIMG_ERROR);
		}
		
	}
}
