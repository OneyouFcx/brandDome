package com.icei.web.controller.iceiBrand;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icei.domain.OrderRefund;
import com.icei.service.adminService.OrderRefundService;
import com.icei.utils.ResultUtil;

/**
 * 退款控制层
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("brand/order")
public class RefundOrderController {

	@Autowired
	private OrderRefundService orderRefundService;
	
	/**
	 * 进入
	 * @return
	 */
	@GetMapping("/refundOrder.html")
	public String toRefundOrder() {
		return "iceiBrand/order/refundOrder.html";
	}
	
	/**
	 * 得到全部退款订单
	 * @return
	 */
	@GetMapping("/getAllOrderRefund")
	@ResponseBody
	public Object getAllOrderRefund(@Param("page")int page,@Param("limit")int limit,@Param("orderId")int orderId,@Param("statusId")int statusId) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize",limit);
		map.put("brandId", 1);
		if(orderId==0) {
			map.put("orderId", null);
		}else {
			map.put("orderId", orderId);
		}
		if(statusId==0) {
			map.put("statusId", null);
		}else {
			map.put("statusId", statusId);
		}
		System.out.println(orderRefundService.getAll(map).size());
		return ResultUtil.success(orderRefundService.getAll(map), orderRefundService.getCount(map));
	}



}
