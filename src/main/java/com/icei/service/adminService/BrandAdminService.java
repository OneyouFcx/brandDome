package com.icei.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.icei.domain.Brand;
import com.icei.domain.BrandAdmin;
import com.icei.domain.BrandAudit;
import com.icei.domain.BrandPrincipal;
import com.icei.mapper.BrandAdminMapper;

import java.util.List;
import java.util.Map;

@Service
public class BrandAdminService {
	@Autowired
	private BrandAdminMapper brandAdminMapper;
	
	@Autowired
	private BrandAuditService brandAuditService;//店铺审核
	@Autowired
	private BrandPrincipalService brandPrincipalService;//负责人资料
	@Autowired
	private BrandService brandService;//店铺
	/**
	 * 添加店铺账号
	 * @param code
	 * @param pwd
	 * @param serial 回执编号
	 * @param phone 查询电话
	 * @return
	 */
	@Transactional(value = "transactionManager")
	public int addBrandAdmin(String code,String pwd,String serial,String phone) {
		//用户回执编号查询通过，注册店铺账号
		//前台客户创建账号信息+创建负责人+创建店铺
		int result=0;
		System.out.println(serial+" "+phone);
		BrandAudit brandAudit=brandAuditService.getAuditSerial(serial, phone);
		System.out.println(brandAudit.getAuditName());
		//判断是否通过
		if(brandAudit!=null) {
			if(brandAudit.getAuditStatusId()==1) {
				//创建负责人信息
				BrandPrincipal bp=new BrandPrincipal();
				bp.setAuditName(brandAudit.getAuditName());
				bp.setAuditTel(brandAudit.getAuditTel());
				bp.setAuditAddress(brandAudit.getAuditAddress());
				bp.setAuditIdcad(brandAudit.getAuditIdcad());
				bp.setAuditIdcadImgfront(brandAudit.getAuditIdcadImgfront());
				bp.setAuditIdcadImgback(brandAudit.getAuditIdcadImgback());
				int auditId=brandPrincipalService.addBrandPrincipal(bp);
				//添加店铺
				Brand brand=new Brand();
				brand.setBrandName(brandAudit.getBrandName());
				brand.setIconPath(brandAudit.getBrandPhoto());
				brand.setBrandDesc(brandAudit.getBrandIntro());
				brand.setBrandStatus(0);//封禁状态，绑定店铺账号解封
				int brandId=brandService.addBrand(brand);
				
				//创建店铺账号
				BrandAdmin brandAdmin=new BrandAdmin();
				brandAdmin.setAdminCode(code);
				brandAdmin.setPwd(pwd);
				brandAdmin.setBrandId(brand.getBrandId());//店铺id
				brandAdmin.setPrincipalId(bp.getAuditId());//负责人id
				brandAdmin.setRoleId(1);
				result=brandAdminMapper.insertSelective(brandAdmin);
				
				//删除申请信息
				brandAuditService.delBrandAudit(brandAudit.getBrandId());
			}
		}
		return result;
	}
	/**
	 * 检查账号是否存在
	 * @param adminCode
	 * @return
	 */
	public int getBrandAdminIs(String adminCode) {
		return brandAdminMapper.getBrandAdminIs(adminCode);
	}


	/**
	 * 分页+查询，查询全部
	 * @return
	 */
	public List<BrandAdmin> getAllBrandAdmin(Map<String,Object> map){
		return brandAdminMapper.getAllBrandAdmin(map);
	}
	/**
	 * 查询全部（条件查询的全部条数）
	 * @return
	 */
	public int getCount(Map<String,Object> map) {
		return brandAdminMapper.getCount(map);
	}

	/**
	 * 修改店铺账号状态
	 * @param b
	 * @return
	 */
	public int updateBrandAdmin(BrandAdmin b) {
		return brandAdminMapper.updateByPrimaryKeySelective(b);
	}
}
