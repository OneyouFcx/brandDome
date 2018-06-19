package com.icei.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import java.util.Date;

/**
 * 总订单
 */
public class Order {

	private Integer orderId;//订单ID

	private Integer userId;//用户id

	@Excel(name = "订单号",width=30, orderNum = "1")
	private String orderIndex;//商家订单号

	@Excel(name = "交易号",replace = {"未付款_null"}, orderNum = "2")
	private String tradeIndex;//交易号

	@Excel(name = "支付方式",replace = {"未付款_null"}, orderNum = "3")
	private Integer paymentId;//支付方式

	private Integer statusId;

	@ExcelEntity(id = "statusId")
	private OrderStatus orderStatus;//订单状态

	private int addressId;//地址ID

	@Excel(name = "快递单号",replace = {"未发货_null"}, orderNum = "5")
	private String expId;//快递单号

	@Excel(name = "快递公司",replace = {"未发货_null"}, orderNum = "6")
	private String expType;//快递公司

	@Excel(name = "订单总价", orderNum = "7")
	private Double orderPrice;//订单总价

	@Excel(name = "创建时间",width = 15,exportFormat = "yyyy-MM-dd hh:mm:ss", orderNum = "8")
	private Date creationDate;//创建时间

	@Excel(name = "付款时间",width = 15,exportFormat = "yyyy-MM-dd hh:mm:ss", orderNum = "9")
	private Date paidDate;//付款时间

	@Excel(name = "发货时间",width = 15,exportFormat = "yyyy-MM-dd hh:mm:ss", orderNum = "10")
	private Date sendDate;//发货时间

	@Excel(name = "成交时间",width = 15,exportFormat = "yyyy-MM-dd hh:mm:ss", orderNum = "11")
	private Date finishDate;//成交时间

	@Excel(name = "订单金额", orderNum = "12")
	private Double orderMoney;//订单金额

	private Integer discountsId;//优惠券id

	@Excel(name = "活动优惠总金额(折扣)", orderNum = "13")
	private Double discountsMoney;//活动优惠总金额(折扣)

	private UserDetail userDetail;//用户信息

	private UserAddress userAddress;//用户地址

	@ExcelEntity(id = "detailId")
	private OrderDetail orderDetail;//子订单
	
	private Payment payMent;//付款方式

	public Payment getPayMent() {
		return payMent;
	}

	public void setPayMent(Payment payMent) {
		this.payMent = payMent;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(String orderIndex) {
		this.orderIndex = orderIndex;
	}

	public String getTradeIndex() {
		return tradeIndex;
	}

	public void setTradeIndex(String tradeIndex) {
		this.tradeIndex = tradeIndex;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Double getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}

	public Double getDiscountsMoney() {
		return discountsMoney;
	}

	public void setDiscountsMoney(Double discountsMoney) {
		this.discountsMoney = discountsMoney;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public Integer getDiscountsId() {
		return discountsId;
	}

	public void setDiscountsId(Integer discountsId) {
		this.discountsId = discountsId;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
}