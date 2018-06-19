package alicom.api.controller;

import alicom.api.utils.KdcxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("kdcx")
public class KdcxController {
    @Autowired
    private KdcxUtil kdcxUtil;

    /**
     * 快递查询
     * @param num
     * @param type
     * @return
     */
    @ResponseBody
    @GetMapping("/ems")
    public String kdcx(String num,String type){
        return kdcxUtil.kdcx(num,type);
    }
}
