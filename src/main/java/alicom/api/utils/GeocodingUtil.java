package alicom.api.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/**
 * 逆地理编码工具
 * @author only
 *
 */
public class GeocodingUtil {
	static String json="";//json
	static String host = "https://regeo.market.alicloudapi.com";
	static String path = "/v3/geocode/regeo";
	static String method = "GET";
	static String appcode = "89a502c330794eaba46a9323c1137a43";
	/**
	 * 逆地理编码
	 * @param precision 精度
	 * @param dimensionality 维度
	 * @return
	 */
	public static String Geocoding(String precision,String dimensionality){
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("batch", "false");
		querys.put("callback", "callback");
		querys.put("extensions", "base");
		querys.put("homeorcorp", "homeorcorp");
		querys.put("location", precision+","+dimensionality);
		querys.put("output", "output");
		querys.put("radius", "1000");
		querys.put("roadlevel", "roadlevel");
		try {
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			json=EntityUtils.toString(response.getEntity());
			json=json.subSequence(9, json.length()-1).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
