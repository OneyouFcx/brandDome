package com.icei.service.adminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.Brand;
import com.icei.domain.Result;
import com.icei.mapper.BrandMapper;
/**
 * 
 * @author AdminFcx
 *
 */
@Service
public class BrandService {
	@Autowired
	public BrandMapper brandMapper;//自动适配接口

	/**
	 * 获取所有店铺
	 * @return
	 */
	public List<Brand> getBrandAll(){
		return brandMapper.getBrandAll();
	}

	/**
	 * 获取店铺信息
	 * @param id
	 * @return
	 */
	public Brand getABrand(int id){
		return brandMapper.selectByPrimaryKey(id);
	}
	/**
	 * 分页查询
	 * @param page
	 * @param end
	 * @return
	 */
	public Result getAllMessageService(int page,int end,int id,String name){
		int count=brandMapper.selectByidCount(id,name);//总条数
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", page);
		map.put("end", end);
		map.put("id", id);
		map.put("nametype", name);
		List<Brand> list=brandMapper.selectAllMessage(map);//商店的详细信息分类
		Result result=new Result();
		result.setCode(0);
		result.setData(list);
		result.setCount(count);
		result.setMsg("成功");
		return result;
	}
	/**
	 * 修改状态
	 * @param id
	 * @param num
	 * @return
	 */
	public int updateByid(int id,int num) {
		int nmb=brandMapper.updateByStatus(id, num);
		return nmb;
	}
	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	public int addBrand(Brand record) {
		return brandMapper.insertSelective(record);
	}
	/**
	 * 个人中心关注店铺
	 * @param userId
	 * @return
	 */
	public List<Brand> getUserLikeBrand(int userId){
		return brandMapper.getUserLikeBrand(userId);
	}
}
