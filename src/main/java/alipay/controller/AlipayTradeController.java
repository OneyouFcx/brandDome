package alipay.controller;

import alicom.api.enums.SmsEnums;
import alicom.api.utils.SmsUtil;
import alipay.util.AlipayUitl;
import com.alipay.api.AlipayApiException;
import com.aliyuncs.exceptions.ClientException;
import com.icei.domain.Order;
import com.icei.domain.OrderRefund;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.OrderRefundService;
import com.icei.service.adminService.OrderService;
import com.icei.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alipay")
public class AlipayTradeController {

    @Autowired
    private AlipayUitl alipayUitl;
    @Autowired
    private OrderService orderService;//订单
    @Autowired
    private OrderRefundService orderRefundService;//退款记录
    @Autowired
    private SmsUtil smsUtil;//短信

    /**
     * 店铺订单退款
     * @param id 退款id
     * @param state 是否同意 0/1
     * @param content 回复内容
     * @return
     * @throws AlipayApiException
     */
    @ResponseBody
    @Transactional
    @GetMapping("payTradeRefundBrand")
    public Object payTradeRefundBrand(Integer id,Integer state,
                                      @RequestParam(required = false)String content)
            throws AlipayApiException, IOException, ClientException {

        int brandId=1;//店铺id
        OrderRefund or=orderRefundService.findOrderRefundByIdAndBrandId(id,brandId);//退款记录
        if(or!=null){
            Order order=orderService.findAOrderByIdAndBrandId(or.getOrderId(),brandId);//查询订单
            if(order!=null){
                if(order.getOrderStatus().getStatusId()==8){//退款中
                    int res=0;
                    if(state==0){//判断是否同意退款
                        String body=alipayUitl.payTradeRefundBrand(order.getOrderIndex(),order.getTradeIndex(),order.getOrderMoney().toString());//退款请求
                        res=orderService.updOrderStatus(order.getOrderIndex(),9);//退款成功
                        if(res==1){
                            //短信发送
                            Map<String,String> params = new HashMap<>();
                            params.put("name",order.getUserDetail().getUserName());
                            params.put("order",order.getOrderDetail().getBrandGoods().getGoodsName());
                            smsUtil.sendSms(params, SmsEnums.退款成功提示, order.getUserAddress().getPhone());
                        }
                    }else {
                        res=orderService.updOrderStatus(order.getOrderIndex(),10);//退款失败
                        OrderRefund orderRefund=new OrderRefund();
                        orderRefund.setId(id);
                        orderRefund.setBrandContent(content);
                        orderRefundService.updateOrder(orderRefund);//记录拒绝原因
                    }
                    return ResultUtil.success(res);
                }else {
                    throw new IceiExeption(ResultEnums.UPD_ORDER);//订单状态已更新
                }
            }else {
                throw new IceiExeption(ResultEnums.NO_ORDER);//订单不存在
            }
        }else {
            throw new IceiExeption(ResultEnums.NO_RECORD);//记录不存在
        }
    }
}
