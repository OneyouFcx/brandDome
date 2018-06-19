package com.icei.web.controller.iceiadmin;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icei.domain.GoodsTypeDetail;
import com.icei.service.adminService.GoodsTypeDetailService;
import com.icei.utils.ResultUtil;
/**
 * 商品子分类详情控制层
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("/admin/shop/")
public class GoodsTypeDetailContriller {
	
	@Autowired
	private GoodsTypeDetailService gts;
	
	@GetMapping("goodsTypeDetail.html")
	public String toGoodsTypeDetail() {
		return "/iceiAdmin/shop/goodsTypeDetail";
	}
	/**
	 * 得到全部商品分类信息
	 * @param map
	 * @return
	 */
	@GetMapping("/getAllGoodsTypeDetail")
	@ResponseBody
	public Object getAllGoodsTypeDetail(HttpServletRequest req,@Param("page")int page,@Param("limit")int limit) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize", limit);
		int typeId=Integer.parseInt(req.getParameter("typeId"));
		if(typeId==0) {
			map.put("typeId",null);
		}else {
			map.put("typeId",typeId);
		}
	return ResultUtil.success(gts.getAll(map),gts.getCount(map));
	}
	/**
	 * 修改商品分类信息
	 * @param gt
	 * @return
	 */
	@PutMapping("/UpdateGoodsTypeDetail")
	@ResponseBody
	public int updateGoodsTypeDetail(@ModelAttribute GoodsTypeDetail data) {
		return gts.update(data);
	}
	/**
	 * 添加商品分类
	 * @param goodstype
	 * @return
	 */
	@GetMapping("/AddGoodsTypeDetail")
	@ResponseBody
	public int addGoodsTypeDetail(@ModelAttribute GoodsTypeDetail goodtypedetail) {
		return gts.addGoodsType(goodtypedetail);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@PostMapping("/deleteGoodsTypeDetail")
	@ResponseBody
	public int deleteGoodsType(@Param("id")int id) {
		return gts.deleteGoodsType(id);
	}	
}
