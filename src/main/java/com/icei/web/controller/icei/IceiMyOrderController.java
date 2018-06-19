package com.icei.web.controller.icei;
import alicom.api.enums.SmsEnums;
import alicom.api.utils.SmsUtil;
import com.aliyuncs.exceptions.ClientException;
import com.icei.utils.UpYunTopUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.icei.domain.Order;
import com.icei.domain.OrderRefund;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.OrderRefundService;
import com.icei.service.adminService.OrderService;
import com.icei.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author YU生俱来
 *个人中心订单控制层
 */

@Controller
@RequestMapping("icei")
public class IceiMyOrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRefundService orderRefundService;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	@Autowired
	private SmsUtil smsUtil;//短信
	
	@GetMapping("/myorder.html")
    public String myOrder(){
        return "/icei/myorder";
    }
	

	/**
	 *  查询个人订单(全部,待发货，代付款，待收货，退款，带评价)
	 * @param req
	 * @return
	 */
	@GetMapping("/Getmyorder")
	@ResponseBody
	public Object getUserOrder(HttpServletRequest req) {
		Integer statusId;
		if(req.getParameter("statusId")==null||req.getParameter("statusId").equals("")) {
			 statusId=null;
		}else {
			statusId=Integer.parseInt(req.getParameter("statusId"));
		}
		return orderService.getUserOrder(1, statusId);
	}
	@GetMapping("/Getmyorderrefund")
	@ResponseBody
	public Object getUserOrderrefund(HttpServletRequest req) {
		return orderService.getUserOrderRefund(1);
	}
	/**
	 * 添加退款订单
	 * @return
	 */
	@PostMapping("/orderRefund")
	@ResponseBody
	@Transactional
	public Object orderRefund(OrderRefund orderRefund,@RequestParam("file")MultipartFile attachs) throws ClientException {
		int userId=1;//用户id
	    Order order=orderService.findAOrderById(orderRefund.getOrderId(),userId);
	    if(order!=null){
			String url=new String();
			url="/icei/order/refund/";
			String file=upYunTopUtils.MultipartFile(attachs, url);//返回图片地址
			orderRefund.setOrderStateId(order.getStatusId());//获取原订单状态
			orderRefund.setImgPath(file);
			System.out.println(file);
			orderService.updOrderStatus(order.getOrderIndex(), 8);//修改订单状态
			int res=orderRefundService.addOrderRefund(orderRefund);//退款申请
			if(res==1){
				//短信发送
				Map<String,String> params = new HashMap<>();
				params.put("name",order.getUserDetail().getUserName());
				params.put("order",order.getOrderDetail().getBrandGoods().getGoodsName());
				smsUtil.sendSms(params, SmsEnums.退款申请提示, order.getUserAddress().getPhone());
			}
			return ResultUtil.success(res);
		 }else {
	    	throw new IceiExeption(ResultEnums.NO_ORDER);//订单不存在
		 }
	}
	/**
	 * 取消退款
	 * @param orderIds
	 * @param userId
	 * @return
	 */
	@GetMapping("cacelRefundOrder")
	@ResponseBody
	public Object cacelRefundOrder(@Param("orderIds")int orderIds,@Param("userId") int userId) {
		OrderRefund orderRefund=orderRefundService.getOne(orderIds);//查询要退款的订单
		Order o=new Order();
		o.setOrderId(orderIds);
		o.setStatusId(orderRefund.getOrderStateId());//得到要修改的订单状态
		int num=orderService.updateOrder(o);
		if(num==1) {
			int sum=orderRefundService.deteleInfo(orderIds);//删除退款订单信息
			return sum;
		}else {
			return 0;
		}
	}
}
