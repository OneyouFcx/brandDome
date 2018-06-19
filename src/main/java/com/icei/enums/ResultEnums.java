package com.icei.enums;

/**
 * 错误枚举类
 * @author only
 *
 */
public enum ResultEnums {

	UNKNOWN_ERROR(1, "未知错误"),
	IllEGAL_OPTION(-2,"非法操作"),
	LACK_ERROR(-3,"缺少参数"),
	LACKIMG_ERROR(-4,"缺少图片"),

	SERIAL_ERROR(-100,"验证码错误"),

	IS_CODE(-200,"账号已存在"),
	IS_LOGIN(-201,"账号未登录"),

	NO_ORDER(-600,"该订单不存在"),
	UPD_ORDER(-601,"订单状态已更新"),

	NO_RECORD(-1000,"该记录不存在");

	private Integer code;
	private String msg;

	ResultEnums(Integer code, String msg) {
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
