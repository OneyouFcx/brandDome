package com.icei.web.controller.icei;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("icei")
public class iceiActivityController {
	@RequestMapping("/activity.html")
	public Object show() {
		return "/icei/activity";
	}
}
