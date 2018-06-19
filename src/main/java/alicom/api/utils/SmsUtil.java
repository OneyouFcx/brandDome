package alicom.api.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import alicom.api.enums.SmsEnums;

/**
 * 短信工具类
 * @author 小诺诺
 *
 */
@Component("smsUtil")
public class SmsUtil {
	/**
	 * 短信发送
	 * @param map
	 * @param sms
	 * @param phone
	 * @return
	 * @throws ClientException
	 */
	public SendSmsResponse sendSms(Map<String,String> map,SmsEnums sms,String phone) throws ClientException {
		String json=JSONArray.toJSONString(map);
		System.out.println("短信内容开始");
		System.out.println(json);
		System.out.println(phone);
		return SmsHint.sendSms(phone, sms.getSignature(), sms.getCode(), json);
	}
}