package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.EcommendActivitr;
import com.icei.mapper.EcommendActivitrMapper;

@Service
public class EcommendActivitrService {
	@Autowired
	public EcommendActivitrMapper ecommendActivitrMapper;
	/**
	 * 查询所有推荐人的信息
	 * @param page
	 * @param limit
	 * @param discountsid
	 * @return
	 */
	public List<EcommendActivitr>  getAllmsg(int page,int limit,int discountsid){
		return ecommendActivitrMapper.getAll(page,limit,discountsid);
	}
	/**
	 * 根据ID查询多个数据   -根据推荐人查询被推荐人
	 * @param id
	 * @return
	 */
	public  List<EcommendActivitr> selectByid(int page,int limit,int id){
		page=(page-1)*limit;
		return ecommendActivitrMapper.selectByINid(page,limit,id);
	}
	/**
	 * 添加数据
	 * @param ecommendActivitr
	 * @return
	 */
	public int insertAllEcommend(EcommendActivitr ecommendActivitr) {
		return ecommendActivitrMapper.insertAll(ecommendActivitr);
	}
	/**
	 * 查询推荐人总条数
	 * @return
	 */
	public int selectcount(int discountsid) {
		return ecommendActivitrMapper.selectCount(discountsid);
	}
	/**
	 * 根据推荐人id查询所有子集总数
	 * @param id
	 * @return
	 */
	public int selectByidCount(int id) {
		return ecommendActivitrMapper.selectByINidCount(id);
	}
	/**
	 * 排序-根据邀请人总数
	 * @return
	 */
	public List<EcommendActivitr> selectorderByCount(){
		return ecommendActivitrMapper.selectorderByCount();
	}
}
