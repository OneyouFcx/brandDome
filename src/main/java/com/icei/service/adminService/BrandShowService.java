package com.icei.service.adminService;

import java.util.List;

import com.icei.utils.UpYunTopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icei.domain.BrandShow;
import com.icei.domain.Result;
import com.icei.enums.ResultEnums;
import com.icei.exception.IceiExeption;
import com.icei.mapper.BrandShowMapper;
import com.icei.utils.ResultUtil;

@Service
public class BrandShowService {

	@Autowired
	private BrandShowMapper brandShowMapper;
	@Autowired
	private UpYunTopUtils upYunTopUtils;//文件上传

	private final String url = "/icei/brand/usershow/";

	/**
	 * 新增买家秀并上传图片
	 * 
	 * @author:LordMasterKing
	 * @date:2018年5月1日
	 */
	public Result uploadNewBrandShow(MultipartFile attach, String describe, Integer brandId){
		String utilResult = upYunTopUtils.MultipartFile(attach, url);
		if (utilResult != null) {
			BrandShow record = new BrandShow();
			record.setBrandId(brandId);
			record.setImgPath(utilResult);
			record.setDescribe(describe);
			int i = brandShowMapper.insertSelective(record);
			if (i > 0)
				return ResultUtil.success(i);
			else
				throw new IceiExeption(ResultEnums.UNKNOWN_ERROR);
		} else {
			throw new IceiExeption(ResultEnums.UNKNOWN_ERROR);
		}
	}
	/**
	 * 删除买家秀
	 * @author:LordMasterKing
	 * @date:2018年5月2日
	 */
	public Result delBrandShow(Integer id,String fileName) {
		int i=brandShowMapper.deleteByPrimaryKey(id);
		boolean flag=upYunTopUtils.upYunDel(fileName);
		if(i>0&&flag) {
			return ResultUtil.success();
		}else {
			throw new IceiExeption(ResultEnums.UNKNOWN_ERROR);
		}
	}

	/**
	 * 获取买家秀
	 * 
	 * @author:LordMasterKing
	 * @date:2018年5月1日
	 */
	public Result getBrandShow(Integer brandId) throws Exception {
		List<BrandShow> list = brandShowMapper.getByBrandId(brandId);
		if (list == null || list.size() == 0) {
			throw new IceiExeption(ResultEnums.UNKNOWN_ERROR);
		} else {
			return ResultUtil.success(list);
		}
	}
}
