package com.icei.service.adminService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icei.domain.Brand;
import com.icei.domain.BrandAudit;
import com.icei.domain.BrandPrincipal;
import com.icei.mapper.BrandAuditMapper;
import com.icei.utils.RandomCharData;

/**
 * 
 * @author 小诺诺
 *
 */
@Service
public class BrandAuditService {
	@Autowired
	private BrandAuditMapper brandAuditMapper;
	
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @param id
	 * @param val
	 * @param statusId
	 * @return
	 */
	public List<BrandAudit> getAuditPage(int page,int pageSize,int id,String val,int statusId) {
		return brandAuditMapper.getBrandAuditPage(page, pageSize,id,val,statusId);
	}
	/**
	 * 店铺id查询
	 * @param brandid
	 * @return
	 */
	public BrandAudit getBrandAudit(int brandid) {
		return brandAuditMapper.selectByPrimaryKey(brandid);
	}
	/**
	 * 查询总条数
	 * @param id
	 * @param val
	 * @param statusId
	 * @return
	 */
	public int getCount(int id,String val,int statusId) {
		return brandAuditMapper.getCount(id,val,statusId);
	}
	/**
	 * 更新审核状态
	 * @param statusId
	 * @param brandId
	 * @return
	 */
	public int updStatus(int statusId,int brandId) {
		int result=0;
		if(brandAuditMapper.getBrandStatus(brandId)==2) {
			BrandAudit ba=new BrandAudit();
			ba.setBrandId(brandId);
			ba.setAuditStatusId(statusId);
			ba.setAuditPassTime(new Date());
			result=brandAuditMapper.updateByPrimaryKeySelective(ba);
		}
		return result;
	}
	/**
	 * 添加审核
	 * @param brandAudit
	 * @return
	 */
	@Transactional(value = "transactionManager")
	public String addBrandAudit(String brandName,String brandIntro,
			String auditName,String auditTel,
			String auditAddress,Long auditIdcad,List<String> imgs) {
		
		String serial=RandomCharData.getStringRandom(8);
		BrandAudit brandAudit=new BrandAudit();
		brandAudit.setBrandName(brandName);
		brandAudit.setBrandIntro(brandIntro);
		brandAudit.setAuditName(auditName);
		brandAudit.setAuditTel(auditTel);
		brandAudit.setAuditAddress(auditAddress);
		brandAudit.setAuditIdcad(auditIdcad);
		brandAudit.setBrandPhoto(imgs.get(0));
		brandAudit.setAuditIdcadImgfront(imgs.get(1));
		brandAudit.setAuditIdcadImgback(imgs.get(2));
		
		brandAudit.setAuditStatusId(2);;//店铺状态
		brandAudit.setAuditSerial(serial);//回执编码
		brandAudit.setAuditTime(new Date());//创建时间
		//判断是否添加成功
		if(brandAuditMapper.insertSelective(brandAudit)!=1) {
			return null;
		}
		return serial;
	}
	/**
	 * 查询审核
	 * @param serial 回执编码
	 * @param phone 查询手机号
	 * @return
	 */
	public BrandAudit getAuditSerial(String serial,String phone) {
		return brandAuditMapper.getAuditSerial(serial, phone);
	}
	/**
	 * 删除申请信息
	 * @param brandId
	 * @return
	 */
	public int delBrandAudit(int brandId) {
		return brandAuditMapper.deleteByPrimaryKey(brandId);
	}
}
