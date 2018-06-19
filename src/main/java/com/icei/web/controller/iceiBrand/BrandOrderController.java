package com.icei.web.controller.iceiBrand;

import alicom.api.enums.SmsEnums;
import alicom.api.utils.SmsUtil;
import com.aliyuncs.exceptions.ClientException;
import com.icei.domain.Order;
import com.icei.domain.UserAddress;
import com.icei.service.adminService.UserAddressService;
import com.icei.utils.Excel;
import com.icei.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.icei.service.adminService.OrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商家订单相关
 * 
 * @author:LordMasterKing
 * @date:2018年4月27日
 */
@Controller
@RequestMapping("brand/order")
public class BrandOrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private SmsUtil smsUtil;

	@GetMapping("/order.html")
	public String getToOrderPage() {
		return "iceiBrand/order/order.html";
	}
	/**
	 * 查询订单
	 * @param orderStatus 订单状态
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @param orderIndex 订单号
	 * @param page 开始页数
	 * @param limit 总数
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@GetMapping("/findOrdersByConditions")
	public Object findOrdersByConditions(
			@RequestParam(value = "orderStatus", required = false) Integer orderStatus,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "orderIndex", required = false) String orderIndex,
			Integer page,Integer limit)throws Exception {
		int brandId=1;
		System.out.println("orderStatus:"+orderStatus);
		System.out.println("startDate:"+startDate);
		System.out.println("endDate:"+endDate);
		System.out.println("orderIndex:"+orderIndex);
		System.out.println("page:"+page);
		System.out.println("page:"+limit);
		Map<String, Object> map=orderService.findOrdersByConditions(orderStatus,startDate,endDate,orderIndex,brandId,page*limit-limit,limit);
		return ResultUtil.success(map.get("list"),(int)map.get("count"));
	}


	/**
	 * 更新快递
	 * @param orderIndex
	 * @param expId
	 * @param expType
	 * @return
	 */
	@ResponseBody
	@PutMapping("updEsc")
	public Object updEsc(String orderIndex,String expId,String expType,Integer userId) throws ClientException {
		int res=orderService.updEsc(orderIndex,expId,expType);//更新订单
		Order order=orderService.findAOrderByOrderNumber(orderIndex,userId);//查询订单
		UserAddress userAddress=userAddressService.ByOrderIdGetAddress(order.getAddressId());//查询地址信息
		Map<String,String> map=new HashMap<>();
		map.put("name",order.getUserDetail().getUserName());
		map.put("kdnum",expId);
		smsUtil.sendSms(map,SmsEnums.快递通知,userAddress.getPhone());
		return ResultUtil.success(res);
	}


	/**
	 * 订单导出
	 * @param response
	 * @param orderStatus
	 * @param startDate
	 * @param endDate
	 * @param orderIndex
	 * @param page
	 * @param limit
	 * @throws Exception
	 */
	@RequestMapping("exportOrder")
	public void export(HttpServletResponse response,
					   @RequestParam(value = "orderStatus", required = false) Integer orderStatus,
					   @RequestParam(value = "startDate", required = false) String startDate,
					   @RequestParam(value = "endDate", required = false) String endDate,
					   @RequestParam(value = "orderIndex", required = false) String orderIndex,
					   Integer page,Integer limit) throws Exception {
		int brandId=1;
		//获取需要导出的数据
		List<Order> list=(List<Order>)orderService.findOrdersByConditions(orderStatus,startDate,endDate,orderIndex,brandId,page*limit-limit,limit).get("list");//获取订单
		//导出操作
		Excel.exportExcel(list,"订单","冰淇淋小屋",Order.class,"订单.xls",response);
	}
}
