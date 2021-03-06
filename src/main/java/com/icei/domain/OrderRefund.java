package com.icei.domain;

public class OrderRefund {
	private Order order;
    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.user_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.brand_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private Integer brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.order_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.refund_content
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private String refundContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.order_state_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private Integer orderStateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.brand_content
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private String brandContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.img_path
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    private String imgPath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.id
     *
     * @return the value of order_refund.id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.id
     *
     * @param id the value for order_refund.id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.user_id
     *
     * @return the value of order_refund.user_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.user_id
     *
     * @param userId the value for order_refund.user_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.brand_id
     *
     * @return the value of order_refund.brand_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.brand_id
     *
     * @param brandId the value for order_refund.brand_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.order_id
     *
     * @return the value of order_refund.order_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.order_id
     *
     * @param orderId the value for order_refund.order_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.refund_content
     *
     * @return the value of order_refund.refund_content
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public String getRefundContent() {
        return refundContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.refund_content
     *
     * @param refundContent the value for order_refund.refund_content
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setRefundContent(String refundContent) {
        this.refundContent = refundContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.order_state_id
     *
     * @return the value of order_refund.order_state_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public Integer getOrderStateId() {
        return orderStateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.order_state_id
     *
     * @param orderStateId the value for order_refund.order_state_id
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.brand_content
     *
     * @return the value of order_refund.brand_content
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public String getBrandContent() {
        return brandContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.brand_content
     *
     * @param brandContent the value for order_refund.brand_content
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setBrandContent(String brandContent) {
        this.brandContent = brandContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.img_path
     *
     * @return the value of order_refund.img_path
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.img_path
     *
     * @param imgPath the value for order_refund.img_path
     *
     * @mbg.generated Sun May 13 17:54:56 CST 2018
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}