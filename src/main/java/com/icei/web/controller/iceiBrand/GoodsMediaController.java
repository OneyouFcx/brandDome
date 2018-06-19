package com.icei.web.controller.iceiBrand;


import com.icei.utils.UpYunTopUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.icei.domain.GoodsMedia;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.GoodsMediaService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("/brand")
public class GoodsMediaController {
	@Autowired
	private GoodsMediaService goodsMediaService;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	
	@RequestMapping("/goodsmodel.html")
	public String getHome() {
		return "/iceiBrand/goods/imgmanage";
	}
	/**
	 * 查询全部
	 * @return
	 */
	@PostMapping("/selectAlls")
	@ResponseBody
	public Object selectAlls() {
		int brandid=1;
		return goodsMediaService.selectAlls(brandid);
	}
	/**
	 * 根据商品编号查询相关图片
	 * @param goodsid
	 * @return
	 */
	@PostMapping("/selectbygoodsid")
	@ResponseBody
	public Object getAllByGoodsId(int goodsid) {
		return ResultUtil.success(goodsMediaService.getAllBygoodsid(goodsid));
	}
	
	@PostMapping("/deleteByintroid")
	@ResponseBody
	public Object delByid(@Param("introid")int introid) {
		return ResultUtil.success(goodsMediaService.deleteByid(introid));
	}
	
	/**
	 * 添加数据根据对象
	 * @return
	 */
	@RequestMapping("insertMediaimg")
	@ResponseBody
	public Object insert(@Param("record")GoodsMedia record,@RequestParam("file")MultipartFile[]  file) {
		String img="/icei/goods/img/";//图片
		String viv="/icei/goods/video/";//视频
		boolean flas=true;
		String [] url=new String[file.length];
		String type="";
		if(file.length>=0) {
			for(int i=0;i<file.length;i++) {
				if(file[i]==null) {
					break;
				}
				 String fileName = file[i].getOriginalFilename();//获取文件名
				 System.out.println(fileName);
				 String prefix=fileName.substring(fileName.lastIndexOf("."));//获取文件后缀
				 System.out.println(prefix);
				 if(prefix.equals(".png")||prefix.equals(".jpeg")||prefix.equals(".gif")||prefix.equals(".jpg")) {
				 	String imgname=upYunTopUtils.MultipartFile(file[i], img);
				 	type="img";
				 	int num=uploading(type,imgname,record);
				 	if(num!=1) {
						flas=false;
					}
				 }
				 if(prefix.equals(".mp4")||prefix.equals(".avi")||prefix.equals(".x-msvideo")) {
					String imgname=upYunTopUtils.MultipartFile(file[i], viv);
					type="video";
					int num=uploading(type,imgname,record);
				 	if(num!=1) {
						flas=false;
					}
				 }
			}
			return ResultUtil.success(flas);
		}else{
			throw new IceiExeption(ResultEnums.LACKIMG_ERROR);
		}
	}
	
	public int uploading(String type,String imgname,GoodsMedia record) {
		record.setIntroPath(imgname);//添加图片路径
		record.setIntroType(type);
		return goodsMediaService.insertinto(record);
	}
}

