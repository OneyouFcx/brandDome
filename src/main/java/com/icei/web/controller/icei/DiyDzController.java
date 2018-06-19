package com.icei.web.controller.icei;

import com.icei.service.adminService.GoodsInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("icei")
public class DiyDzController {
    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     *  定制页面
     * @param map
     * @param goodsId
     * @param sizeId
     * @return
     */
    @GetMapping("/DiyDz.html")
    public String toDiyDz(Map<String, Object> map,
                          @Param("goodsId")int goodsId,
                          @RequestParam(value = "sizeId", required =false)Integer sizeId){
        map.put("goods",goodsInfoService.getOneGoodsInfo(goodsId));//商品id
        map.put("sizeId",sizeId);//尺寸id
        return "/icei/DiyDz";
    }
}
