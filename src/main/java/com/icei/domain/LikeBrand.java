package com.icei.domain;

public class LikeBrand {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like_brand.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like_brand.user_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like_brand.brand_id
     *
     * @return the value of like_brand.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like_brand.brand_id
     *
     * @param brandId the value for like_brand.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like_brand.user_id
     *
     * @return the value of like_brand.user_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like_brand.user_id
     *
     * @param userId the value for like_brand.user_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}