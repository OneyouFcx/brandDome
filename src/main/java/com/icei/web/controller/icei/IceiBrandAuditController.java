package com.icei.web.controller.icei;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.icei.utils.UpYunTopUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aliyuncs.exceptions.ClientException;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.BrandAuditService;
import com.icei.utils.RandomCharData;
import com.icei.utils.RedisUtil;
import com.icei.utils.ResultUtil;

import alicom.api.enums.SmsEnums;
import alicom.api.utils.SmsUtil;

/**
 * 店铺申请
 * @author 小诺诺
 *
 */
@Controller
@RequestMapping("icei")
public class IceiBrandAuditController {
	@Autowired
	private BrandAuditService brandAuditService;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	
	@Autowired
	private RedisUtil redisUtil;//缓存
	
	@Autowired
	private SmsUtil smsUtil;//短信
	/**
	 * 店铺申请映射访问
	 * @return
	 */
	@GetMapping("checkIn.html")
	public String home() {
		return "/icei/checkIn";
	}
	
	/**
	 * 添加店铺申请
	 * @param brandName
	 * @param brandIntro
	 * @param auditName
	 * @param auditTel
	 * @param auditAddress
	 * @param auditIdcad
	 * @param attachs 文件
	 * @return
	 * @throws IOException
	 * @throws ClientException 
	 */
	@ResponseBody
	@PostMapping("addBrandAudit")
	public Object addBrandAudit(@Param("brandAudit")String brandName,@Param("brandIntro")String brandIntro,
			@Param("auditName")String auditName,@Param("auditTel")String auditTel,
			@Param("auditAddress")String auditAddress,@Param("auditIdcad")Long auditIdcad,
			@Param("serial")String serial,@RequestParam("file")MultipartFile[] attachs) throws IOException, ClientException {

		if(attachs.length==3) {
			if(redisUtil.get("brand"+auditTel).equals(serial)) {
				String[] urls=new String[attachs.length];
				for (int i = 0; i < attachs.length; i++) {
					if(i==0) {
						urls[i]="/icei/brand/icon/";
					}else {
						urls[i]="/icei/audit/";
					}
				}
				List<String> imgs=upYunTopUtils.MultipartFile(attachs, urls);
				String ser=brandAuditService.addBrandAudit(brandName,brandIntro,auditName,auditTel,auditAddress,auditIdcad,imgs);
				Map<String,String> params = new HashMap<>();
				params.put("name",auditName);
		        params.put("serial",ser);
				smsUtil.sendSms(params, SmsEnums.回执编号提示, auditTel);
				return ResultUtil.success(ser);
			}
			throw new IceiExeption(ResultEnums.SERIAL_ERROR);
		}else {
			throw new IceiExeption(ResultEnums.LACKIMG_ERROR);
		}
	}
	
	/**
	 * 查询店铺申请
	 * @param serial 回执编号
	 * @param phone 手机号码
	 * @return
	 */
	@ResponseBody
	@GetMapping("getBrandAuditSerial")
	public Object getBrandAudit(@Param("serial")String serial,@Param("phone")String phone) {
		return ResultUtil.success(brandAuditService.getAuditSerial(serial, phone));
	}
	
	/**
	 * 申请短信验证码
	 * @param phone
	 * @return
	 * @throws ClientException 
	 */
	@ResponseBody
	@GetMapping("getMsmBrandAudit")
	public Object getMsm(@Param("phone")String phone) throws ClientException {
		String code=RandomCharData.createData(6);
		redisUtil.set("brand"+phone, code, 300);//储存验证码
		Map<String,String> params = new HashMap<>();
        params.put("code",code);
		smsUtil.sendSms(params, SmsEnums.验证码5Time, phone);
		return ResultUtil.success(0);
	}
	/**
	 * 检查验证码
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@GetMapping("verifyMsg")
	public Object verifyMsg(@Param("phone")String phone,@Param("serial")String serial) {
		System.out.println(phone+" "+serial);
		String str=redisUtil.get("brand"+phone);
		System.out.println(str);
		if(str!=null){
			if(str.equals(serial)) {
				return ResultUtil.success(0);
			}
		}
		throw new IceiExeption(ResultEnums.SERIAL_ERROR);
	}
}
