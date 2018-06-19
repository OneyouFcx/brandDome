package alipay.domain;

public class Alipay {
    private String out_trade_no; //商户订单号，商户网站订单系统中唯一订单号，必填
    private String total_amount;//付款金额，必填
    private String subject;//订单名称，必填
    private String body; //商品描述，可空

    private String trade_no;//支付宝交易号
    private String refund_amount;//需要退款的金额
    private String refund_reason;//退款的原因说明
    private String out_request_no;//标识一次退款请求

    @Override
    public String toString() {
        return "Alipay{" +
                "商户订单号out_trade_no='" + out_trade_no + '\'' +
                ", 付款金额total_amount='" + total_amount + '\'' +
                ", 订单名称subject='" + subject + '\'' +
                ", 商品描述body='" + body + '\'' +
                ", 支付宝交易号trade_no='" + trade_no + '\'' +
                ", 需要退款的金额refund_amount='" + refund_amount + '\'' +
                ", 退款的原因说明refund_reason='" + refund_reason + '\'' +
                ", 标识一次退款请求out_request_no='" + out_request_no + '\'' +
                '}';
    }

    //支付构造函数
    public Alipay(String out_trade_no, String total_amount, String subject, String body) {
        this.out_trade_no = out_trade_no;
        this.total_amount = total_amount;
        this.subject = subject;
        this.body = body;
    }
    //退款构造函数
    public Alipay(String out_trade_no, String trade_no, String refund_amount, String refund_reason, String out_request_no) {
        this.out_trade_no = out_trade_no;
        this.trade_no = trade_no;
        this.refund_amount = refund_amount;
        this.refund_reason = refund_reason;
        this.out_request_no = out_request_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
    public String getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public String getOut_request_no() {
        return out_request_no;
    }

    public void setOut_request_no(String out_request_no) {
        this.out_request_no = out_request_no;
    }
}
