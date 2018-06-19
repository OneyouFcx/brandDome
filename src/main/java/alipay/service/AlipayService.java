package alipay.service;

import alipay.config.AlipayConfig;
import alipay.domain.Alipay;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AlipayService {

    @Autowired
    private AlipayConfig alipayConfig;//支付宝配置

    /**
     * 支付
     * @param alipay
     * @return
     * @throws AlipayApiException
     */
    public String pay(Alipay alipay) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.gatewayUrl, alipayConfig.app_id, alipayConfig.merchant_private_key, "json", alipayConfig.charset, alipayConfig.alipay_public_key, alipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(alipayConfig.return_url);
        alipayRequest.setNotifyUrl(alipayConfig.notify_url);

        String out_trade_no = new String(alipay.getOut_trade_no());//商户订单号，商户网站订单系统中唯一订单号，必填

        String total_amount = new String(alipay.getTotal_amount()); //付款金额，必填

        String subject = new String(alipay.getSubject()); //订单名称，必填

        String body = new String(alipay.getBody());//商品描述，可空
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;
    }

    /**
     * 退款
     * @param alipay
     * @return
     * @throws AlipayApiException
     */
    public String payTradeRefund(Alipay alipay) throws AlipayApiException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.gatewayUrl, alipayConfig.app_id, alipayConfig.merchant_private_key, "json", alipayConfig.charset, alipayConfig.alipay_public_key, alipayConfig.sign_type);

        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();//设置请求参数

        String out_trade_no = new String(alipay.getOut_trade_no());//商户订单号，商户网站订单系统中唯一订单号

        String trade_no = new String(alipay.getTrade_no());//支付宝交易号

        String refund_amount = new String(alipay.getRefund_amount()); //需要退款的金额，该金额不能大于订单金额，必填

        String refund_reason = new String(alipay.getRefund_reason());//退款的原因说明

        String out_request_no = new String(alipay.getOut_request_no()); //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传

        String json="{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"trade_no\":\""+ trade_no +"\","
                + "\"refund_amount\":\""+ refund_amount +"\","
                + "\"refund_reason\":\""+ refund_reason +"\","
                + "\"out_request_no\":\""+ out_request_no +"\"}";
        System.out.println(json);
        alipayRequest.setBizContent(json);
        //请求
        String urlJson=alipayClient.sdkExecute(alipayRequest).getBody();
        System.out.println(urlJson);
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println(result);



//        HttpClient client=new HttpClient();
//        PostMethod postMethod = new PostMethod(AlipayConfig.gatewayUrl+"?"+urlJson);
//        NameValuePair[] data = {
//                new NameValuePair("biz_content", json) };
//        postMethod.setRequestBody(data);
//        int status=client.executeMethod(postMethod);
//        String result=postMethod.getResponseBodyAsString();
//        postMethod.releaseConnection();
//        System.out.println("响应:"+status);
//        System.out.println(result);



        return result;
    }
}