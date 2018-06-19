package alipay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 支付宝配置
 */
@Component
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    @Value("${alipay.app_id}")
    public String app_id;

    // 商户私钥，您的PKCS8格式RSA2私钥
    @Value("${alipay.merchant_private_key}")
    public String merchant_private_key;

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    @Value("${alipay.alipay_public_key}")
    public String alipay_public_key;

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    @Value("${alipay.notify_url}")
    public String notify_url;

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    @Value("${alipay.return_url}")
    public String return_url;

    // 签名方式
    @Value("${alipay.sign_type}")
    public String sign_type;

    // 字符编码格式
    @Value("${alipay.charset}")
    public String charset;

    // 支付宝网关https://openapi.alipaydev.com/gateway.do
    @Value("${alipay.gatewayUrl}")
    public String gatewayUrl;

    // 支付宝网关
    public String log_path = "C:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}