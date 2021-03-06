package com.icei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.GoodsMedia;

public interface GoodsMediaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_media
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int deleteByPrimaryKey(Integer introId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_media
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insert(GoodsMedia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_media
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insertSelective(GoodsMedia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_media
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    GoodsMedia selectByPrimaryKey(Integer introId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_media
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKeySelective(GoodsMedia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_media
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKey(GoodsMedia record);
    /**
     * 查询全部
     * @return
     */
    List<GoodsMedia> selectAlls(@Param("brandid")int brandid);
    /**
     * 根据商品id查询
     * @param goodsid
     * @return
     */
    List<GoodsMedia> selectByGoodsId(@Param("goodsid")int goodsid);
}