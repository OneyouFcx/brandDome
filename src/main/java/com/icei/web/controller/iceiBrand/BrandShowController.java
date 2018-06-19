package com.icei.web.controller.iceiBrand;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.icei.domain.BrandAdmin;
import com.icei.domain.Result;
import com.icei.service.adminService.BrandShowService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("brand/show")
public class BrandShowController {
	@Autowired
	private BrandShowService brandShowService;

	@GetMapping("/BrandShow.html")
	public String toBrandShowPage()throws Exception {
		return "iceiBrand/show/BrandShow.html";
	}

	/**
	 * 获取买家秀
	 * 
	 * @author:LordMasterKing
	 * @date:2018年5月1日
	 */
	@ResponseBody
	@PostMapping("/getShow")
	public String getBrandShowByID(HttpServletRequest request) throws Exception {

		BrandAdmin admin = (BrandAdmin) request.getSession().getAttribute("admin");
		// 通过session中存储的管理员对象（admin）获取店铺id，暂无登陆功能，所以用死数据代替
		Result result=brandShowService.getBrandShow(1);
		return JSONArray.toJSONString(result);
	}

	/**
	 * 上传买家秀接口
	 * 
	 * @author:LordMasterKing
	 * @date:2018年5月1日
	 */
	@PostMapping("/upload")
	@ResponseBody
	public String singleFileUpload(@RequestParam("file") MultipartFile attach,
			@RequestParam("describe") String describe, HttpServletRequest request) throws Exception {
		BrandAdmin admin = (BrandAdmin) request.getSession().getAttribute("admin");
		// 通过session中存储的管理员对象（admin）获取店铺id，暂无登陆功能，所以用死数据代替
		Result result = brandShowService.uploadNewBrandShow(attach, describe, 1);
		return JSONArray.toJSONString(result);
	}
	@PostMapping("/delBrandShow")
	@ResponseBody
	public String delBrandShow(@RequestParam("id")Integer id,@RequestParam("fileName")String fileName) {
		Result result=brandShowService.delBrandShow(id,fileName);
		return JSONArray.toJSONString(result);
	}
}
