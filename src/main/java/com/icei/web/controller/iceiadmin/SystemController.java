package com.icei.web.controller.iceiadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/sys")
public class SystemController {
	
	/**
	 * 轮播设置
	 * @return
	 */
	@GetMapping("/slideshow.html")
	public String slideshow() {
		return "/iceiAdmin/sys/slideshow";
	}
	
	/**
	 * 系统设置
	 * @return
	 */
	@GetMapping("/SystemSetting.html")
	public String systemSetting() {
		return "/iceiAdmin/sys/SystemSetting";
	}
}
