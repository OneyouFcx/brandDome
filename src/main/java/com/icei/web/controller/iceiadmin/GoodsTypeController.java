package com.icei.web.controller.iceiadmin;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

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
import com.icei.domain.GoodsType;
import com.icei.service.adminService.GoodsTypeService;
import com.icei.utils.ResultUtil;

/**
 * 商品分类控制层
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("admin/shop")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService gts;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	/***
	 * 进入商品分类界面
	 * @return
	 */
	@GetMapping("/goodsType.html")
	public String toGoodsType() {
		return "/iceiAdmin/shop/goodsType";
	}
	/**
	 * 得到全部商品分类信息
	 * @param map
	 * @return
	 */
	@GetMapping("/getAllGoodsType")
	@ResponseBody
	public Object getAllGoodsType(HttpServletRequest req,@Param("page")int page,@Param("limit")int limit) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize", limit);
		//ID非空判断
		if(req.getParameter("typeid")!=null && !req.getParameter("typeid").equals("")) {
			int num=Integer.parseInt(req.getParameter("typeid"));
			map.put("typeId", num);
		}
		map.put("typeName",req.getParameter("typename"));
		return ResultUtil.success(gts.getAll(map),gts.getCount(map));
	}
	/**
	 * 修改商品分类信息
	 * @param gt
	 * @return
	 */
	@PutMapping("/UpdateGoodsType")
	@ResponseBody
	public int updateGoodsType(@ModelAttribute GoodsType data) {
		return gts.update(data);
	}
	/**
	 * 添加商品分类
	 * @param goodstype
	 * @return
	 */
	@PostMapping("/AddGoodsType")
	@ResponseBody
	public int addGoodsType(@Param("typeName") String typeName,@Param("typeBgc") String typeBgc,@Param("typeIcon") String typeIcon
	,@RequestParam("file") MultipartFile m) {
		String url=upYunTopUtils.MultipartFile(m, "/icei/goodstype/");//上传到云端,返回云端路径
		GoodsType gt=new GoodsType();
		gt.setTypeName(typeName);
		gt.setTypeBgc(typeBgc);
		gt.setTypeIcon(typeIcon);
		gt.setTypeImg(url);
		return gts.addGoodsType(gt);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@PostMapping("/deleteGoodsType")
	@ResponseBody
	public int deleteGoodsType(@Param("id")int id) {
		return gts.deleteGoodsType(id);
	}
	/**
	 * 页面加载获得页面顶部下拉框数据
	 * @return
	 */
	@GetMapping("/getAllGoodsTypeName")
	@ResponseBody
	public Object getAllGoodsTypeName() {
		return gts.getAlls();
	}
}
