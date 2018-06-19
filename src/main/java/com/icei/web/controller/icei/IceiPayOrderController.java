package com.icei.web.controller.icei;

import alipay.domain.Alipay;
import alipay.service.AlipayService;
import com.alipay.api.AlipayApiException;
import com.icei.domain.Order;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 支付页面
 */
@Controller
@RequestMapping("icei")
public class IceiPayOrderController {
    @Autowired
    private OrderService orderService;//订单

    @ResponseBody
    @GetMapping("/payOrder")
    public Object payOrder(Integer addressId,
                           Integer goodsId,
                           @RequestParam(value = "diyMouId",required = false)Integer diyMouId,
                           @RequestParam(value = "typeMouId",required = false)Integer typeMouId,
                           Integer goodsSize,Integer paymentId
                           ){
        System.out.println("地址id:"+addressId+" goodsId:"+goodsId);
        System.out.println("模板id:"+typeMouId+" 定制模板id:"+diyMouId);
        System.out.println("goodsSize:"+goodsSize);
        return orderService.addNewOrder(1,addressId,goodsId,1,diyMouId,typeMouId,null,goodsSize,paymentId);
    }
}
