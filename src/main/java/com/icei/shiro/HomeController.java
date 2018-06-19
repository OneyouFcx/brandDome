package com.icei.shiro;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@RequestMapping("icei")
@Controller
public class HomeController {
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }
    
    @RequestMapping("index1")
    public String indexs0(){
        return"/userInfoDel";
    }

    @RequiresRoles("admin")
    @RequestMapping("icei/index1")
    public String indexs1(){
        return"/userInfo";
    }

    @RequiresRoles("vip")
    @RequestMapping("icei/index2")
    public String indexs2(){
        return"/userInfoAdd";
    }

    @RequestMapping("/logins")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if(exception != null) {
            if(UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在");
                msg = " 账号不存在";
            }else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确");
                msg = " 密码不正确";
            }else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "未知错误";
            }else {
                /*msg = "else >> "+exception;*/
                msg = "请重试 ";
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "icei/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
}