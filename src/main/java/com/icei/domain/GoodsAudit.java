package com.icei.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GoodsAudit {
	private int recordId;
	private BrandGoods brandGoods;
	private SystemGeneralize systemGeneralize;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh-mm-ss")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh-mm-ss")
	private Date endTime;
	private AuditStatus auditStatus;
	private String auditDetail;
	private GeneralizeAddress generalizeAddress;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public GeneralizeAddress getGeneralizeAddress() {
		return generalizeAddress;
	}

	public void setGeneralizeAddress(GeneralizeAddress generalizeAddress) {
		this.generalizeAddress = generalizeAddress;
	}

	public BrandGoods getBrandGoods() {
		return brandGoods;
	}

	public void setBrandGoods(BrandGoods brandGoods) {
		this.brandGoods = brandGoods;
	}

	public SystemGeneralize getSystemGeneralize() {
		return systemGeneralize;
	}

	public void setSystemGeneralize(SystemGeneralize systemGeneralize) {
		this.systemGeneralize = systemGeneralize;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public AuditStatus getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(AuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditDetail() {
		return auditDetail;
	}

	public void setAuditDetail(String auditDetail) {
		this.auditDetail = auditDetail;
	}
}
