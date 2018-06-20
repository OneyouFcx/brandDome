package com.icei.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;
@RequestMapping("brand")
@Controller
public class HomeController {
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    /**
     * ajax登录请求
     * @param username
     * @param password
     * @return
     */
    @GetMapping("ajaxLogin")
    @ResponseBody
    public Object ajaxLogin(String username, String password){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        String msg="";
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status", 200);
            msg=  "登陆成功";
        }catch(UnknownAccountException   u){
            resultMap.put("status", 404);
            System.out.println("UnknownAccountException -- > 账号不存在");
            msg = "账号不存在";
        }catch(IncorrectCredentialsException pwd){
            System.out.println("IncorrectCredentialsException-->密码错误");
            resultMap.put("status", 403);
            msg=  "密码错误";
        }catch(AccountException u){
            resultMap.put("status", 405);
            System.out.println("UnknownAccountException -- > 账号不存在");
            msg = "账号异常";
        } catch (Exception e) {
            resultMap.put("status", 500);
            //resultMap.put("message", e.getMessage());
            msg=  "网络异常";
        }
        resultMap.put("msg",msg);
        return resultMap;
    }
    /**
     * 退出
     * @return
     */
    @RequestMapping(value="logout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> logout(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            //退出
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resultMap;
    }
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
}