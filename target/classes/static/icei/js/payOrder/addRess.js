/*查询地址*/
$(function(){
	getres();//显示地址
	/*地址弹出层*/
	$(".add dl").click(function() {
		layer.open({
			type: 1,
			title: '填写收货地址',
			shadeClose: true,
			shade: 0.6,
			area: ['700px','450px'],
			content: $('.fly'),
			move: false,
			resize: false,
			skin: 'add-class',
			success: function(layero, index){
				var form = layui.form;
				form.render('select'); //刷新select选择框渲染
				},
			end :function(){
				$('.fly').css("display","none");
			}
		});
	});
});
//选择收货切换
function resItme(dom){
	$(dom).addClass("change");
	$(dom).find(".actions").removeClass("layui-hide");
	$(dom).siblings().removeClass("change");
	$(dom).siblings().find(".actions").addClass("layui-hide");
	$(dom).attr("select",1);
	$(dom).siblings().attr("select",0);
};
function getres(){
	$.ajax({
		url:"getUserAddress",
		type:"get",
		dataType:"json",
		success:show
	});
	function show(data){
		if(data.code==0){
            $.each(data.data,function(k,v){
                var dom=$('<div class="address-itme" select="0" siteId="'+v.addressId+'" onclick="resItme(this)"><dl><dt>'+
                    '<span class="tag">'+v.tally+'</span>'+
                    '<em>'+v.name+'</em></dt>'+
                    '<dd>'+v.phone+'</dd>'+
                    '<dd class="unaddress">'+v.region+'</dd>'+
                    '<dd class="street">'+v.street+'</dd>'+
                    '<dd class="actions layui-hide">'+
                    '<a class="change" id="amend">修改</a>'+
                    '<a class="change" siteId="'+v.addressId+'" onclick="delres(this)">删除</a>'+
                    '</dd></dl></div>');
                $(".section-foot").prepend(dom);
            });
		}else {
			layer.msg(data.msg);
		}
	}
}
/*添加地址*/
function addres(){
	var name=$("#name").val(),
		phone=$("#iphone").val(),
		region=$("#cmbProvince").val()+" "+$("#cmbCity").val()+" "+$("#cmbArea").val(),//地址
		street=$(".layui-textarea").val(),
		postcode=$("#email").val(),
		tally=$("#tally").val();
	var json={
		"name":name,"phone":phone,
        "region":region,"street":street,
        "postcode":postcode,"tally":tally
        }
	$.ajax({
		url:"addUserAddress",
		type:"POST",
		data:json,
		dataType:"json",
		success:show
	});
	function show(data){
		if(data.code==0&&data.data!=null){
            layer.closeAll('page');
			layer.msg('添加成功');
            var dom=$('<div class="address-itme" select="0" siteId="'+data.data.addressId+'" onclick="resItme(this)"><dl><dt>'+
						'<span class="tag">'+data.data.tally+'</span>'+
						'<em>'+data.data.name+'</em></dt>'+
						'<dd>'+data.data.phone+'</dd>'+
						'<dd class="unaddress">'+data.data.region+'</dd>'+
						'<dd class="street">'+data.data.street+'</dd>'+
						'<dd class="actions layui-hide">'+
						'<a class="change" id="amend">修改</a>'+
						'<a class="change" siteId="'+data.data.addressId+'" onclick="delres(this)">删除</a>'+
						'</dd></dl></div>');
			$(".section-foot").prepend(dom);
		}else {
			layer.msg(data.msg);
		}
	}
}
/*删除地址*/
function delres(dom){
	$.ajax({
		url:"delUserAddress",
		type:"POST",
		data:{"addressId":$(dom).attr('siteId')},
		dataType:"json",
		success:show
	});
	function show(data){
		if(data.code==0&&data.data==1){
			layer.msg('删除成功');
			$(dom).parents('.address-itme').remove();
		}else {
			layer.msg(data.msg);
		}
	}
}