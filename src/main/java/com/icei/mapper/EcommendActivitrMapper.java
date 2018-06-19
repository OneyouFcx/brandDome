package com.icei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.EcommendActivitr;

public interface EcommendActivitrMapper {
	 //查询推荐人信息
	 List<EcommendActivitr> getAll(@Param("page")int page,@Param("limit")int limit,@Param("discountsid")int discountsid);
	 //查询子集信息
	 List<EcommendActivitr> selectByINid(@Param("page")int page,@Param("limit")int limit,@Param("id")int id);
	 //根据推荐人查询被推荐人总条数--------查询子集总数量
	 int selectByINidCount(@Param("id")int id);
	 //添加数据---提供给前台
	 int insertAll(@Param("ecommendActivitr")EcommendActivitr ecommendActivitr);
	 //根据推荐人查询总条数
	 int selectCount(@Param("discountsid")int discountsid);
	 //根据count排序查询
	 List<EcommendActivitr> selectorderByCount();
}
