package com.icei.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

/**
 * 子订单
 */
public class OrderDetail {

	private Integer detailId;//子订单id

	private Integer orderId;//订单ID

	private Integer goodsId;//商品ID
	@Excel(name = "商品数量", orderNum = "1")
	private Integer detailCount;//商品数量

	private Integer diyMould;//定制模板

	private Integer typeMould;//商品模版

	@Excel(name = "商品价格", orderNum = "2")
	private Float singleMoney;//商品价格

	@Excel(name = "商品尺寸",replace = {"默认_null"}, orderNum = "3")
	private Integer goodsSize;//商品尺寸

	@Excel(name = "折扣", orderNum = "4")
	private Float discount;//折扣

	@ExcelEntity(id = "goodsId")
	private BrandGoods brandGoods;//商品内容



	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getDetailCount() {
		return detailCount;
	}

	public void setDetailCount(Integer detailCount) {
		this.detailCount = detailCount;
	}

	public Integer getDiyMould() {
		return diyMould;
	}

	public void setDiyMould(Integer diyMould) {
		this.diyMould = diyMould;
	}

	public Integer getTypeMould() {
		return typeMould;
	}

	public void setTypeMould(Integer typeMould) {
		this.typeMould = typeMould;
	}

	public Float getSingleMoney() {
		return singleMoney;
	}

	public void setSingleMoney(Float singleMoney) {
		this.singleMoney = singleMoney;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(Integer goodsSize) {
		this.goodsSize = goodsSize;
	}

	public BrandGoods getBrandGoods() {
		return brandGoods;
	}

	public void setBrandGoods(BrandGoods brandGoods) {
		this.brandGoods = brandGoods;
	}
}