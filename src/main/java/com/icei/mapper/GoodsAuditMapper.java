package com.icei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.GoodsAudit;

public interface GoodsAuditMapper {
	Integer findGoodsAuditCountByParams(@Param("page")Integer page,@Param("limit")Integer limit,@Param("keyword")Integer keyword,@Param("searchType")Integer searchType);
	List<GoodsAudit> findGoodsAuditByParams(@Param("page")Integer page,@Param("limit")Integer limit,@Param("keyword")Integer keyword,@Param("searchType")Integer searchType);
    Integer updateStatus(@Param("id")Integer id,@Param("option") Integer option);
}
