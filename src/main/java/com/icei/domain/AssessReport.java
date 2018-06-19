package com.icei.domain;

public class AssessReport {
	private OrderAssess orderAssess;
    public OrderAssess getOrderAssess() {
		return orderAssess;
	}

	public void setOrderAssess(OrderAssess orderAssess) {
		this.orderAssess = orderAssess;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assess_report.audit_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer auditId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assess_report.assess_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer assessId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assess_report.user_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assess_report.report_content
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    private String reportContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assess_report.audit_id
     *
     * @return the value of assess_report.audit_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getAuditId() {
        return auditId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assess_report.audit_id
     *
     * @param auditId the value for assess_report.audit_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assess_report.assess_id
     *
     * @return the value of assess_report.assess_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getAssessId() {
        return assessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assess_report.assess_id
     *
     * @param assessId the value for assess_report.assess_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setAssessId(Integer assessId) {
        this.assessId = assessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assess_report.user_id
     *
     * @return the value of assess_report.user_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assess_report.user_id
     *
     * @param userId the value for assess_report.user_id
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assess_report.report_content
     *
     * @return the value of assess_report.report_content
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assess_report.report_content
     *
     * @param reportContent the value for assess_report.report_content
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}