package com.icei.service.adminService;

import com.icei.domain.GoodsModel;
import com.icei.domain.GoodsSize;
import com.icei.mapper.GoodsMediaMapper;
import com.icei.mapper.GoodsModelMapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 商品模板
 * @author YU生俱来
 *
 */
@Service
public class GoodsModelService {
    @Autowired
    private GoodsModelMapper goodsModelMapper;
    /**
     * 根据商品ID获取商品Model
     * @param goodsId
     * @return
     */
    public List<GoodsModel> ByGoodIdGetGoodsModel(int goodsId){
    	return goodsModelMapper.ByGoodIdGetGoodsModel(goodsId);
    }
    
    /**
     * id获取型号模板
     * @param modelId
     * @return
     */
    public GoodsModel getAGoodsModel(Integer modelId){
        return goodsModelMapper.selectByPrimaryKey(modelId);
    }
    /**
	 *  查询全部，带分页，带条件查询
	 * @param map
	 * @return
	 */
	public List<GoodsModel> getAll(Map<String,Object> map){
		return goodsModelMapper.getAll(map);
	}
	/**
	 * 得到全部商品
	 * @param map
	 * @return
	 */
	public int getCount(Map<String,Object> map) {
		return goodsModelMapper.getCount(map);
	}
	/**
	 * 修改
	 * @param m
	 * @return
	 */
	public int update(GoodsModel m) {
		return goodsModelMapper.updateByPrimaryKeySelective(m);
	}
	/**
	 * 添加
	 * @param m
	 * @return
	 */
	public int add(GoodsModel m) {
		return goodsModelMapper.insert(m);
	}
	/**
	 * 删除
	 * @param modelId
	 * @return
	 */
	public int detele(int modelId) {
		return goodsModelMapper.deleteByPrimaryKey(modelId);
	}
}
