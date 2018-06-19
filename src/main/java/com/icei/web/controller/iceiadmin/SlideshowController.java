package com.icei.web.controller.iceiadmin;

import java.util.List;

import com.icei.utils.UpYunTopUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.icei.domain.Slideshow;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.SlideshowService;
import com.icei.utils.ResultUtil;

/**
 * 主页轮播
 * @author only
 *
 */
@Controller
@RequestMapping("admin/sys")
public class SlideshowController {
	@Autowired
	private SlideshowService slideshowService;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	/**
	 * 获取全部轮播
	 * @return
	 */
	@ResponseBody
	@GetMapping("getSlideAll")
	public Object getSlideAll() {
		return ResultUtil.success(slideshowService.getSlideAll());
	}
	/**
	 * 添加轮播
	 * @param slideshow
	 * @return
	 */
	@ResponseBody
	@PostMapping("addSlideshow")
	public Object addSlideshow(@Param("slideshow")Slideshow slideshow,@RequestParam("file")MultipartFile[] attachs) {
		if(attachs.length>=2&&attachs.length<=3) {
			String[] urls=new String[attachs.length];
			for (int i = 0; i < attachs.length; i++) {
				if(i==0) {
					urls[i]="/icei/slideshow/img/";
				}else if(i==1){
					urls[i]="/icei/slideshow/back/";
				}else {
					urls[i]="/icei/slideshow/video/";
				}
			}
			List<String> file=upYunTopUtils.MultipartFile(attachs, urls);
			slideshow.setGoodsImg(file.get(0));
			slideshow.setGoodsBack(file.get(1));
			if(attachs.length>2) {
				slideshow.setGoodsVideo(file.get(2));
			}
			return ResultUtil.success(slideshowService.addSlideshow(slideshow));
		}else {
			throw new IceiExeption(ResultEnums.LACKIMG_ERROR);
		}
	}
	/**
	 * 删除轮播
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("delSlideshow")
	public Object delSlideshow(@Param("id")Integer id) {
		return ResultUtil.success(slideshowService.delSlideshow(id));
	}
	
	/**
	 * 修改轮播
	 * @param slideshow
	 * @return
	 */
	@ResponseBody
	@PutMapping("updSlideshow")
	public Object updSlideshow(@ModelAttribute Slideshow slideshow) {
		return ResultUtil.success(slideshowService.updSlideshow(slideshow));
	}
}
