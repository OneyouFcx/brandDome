package alicom.api.enums;

public enum SmsEnums {
	
	验证码("SMS_122295977","验证码","亲爱的用户，您的验证为${code}，打死都不告诉别人哦。","冰淇淋小屋"),
	
	验证码5Time("SMS_133150689","验证码","亲爱的用户，您的验证为${code}，打死都不告诉别人哦(有效时间5分钟)。","冰淇淋小屋"),
	
	店铺审核通过("SMS_133265416","店铺审核通过","亲爱的${name}，您的店铺:${shop}审核已通过，请尽快到入驻页面处理。","冰淇淋小屋"),
	
	回执编号提示("SMS_132991629","回执编号提示","亲爱的${name}，您的查询编号为:${serial}，请注意保存，尽快帮您处理，请留意查询。","冰淇淋小屋"),
	
	快递通知("SMS_121851208","快递通知","亲爱的${name}，您的快递已在飞奔的路上啦，尽快为您送达，请留意查收。 快递为:${kdnum}。","冰淇淋小屋"),
	
	退款申请提示("SMS_122296849","退款申请提示","亲爱的${name}，您的商品:${order}退款申请已经提交，尽快帮您处理，请留意查收。","冰淇淋小屋"),
	
	退款成功提示("SMS_122286829","退款成功提示","亲爱的${name}，您的商品:${order}已成功退款，请查收。","冰淇淋小屋");
	
	private String code;//模版CODE
	private String name;//模板名称
	private String content;//模板内容
	private String signature;//模板签名
	
	

	SmsEnums(String code, String name,String content,String signature) {
		this.setCode(code);
		this.setName(name);
		this.setContent(content);
		this.setSignature(signature);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
