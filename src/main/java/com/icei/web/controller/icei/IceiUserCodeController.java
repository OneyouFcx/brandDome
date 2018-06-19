package com.icei.web.controller.icei;

import com.icei.domain.UserDetail;
import com.icei.mapper.UserDetailMapper;
import com.icei.service.adminService.UserCodeService;
import com.icei.domain.UserCode;
import com.icei.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("icei")
public class IceiUserCodeController {
    @Autowired
    public UserCodeService userCodeService;
    @Autowired
    public UserDetailMapper userDetailMapper;

    /**
     * 添加用户/注册
     * @param userCode
     * @return
     */
    @RequestMapping("/insertLogin")
    @ResponseBody
    public Object regist(UserCode userCode){
        //MD5
        userCode.setPassword(MD5.likeMd5(userCode));
        //添加注册信息
        int num=userCodeService.insertServ(userCode);
        if(num==1){
            UserDetail detail=new UserDetail();
            detail.setUserName("未命名");
            detail.setUserCode(userCode.getUserCode());
            detail.setImgPath("/icei/goods/modelimg/55Y4496Qi8.gif");
            //添加一个默认的用户信息
            int flag=userDetailMapper.insertSelective(detail);
            if(flag==1){
                return 1;
            }
        }
        return 0;
    }



}
