package com.icei.web.controller.iceiPhone;


import com.icei.service.adminService.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("iceiPhone")
public class PhoneDiyDzController {
    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     *  定制页面
     * @param map
     * @param goodsId
     * @param sizeId
     * @return
     */
    @GetMapping("{goodsId}/diydz.html")
    public String toDiyDz(Map<String, Object> map,
                          @PathVariable int goodsId,
                          @RequestParam(value = "sizeId", required =false)Integer sizeId){
        map.put("goods",goodsInfoService.getOneGoodsInfo(goodsId));//商品id
        map.put("sizeId",sizeId);//尺寸id
        return "iceiPhone/diydz";
    }
}
