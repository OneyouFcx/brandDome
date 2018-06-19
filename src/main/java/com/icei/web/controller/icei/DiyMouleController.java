package com.icei.web.controller.icei;

import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.DiyMouleService;
import com.icei.utils.ResultUtil;
import com.icei.utils.UpYunTopUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 定制模板
 */
@Controller
@RequestMapping("icei")
public class DiyMouleController {
    @Autowired
    private DiyMouleService diyMouleService;
    @Autowired
    private UpYunTopUtils upYunTopUtils;//文件上传
    /**
     * 用户添加diy模板
     * @param attachs
     * @return
     */
    @ResponseBody
    @PostMapping("addDiyMoule")
    public Object addDiyMoule(@RequestParam("file")MultipartFile[] attachs){
        if(attachs.length==2) {
            String[] urls=new String[attachs.length];
            for (int i = 0; i < attachs.length; i++) {
                if(i==0) {
                    urls[i]="/icei/diymoule/img/";
                }else {
                    urls[i]="/icei/diymoule/back/";
                }
            }
            List<String> imgs= upYunTopUtils.DiyMultipartFile(attachs, urls);
            return ResultUtil.success(diyMouleService.addDiyMould(imgs.get(0),imgs.get(1)));
        }else {
            throw new IceiExeption(ResultEnums.LACKIMG_ERROR);
        }
    }
}
