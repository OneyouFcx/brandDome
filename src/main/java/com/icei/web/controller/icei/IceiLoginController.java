package com.icei.web.controller.icei;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 */
@Controller
@RequestMapping("icei")
public class IceiLoginController {

    @GetMapping({"login","login.html"})
    public String login(){
        return "icei/login";
    }
}
