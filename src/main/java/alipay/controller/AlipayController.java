package alipay.controller;
import javax.servlet.http.HttpServletRequest;

import alicom.api.enums.SmsEnums;
import alicom.api.utils.SmsUtil;
import alipay.config.AlipayConfig;
import alipay.domain.Alipay;
import alipay.service.AlipayService;
import alipay.util.AlipayUitl;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.icei.domain.Order;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    private AlipayConfig alipayConfig;//支付宝配置
    @Autowired
    private AlipayUitl alipayUitl;
    @Autowired
    private OrderService orderService;//订单
    @Autowired
    private SmsUtil smsUtil;//短信

    /**
     * 支付
     * @return
     * @throws AlipayApiException
     */
    @ResponseBody
    @GetMapping("pay/{orderId}")
    public Object pay(@PathVariable String orderId) throws AlipayApiException {
        int userId=1;
        Order order=orderService.findAOrderByOrderNumber(orderId,userId);
        //检查订单状态
        if(order!=null){
            if(order.getOrderStatus().getStatusId()==1){
                String body= alipayUitl.pay(order.getOrderIndex(),
                        order.getOrderPrice().toString(),
                        order.getOrderDetail().getBrandGoods().getGoodsName(),
                        "冰淇淋小屋");//支付
                return body;
            }else {
                throw new IceiExeption(ResultEnums.UPD_ORDER);//订单状态已更新
            }
        }else {
            throw new IceiExeption(ResultEnums.NO_ORDER);//订单不存在
        }
    }

    /**
     * 同步通知
     * @param request
     * @return
     * @throws AlipayApiException
     * @throws UnsupportedEncodingException
     */
    @GetMapping("return_url")
    public String returnUrl(HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException, ParseException {
        //获取支付宝GET过来反馈信息
        boolean signVerified=paramsMap(request);
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            //付款时间
            String total_time = new String(request.getParameter("timestamp").getBytes("ISO-8859-1"),"UTF-8");
            int res=orderService.updateByPrimaryKeySelective(out_trade_no,trade_no,2,total_time);//更新状态
            return "redirect:/icei/myorder.html";
        }else {
            System.out.println("验签失败");
            return "redirect:/icei/myorder.html";
        }
    }


    /**
     * 异步通知
     * @param request
     * @throws UnsupportedEncodingException
     * @throws AlipayApiException
     */
    @PostMapping("notify_url")
    public void notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException, ParseException {
        //获取支付宝POST过来反馈信息
        boolean signVerified=paramsMap(request);

        /* 实际验证过程建议商户务必添加以下校验：
        1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
        4、验证app_id是否为该商户本身。
        */
        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
            //付款时间
            String total_time = new String(request.getParameter("timestamp").getBytes("ISO-8859-1"),"UTF-8");

            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序
            if(trade_status.equals("TRADE_FINISHED")){
                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                orderService.updateByPrimaryKeySelective(out_trade_no,trade_no,2,total_time);//更新状态
            }else if (trade_status.equals("TRADE_SUCCESS")){
                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
                orderService.updateByPrimaryKeySelective(out_trade_no,trade_no,2,total_time);//更新状态
            }
            System.out.println("success");
        }else {//验证失败
            System.out.println("fail");
            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }
    }

    /**
     * 解析参数
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public boolean paramsMap(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.alipay_public_key, alipayConfig.charset, alipayConfig.sign_type); //调用SDK验证签名
        return signVerified;
    }
}