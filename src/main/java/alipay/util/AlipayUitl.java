package alipay.util;

import alipay.domain.Alipay;
import alipay.service.AlipayService;
import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("alipayUitl")
public class AlipayUitl {

    @Autowired
    private AlipayService alipayService;//支付宝

    /**
     * 支付
     * @param orderIndex 商家订单号
     * @param orderMoney 商品价格
     * @param orderName 订单名称
     * @param describe 商品描述
     * @return
     * @throws AlipayApiException
     */
    public String pay(String orderIndex,String orderMoney,String orderName,String describe) throws AlipayApiException {
        Alipay alipay=new Alipay(orderIndex,orderMoney, orderName, describe);
        String body=alipayService.pay(alipay);
        return body;
    }

    /**
     * 退款
     * @param orderIndex 商家订单号
     * @param tradeIndex 支付宝订单号
     * @param orderMoney 订单金额
     * @return
     * @throws AlipayApiException
     */
    public String payTradeRefundBrand(String orderIndex,String tradeIndex,String orderMoney) throws AlipayApiException, IOException {
        Alipay alipay=new Alipay(orderIndex,
                tradeIndex,orderMoney,
                "","");
        String body=alipayService.payTradeRefund(alipay);//退款请求
        return body;
    }

}
