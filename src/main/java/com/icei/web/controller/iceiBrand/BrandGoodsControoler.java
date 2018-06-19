package com.icei.web.controller.iceiBrand;

import java.lang.reflect.Array;
import java.util.List;

import com.icei.utils.UpYunTopUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import com.icei.domain.BrandGoods;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.service.adminService.BrandGoodsService;
import com.icei.service.adminService.GoodsTypeDetailService;
import com.icei.service.adminService.GoodsTypeService;
import com.icei.utils.ResultUtil;

@Controller
@RequestMapping("/brand")
public class BrandGoodsControoler {
	@Autowired
	public BrandGoodsService brandGoodsService;
	//商品分类
	@Autowired
	private GoodsTypeService gts;
	//商品详细分类
	@Autowired
	private GoodsTypeDetailService goodsTypeDetailService;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传
	/**
	 * 映射
	 * @return
	 */
	@RequestMapping("/brandgoods.html")
	public String getMain() {
		return "iceiBrand/goods/groods.html";
	}
	@RequestMapping("/addbrandgroods.html")
	public String selectByaddGroods() {
		return "iceiBrand/goods/addgroods";
	}
	/**
	 * 查询所有商品信息
	 * @return
	 */
	@RequestMapping("/message")
	@ResponseBody
	public Object getAllMessage(@Param("page")int page,@Param("limit")int limit,@Param("typeDetailId")int typeDetailId,@Param("goodsId")int goodsId) {
		return ResultUtil.success(
				brandGoodsService.getAllMessage(page,limit,typeDetailId,goodsId,0),
				brandGoodsService.getselectAllmsgCount(typeDetailId,goodsId,0));
	}
	/**
	 * 根据Id杉树数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/delByIdbrandgoodsid")
	@ResponseBody
	public Object delByid(@RequestParam(value="id",required=false)int id) {
		return ResultUtil.success(brandGoodsService.deleteByPrimaryKey(id));
	}
	/**
	 * 添加一条数据   /  对象形式添加   /  文件上传
	 * @param record 对象
	 * @return
	 */
	@PostMapping("/insertByKey")
	@ResponseBody
	public Object insertByKey(@Param("brandGoods")BrandGoods record,@RequestParam("file")MultipartFile[] attachs) {
		String url1="/icei/goods/mainimg/";
		String url2="/icei/diyback/";
		if(attachs!=null) {
			String[] url=new String [] {url1,url2};
			List<String> file=upYunTopUtils.MultipartFile(attachs, url);//返回图片地址+名称
			record.setGoodsImg(file.get(0));
			System.out.println(file.get(0));
			if((file.size())>1) {
				record.setDiyBack(file.get(1));
				System.out.println(file.get(1));
			}
			return ResultUtil.success(brandGoodsService.InsertintoByKey(record));
		}else {
			throw new IceiExeption(ResultEnums.LACKIMG_ERROR);
		}
	}
	/**
	 * 根据传入的对象进行修改信息
	 * @param record
	 * @return
	 */
	@PostMapping("/updateByKey")
	@ResponseBody
	public Object updateByKey(@Param("brandGoods")BrandGoods record) {
		return ResultUtil.success(brandGoodsService.updateByPrimaryKeySelective(record));
	}
	/**
	 * 页面加载获得页面顶部下拉框数据
	 * @return
	 */
	@GetMapping("/getAllGoodsTypeName")
	@ResponseBody
	public Object getAllGoodsTypeName() {
		return gts.getAlls();
	}
	/**
	 * 查询详细商品分类的信息
	 * @return
	 */
	@GetMapping("/getAllTypeDetailName")
	@ResponseBody
	public Object selectByTypeName() {
		return goodsTypeDetailService.getAllTypeDetailName();
	}
	/**
	 * 根据ID查询详细商品分类的信息
	 * @return
	 */
	@GetMapping("/getAllTypeDetailNameByid")
	@ResponseBody
	public Object selectByTypeNameByid(@Param("id")int id) {
		return goodsTypeDetailService.getAllTypeDetailNameByid(id);
	}
	
	
	

}
