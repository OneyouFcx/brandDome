package com.icei.domain;

public class BrandHot {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_hot.hot_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer hotId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_hot.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand_hot.goods_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer goodsId;



    private BrandGoods goods;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_hot.hot_id
     *
     * @return the value of brand_hot.hot_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getHotId() {
        return hotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_hot.hot_id
     *
     * @param hotId the value for brand_hot.hot_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setHotId(Integer hotId) {
        this.hotId = hotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_hot.brand_id
     *
     * @return the value of brand_hot.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_hot.brand_id
     *
     * @param brandId the value for brand_hot.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand_hot.goods_id
     *
     * @return the value of brand_hot.goods_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand_hot.goods_id
     *
     * @param goodsId the value for brand_hot.goods_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public BrandGoods getGoods() {
        return goods;
    }

    public void setGoods(BrandGoods goods) {
        this.goods = goods;
    }
}