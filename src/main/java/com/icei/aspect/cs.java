package com.icei.aspect;

/**
 * 错误枚举类
 * @author only
 *
 */
public enum cs {

	UNKNOWN_ERROR(1, "未知错误"),
	LACK_ERROR(-100,"缺少参数"),
	LACKIMG_ERROR(-101,"缺少图片");
	
	private Integer code;
	private String msg;

	cs(Integer code, String msg) {
		this.code = code;
		this.setMsg(msg);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
