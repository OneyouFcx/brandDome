package com.icei.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.GoodsType;
import com.icei.domain.GoodsTypeDetail;

public interface GoodsTypeDetailMapper {
	
	/**
	 * 得到全部商品类别信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<GoodsTypeDetail> getAllGoodsTypeDetail(Map<String,Object> map);
	
	/**
	 * 得到商品分类名称
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<GoodsTypeDetail> getAllTypeDetailName();
	/**
	 * 根据类型Id获取详细类型
	 * @param typeId
	 * @return
	 */
	List<GoodsTypeDetail>  getAllTypeDetailNameByid(@Param("typeId")int typeId);
	
	/**
	 * 得到全部数量
	 * @return
	 */
	int getCount(Map<String,Object> map);
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type_detail
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int deleteByPrimaryKey(Integer typeDetailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type_detail
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insert(GoodsTypeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type_detail
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insertSelective(GoodsTypeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type_detail
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    GoodsTypeDetail selectByPrimaryKey(Integer typeDetailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type_detail
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKeySelective(GoodsTypeDetail gt);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type_detail
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKey(GoodsTypeDetail record);
}