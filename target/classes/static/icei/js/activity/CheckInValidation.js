/*表单验证*/
//联系人非空验证加正则表达式验证
function checkName(){
	var name=$("input[name='auditName']").val();
	var flag=true;
	if(name==''||name==null){
		layer.msg('姓名不能为空');
		flag=false;
	}else if(!/^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$/.test(name)){
		layer.msg('姓名不能有特殊字符');
		flag=false;
	}else if(/^\d+\d+\d$/.test(name)){
		layer.msg('姓名不能全为数字');
		flag=false;
	}
	if(flag){
		$("input[name='auditName']").css("border"," 1px #e5e5e5 solid");
	}else {
		$("input[name='auditName']").css("border"," 1px #f78983 solid");
	}
	return flag;
}
//联系人地址非空验证
function checkAddress(){
	var auditAddress=$("input[name='auditAddress']").val();
	if(auditAddress==''||auditAddress==null){
		layer.msg('请输入正确的地址信息');
		$("input[name='auditAddress']").css("border"," 1px #f78983 solid");
		return false;
	}
	$("input[name='auditName']").css("border"," 1px #e5e5e5 solid");
	return true;
}
//店铺名称非空验证
function checkBrandName(){
	var brandName=$("input[name='brandName']").val()
	if(brandName==''||brandName==null){
		layer.msg('店铺名不能为空');
		$("input[name='brandName']").css("border"," 1px #f78983 solid");
		return false;
	}else if(!/^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$/.test($("input[name='brandName']").val())){
		layer.msg('店铺名不能有特殊字符');
		$("input[name='brandName']").css("border"," 1px #f78983 solid");
		return false;
	}else if(/^\d+\d+\d$/.test($("input[name='brandName']").val())){
		layer.msg("店铺不能全为数字");
		$("input[name='brandName']").css("border"," 1px #f78983 solid");
		return false;
	}
	$("input[name='brandName']").css("border"," 1px #e5e5e5 solid");
	return true;
}
//店铺介绍非空验证
function checkbrandIntro(){
	var brandIntro=$("input[name='brandIntro']").val();
	if(brandIntro==''||brandIntro==null){
		layer.msg('请填写店铺介绍');
		$("input[name='brandIntro']").css("border"," 1px #f78983 solid");
		return false;
	}
	$("input[name='brandIntro']").css("border"," 1px #e5e5e5 solid");
	return true;
}
//审核人身份证非空验证
function checkauditIdCad(){
	var auditIdCad=$("input[name='auditIdCad']").val();
	if(auditIdCad==''||auditIdCad==null){
		layer.msg('请填写身份证');
		$("input[name='auditIdCad']").css("border"," 1px #f78983 solid");
		return false;
	}else if(!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test($("input[name='auditIdCad']").val())){
		layer.msg('请填写正确的身份证号');
		$("input[name='auditIdCad']").css("border"," 1px #f78983 solid");
		return false;
	}
	$("input[name='auditIdCad']").css("border"," 1px #e5e5e5 solid");
	return true;
}
//店铺图片上传验证是否为空
function checkupload(){
	if($("#upload")[0].files[0]!=null){
		return true;
	}else{
		layer.msg('请上传店铺Log');
		return false;
	}
}
//身份证图片上传验证是否为空
function checkupload1(){
	if($("#upload1")[0].files[0]!=null){
		return true;
	}else{
		layer.msg('请上传身份证正面图片');
		return false;
	}
}
//身份证图片上传验证是否为空
function checkupload2(){
	if($("#upload2")[0].files[0]!=null){
		return true;
	}else{
		layer.msg('请上传身份证反面图片');
		return false;
	}
}
var checkInValidation=function(){
	var a=checkupload2(),
		b=checkupload1(),
		c=checkupload(),
		d=checkauditIdCad(),
		e=checkbrandIntro(),
		f=checkBrandName(),
		g=checkName(),
		h=checkAddress();
	if(a){if(b){if(c){if(d){if(e){if(f){if(g){if(h){
			return true;
	}}}}}}}}
	return false;
}