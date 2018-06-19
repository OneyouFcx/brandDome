package com.icei.web.controller.icei;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icei.service.adminService.GoodsTypeService;
import com.icei.utils.ResultUtil;

/**
 * 商品分类控制层
 * @author 小诺诺
 *
 */
@Controller
@RequestMapping("/icei")
public class IceiGoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;

	/**
	 * 获取商品全部分类
	 * @return
	 */
	@ResponseBody
	@GetMapping("getGoodsTypeAll")
	public Object getGoodsTypeAll() {
		return ResultUtil.success(goodsTypeService.getGoodsTypeAll());
	}
}
