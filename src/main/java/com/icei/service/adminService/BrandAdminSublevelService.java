package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.BrandAdminSublevel;
import com.icei.mapper.BrandAdminSublevelMapper;

@Service
public class BrandAdminSublevelService {
	@Autowired
	public BrandAdminSublevelMapper brandAdminSublevelMapper;
	
	public List<BrandAdminSublevel> getAll(int id){
		return brandAdminSublevelMapper.getAll(id);
	}
	public int getAllCount(int id){
		return brandAdminSublevelMapper.getAllCount(id);
	}
}
