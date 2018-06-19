package com.icei.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SystemGeneralize {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_generalize.generalize_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer generalizeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_generalize.address_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer addressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_generalize.generalize_money
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Float generalizeMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_generalize.generalize_commission
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    
    private Float generalizeCommission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_generalize.generalize_start_time
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date generalizeStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_generalize.generalize_end_time
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")  
    private Date generalizeEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_generalize.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer brandId;

    /**
     * 推荐位置 
     * 作用于方便查询数据
     */
    private String addressName;
    
    
    public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_generalize.generalize_id
     *
     * @return the value of system_generalize.generalize_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getGeneralizeId() {
        return generalizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_generalize.generalize_id
     *
     * @param generalizeId the value for system_generalize.generalize_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setGeneralizeId(Integer generalizeId) {
        this.generalizeId = generalizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_generalize.address_id
     *
     * @return the value of system_generalize.address_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_generalize.address_id
     *
     * @param addressId the value for system_generalize.address_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_generalize.generalize_money
     *
     * @return the value of system_generalize.generalize_money
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Float getGeneralizeMoney() {
        return generalizeMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_generalize.generalize_money
     *
     * @param generalizeMoney the value for system_generalize.generalize_money
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setGeneralizeMoney(Float generalizeMoney) {
        this.generalizeMoney = generalizeMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_generalize.generalize_commission
     *
     * @return the value of system_generalize.generalize_commission
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Float getGeneralizeCommission() {
        return generalizeCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_generalize.generalize_commission
     *
     * @param generalizeCommission the value for system_generalize.generalize_commission
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setGeneralizeCommission(Float generalizeCommission) {
        this.generalizeCommission = generalizeCommission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_generalize.generalize_start_time
     *
     * @return the value of system_generalize.generalize_start_time
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Date getGeneralizeStartTime() {
        return generalizeStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_generalize.generalize_start_time
     *
     * @param generalizeStartTime the value for system_generalize.generalize_start_time
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setGeneralizeStartTime(Date generalizeStartTime) {
        this.generalizeStartTime = generalizeStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_generalize.generalize_end_time
     *
     * @return the value of system_generalize.generalize_end_time
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Date getGeneralizeEndTime() {
        return generalizeEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_generalize.generalize_end_time
     *
     * @param generalizeEndTime the value for system_generalize.generalize_end_time
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setGeneralizeEndTime(Date generalizeEndTime) {
        this.generalizeEndTime = generalizeEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_generalize.brand_id
     *
     * @return the value of system_generalize.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_generalize.brand_id
     *
     * @param brandId the value for system_generalize.brand_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}