package com.icei.service.adminService;

import com.icei.domain.BrandHot;
import com.icei.mapper.BrandHotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandHotService {
    @Autowired
    private BrandHotMapper brandHotMapper;
    
    /**
     * 查询是否存在重复值
     * @param goodsid
     * @return
     */
    public int selectBygoodsid(int goodsid) {
    	return brandHotMapper.selectBygoodsid(goodsid);
    }

    /**
     * 获取店铺热门
     * @param brandId
     * @return
     */
    public List<BrandHot> getBrandHotAll(int brandId){
        return brandHotMapper.getBrandHotAll(brandId);
    }
    /**
     * 查询全部
     * @param hotId
     * @return
     */
    public List<BrandHot> getAllmsg(Integer hotId,int page,int limit){
    	page=(page-1)*limit;
        return brandHotMapper.getAllmsg(hotId,page,limit);
    }
    /**
     * 查询总条数
     * @param hotId
     * @return
     */
    public int getAllcount(Integer hotid) {
    	return brandHotMapper.getAllmsgCount(hotid);
    }
    
    public int delByid(Integer hotId) {
    	return brandHotMapper.deleteByPrimaryKey(hotId);
    }
    
    public int insertinto(BrandHot record) {
    	return brandHotMapper.insertSelective(record);
    }
}
