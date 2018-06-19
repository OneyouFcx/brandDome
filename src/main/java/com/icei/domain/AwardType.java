package com.icei.domain;

public class AwardType {
	
	private int templateId;
	
	private Template template;
	
    private Integer awardTypeId;

    private String awardName;

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Integer getAwardTypeId() {
		return awardTypeId;
	}

	public void setAwardTypeId(Integer awardTypeId) {
		this.awardTypeId = awardTypeId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
    
  
}