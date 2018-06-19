package com.icei.web.controller.icei;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("icei")
public class ActivityController {

	
	@GetMapping("/activity.html")
	public String toactivity() {
		return "/icei/activity";
	}
}
