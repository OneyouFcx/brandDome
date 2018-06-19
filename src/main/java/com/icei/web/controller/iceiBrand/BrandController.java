package com.icei.web.controller.iceiBrand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * admin主页
 * 
 * @author only
 *
 */
@Controller
@RequestMapping("/brand")
public class BrandController {
	
	/**
	 * @author:LordMasterKing
	 * @date:2018年4月19日
	 */
	@RequestMapping({"/index.html","/","index"})
	public String index() {
		return "/iceiBrand/index";
	}
	
	/**
	 * 控制台映射访问
	 * 
	 * @return
	 */
	@GetMapping("home/console.html")
	public String home() {
		return "/iceiBrand/home/console";
	}
}
