package com.icei.web.controller.icei;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 3D定制
 */
@Controller
public class Icei3DController {
    @GetMapping("/3D")
    public String toMainPage(){
        return "icei/3D.html";
    }
}