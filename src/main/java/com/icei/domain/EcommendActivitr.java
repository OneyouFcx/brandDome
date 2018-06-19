package com.icei.domain;
/**
 * 推荐有礼
 * @author 范存鑫
 *
 */
public class EcommendActivitr {
	private int ecommendId;
	private int  ecommendUserid;
	private int ecommendCount;
	private int count;
	private String ecommendName;
	private int discountsId;
	private Discounts discounts;//优惠卷
	private UserDetail userDetail;//推荐人信息
	public EcommendActivitr(int ecommendId, int ecommendUserid, int ecommendCount, int count, String ecommendName,
			int discountsId) {
		this.ecommendId = ecommendId;
		this.ecommendUserid = ecommendUserid;
		this.ecommendCount = ecommendCount;
		this.count = count;
		this.ecommendName = ecommendName;
		this.discountsId = discountsId;
	}
	public EcommendActivitr() {
	}
	
	public Discounts getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Discounts discounts) {
		this.discounts = discounts;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public int getEcommendId() {
		return ecommendId;
	}
	public void setEcommendId(int ecommendId) {
		this.ecommendId = ecommendId;
	}
	public int getEcommendUserid() {
		return ecommendUserid;
	}
	public void setEcommendUserid(int ecommendUserid) {
		this.ecommendUserid = ecommendUserid;
	}
	public int getEcommendCount() {
		return ecommendCount;
	}
	public void setEcommendCount(int ecommendCount) {
		this.ecommendCount = ecommendCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getEcommendName() {
		return ecommendName;
	}
	public void setEcommendName(String ecommendName) {
		this.ecommendName = ecommendName;
	}
	public int getDiscountsId() {
		return discountsId;
	}
	public void setDiscountsId(int discountsId) {
		this.discountsId = discountsId;
	}
	
}
