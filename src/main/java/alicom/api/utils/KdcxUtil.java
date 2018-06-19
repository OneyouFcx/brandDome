package alicom.api.utils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 快递查询
 */
@Component("kdcxUtil")
public class KdcxUtil {
    static String json="";//json
    static String host="http://wuliu.market.alicloudapi.com";//地址
    static String path="/kdi";//路径
    static String method = "GET";//请求方式
    static String appcode = "89a502c330794eaba46a9323c1137a43";//你自己的AppCode


    /**
     * 查询
     * @param num 快递单号
     * @param type 快递类型
     */
    public String kdcx(String num,String type){
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        Map<String,String> headers=new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        //快递相关
        Map<String,String> querys=new HashMap<String, String>();
        querys.put("no",num);//快递单号
        querys.put("type", type);//快递厂商(可选项自动识别)
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //日志输出
            //System.out.println(response.toString());
            //获取response的body
            //信息输出
            System.out.println(json=EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
