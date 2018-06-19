package com.icei.web.controller.iceiBrand;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 订单详情
 * @author YU生俱来
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.service.adminService.OrderDetailService;
@Controller
@RequestMapping("/brand")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	/**
	 * 根据订单id获取商品图片
	 * @param orderId
	 * @return
	 */
	@GetMapping("/byOrderIdGetGoods")
	@ResponseBody
	public Object byOrderIdGetGoods(@Param("orderId")int orderId) {
		return orderDetailService.byOrderIdGetGoodsInfo(orderId);
	}
}
