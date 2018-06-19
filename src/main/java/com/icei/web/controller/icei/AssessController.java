package com.icei.web.controller.icei;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.icei.domain.AssessImg;
import com.icei.domain.OrderAssess;
import com.icei.service.adminService.OrderAssessService;
import com.icei.utils.*;

@Controller
@RequestMapping("icei")
public class AssessController {
	
	@Autowired
	private OrderAssessService orderAssessService;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	/**
	 * 添加评论
	 * @param assess
	 * @return
	 */
	@PostMapping("/addOrderAssess")
	@ResponseBody
	public Object addAssess(OrderAssess assess,@RequestParam("file")MultipartFile attachs) {
		assess.setLikeCount(0);
		assess.setAssessDate(new Date());
		/*添加评论图片*/
		String url=new String();
		url="/icei/order/refund/";
		String file=upYunTopUtils.MultipartFile(attachs, url);//返回图片地址
		AssessImg assessImg=new AssessImg();
		assessImg.setImgPath(file);
		return ResultUtil.success(orderAssessService.addOrderAssess(assess,assessImg));
	}
}
