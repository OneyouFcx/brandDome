//城市三级联动
$(function(){
	var form = layui.form;
	form.render(); //更新全部
	form.on('select(province)', function(data) {
		$("#cmbCity").empty();//清除市
		$("#cmbArea").empty();//清除区
		changeProvince();
		form.render('select'); //刷新select选择框渲染
	});
	//城市
	form.on('select(city)', function(data) {
		$("#cmbArea").empty();//清除区
		changeCity();
		form.render('select'); //刷新select选择框渲染
	});
	//地址选择切换
	$(".section .time h4").eq(0).addClass("change");
	$(".section .time h4").click(function() {
		$(this).addClass("change");
		$(this).siblings("h4").removeClass("change");
	});
	/*回显*/
	biaodan();//地址表单验证
});
/*地址表单验证*/
function biaodan(){
	//验证收货人信息
	var index = parent.layer.getFrameIndex(window.name);
	$('#transmit').on('click', function() {
		var flag=true;
		//验证姓名
		var name=$("#name").val();
		var $name=/([\u4E00-\u9FA5]+|[a-zA-Z]+)/;
		if(name==""){
			layer.msg('请填写收货人姓名',{time:1000});
			flag=false;
			return;
		}
		if($name.test(name)==false){
			layer.msg('请填写真实姓名',{time:1000});
			flag=false;
			return;
		}
		//验证手机号
		var iphone=$("#iphone").val();//获取手机号
		var $iphone=/^1[3|4|5|7|8][0-9]\d{4,8}$/;
		if(iphone==""){
			layer.msg('电话号不能为空', {icon: 5,time:1000,anim:6});
			flag=false;
			return;
		}
		if($iphone.test(iphone)==false){
			layer.msg('电话号格式错误', {icon: 5,time:1000,anim:6});
			flag=false;
			return;
		}
		//验证收货地址
		var cmbArea=$("select[name='cmbArea']").val();
		if(cmbArea==""||cmbArea==null){
			layer.msg('请选择地址',{time:1000});
			flag=false;
			return;
		}
		//验证详细地址
		var tex=$(".layui-textarea").val();
		if(tex.length>100){
			layer.msg('详细地址过长',{time:1000});
			flag=false;
			return;
		}
		if(tex.length==""){
			layer.msg('请填写详细地址', {icon: 5,time:1000,anim:6});
			flag=false;
			return;
		}
		//验证邮编
		var email=$("#email").val();
		var $email=/^[1-9][0-9]{5}$/;
		if(email.trim()==""){
			layer.msg('请填写邮编',{time:1000});
			flag=false;
			return;
		}
		if($email.test(email)==false){
			layer.msg('邮编格式错误',{time:1000});
			flag=false;
			return;
		}
		//地址标签
		var tally=$("#tally").val();
		if(tally==""){
			layer.msg('请填写地址标签',{time:1000});
			flag=false;
			return;
		}
		if(flag==true){
			addres();//添加地址
		}
	});
}