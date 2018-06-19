$(function(){
	/*会员卡展示*/
	$(".dk-card").click(function(){
		var isnum=$(this).attr("isnum");
		if(isnum==1){
			$(".member-card").css("right","40px");
			$(this).css("display","none").text("隐藏会员卡").attr("isnum","2");
		}else{
			$(".member-card").css("right","-395px");
			$(this).css("display","block").text("显示会员卡").attr("isnum","1");
		}
	});
});

//
//
// /*获取订单信息*/
// function getOrder(){
// 	$.ajax({
// 		url:"DiyOrderServlet",
// 		type:"POST",
// 		data:{"num":2,"userId":10000},
// 		dataType:"json",
// 		success:show
// 	});
// 	function show(data){
// 		$.each(data.orders,function(k,v){
// 			var status=v.status,
// 				paymentId=v.paymentId,
// 				payStatus=v.payStatus;//支付状态
// 			var statusName="";
//
// 			if(status==1){statusName="已下单";
// 			}else if (status==2) {statusName="已支付";
// 			}else if (status==3) {statusName="配货中";
// 			}else if (status==4) {statusName="发货中";
// 			}else if (status==5) {statusName="已完成";
// 			}else if (status==0) {statusName="已取消";}
//
// 			var paymentName="";
// 			if(payStatus==1||payStatus==2){
// 				if(paymentId==0){
// 					paymentName="未支付";
// 				}else if (paymentId==1) {
// 					paymentName="支付宝支付";
// 				}else if (paymentId==2) {
// 					paymentName="余额支付";
// 				}
// 			}else if (payStatus==0) {
// 				paymentName="退款审核中";
// 			}else if (payStatus==-1) {
// 				paymentName="已退款";
// 			}
// 			var dom=$('<div class="order-item"><div class="item-top"><div class="order-summary">'+
// 							'<div class="status">'+statusName+'</div><div class="order-xxi">'+
// 							'<div id="order-time">'+v.createtime+'</div><span>|</span>'+
// 							'<div id="order-id">订单号:<span>'+v.orderId+'</span></div><span>|</span>'+
// 							'<div id="payid">'+paymentName+'</div></div></div>'+
//
// 							'<div class="order-money">订单金额:<span>'+v.price+'</span>元</div>'+
// 							'<div class="order-del" orderId="'+v.orderId+'" onclick="delOrder(this)">x</div></div>'+
// 							'<div class="order-info"><img src="'+v.diySel.selfdomImg+'">'+
// 							'<p id="order-name">'+v.orderName+'</p><p>类型:<span>'+typeId+'</span></p></div>'+
// 							'<div class="order-btn">'+
// 							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">订单分享</button>'+
// 							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="kdcx('+v.expId+',\'auto\')">快递查询</button>'+
// 							'</div></div>');
// 			if(paymentId==0){
// 				var btn=$('<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="wzfPay(\''+v.orderId+'\')">立即支付</button>');
// 				var $span=$('<span>|</span>');
// 				var $timeOut=$('<div class="timeOut">'+'</div>');//订单剩余时间
// 				$(dom).find('.order-xxi').append($span).append($timeOut);
// 				$(dom).find('.order-btn').append(btn);
// 			}
// 			if((status==2||status==3||status==4||status==5)&&payStatus!=0){
// 				var btn=$('<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="wzfTui(\''+v.orderId+'\',this)" id="wzfTui">退款</button>');
// 				$(dom).find('.order-btn').append(btn);
// 			}
// 			if(payStatus==0){//退款审核中
// 				var btn=$('<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="wzfQuX(\''+v.orderId+'\',this)" id="wzfTui">取消退款</button>');
// 				$(dom).find('.order-btn').append(btn);
// 			}
// 			$(".order-items").prepend(dom);
// 		});
// 	}
// }
//
//
// /*订单支付*/
// function wzfPay(orderId){
// 	window.location.href="AliplayServlet?num=2&orderId="+orderId;
// }
// /*订单退款*/
// function wzfTui(orderId,dom,number){
// 	layer.load(1);
// 	$.ajax({
// 		url:"AliplayServlet",
// 		type:"POST",
// 		data:{"num":3,"orderId":orderId},
// 		dataType:"json",
// 		success:show
// 	});
// 	function show(data){
// 		layer.closeAll('loading');
// 		console.log(data);
// 		layer.msg(data.msg);
// 		if(data.code==1){//退款成功
// 			var order=$(dom).parents(".order-item");
// 			order.find("#wzfTui").remove();
// 			if(data.number==1){
// 				order.find("#payid").text("已退款");
// 				order.find(".status").text("已取消");
// 			}else if(data.number==2){
// 				order.find("#payid").text("退款审核中");
// 				var btn=$('<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="wzfQuX(\''+orderId+'\',this)" id="wzfTui">取消退款</button>');
// 				order.find('.order-btn').append(btn);
// 			}
// 		}
// 	}
// }
//
//
// /*取消退款*/
// function wzfQuX(orderId,dom){
// 	layer.load(1);
// 	$.ajax({
// 		url:"AliplayAdServlet",
// 		type:"POST",
// 		data:{"num":4,"orderId":orderId},
// 		dataType:"json",
// 		success:show
// 	});
// 	function show(data){
// 		layer.closeAll('loading');
// 		layer.msg(data.msg);
// 		if(data.code==1){
// 			var order=$(dom).parents(".order-item");
// 			order.find("#wzfTui").remove();
// 			var paymentId=data.payid,paymentName="";
// 			if(paymentId==0){paymentName="未支付";
// 			}else if (paymentId==1) {paymentName="支付宝支付";
// 			}else if (paymentId==2) {paymentName="余额支付";}
// 			order.find("#payid").text(paymentName);
// 			var btn=$('<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="wzfTui(\''+orderId+'\',this)" id="wzfTui">退款</button>');
// 			order.find('.order-btn').append(btn);
// 		}
// 	}
// }
//
//
//
// /*订单删除*/
// function delOrder(dom){
// 	var orderId=$(dom).attr("orderId");
// 	$.ajax({
// 		url:"DiyOrderServlet",
// 		type:"POST",
// 		data:{"num":3,"userId":10000,"orderId":orderId},
// 		dataType:"json",
// 		success:show
// 	});
// 	function show(data){
// 		if(data.msg!=-1){
// 			$(dom).parents(".order-item").css("height","0px");
// 			layer.msg("删除成功",function(){
// 				$(dom).parents(".order-item").remove();
// 			});
// 		}else{
// 			layer.msg("订单未完成无法删除");
// 		}
// 	}
// }
// /*查询快递*/
// function kdcx(expId,expType){
// 	if(expId!=undefined){
// 		layer.open({
// 		  	type: 1
// 		  	,title: false //不显示标题栏
// 		  	,closeBtn: false
// 		  	,area: ['550px','430px']
// 		  	,shade: 0.5 //遮罩
// 		  	,shadeClose: true//是否点击遮罩关闭
// 		  	,anim: 2//弹出动画
// 		  	,id: 'LAY_layuipro' //设定一个id，防止重复弹出
// 		  	,resize: false
// 		  	,moveType: 1 //拖拽模式，0或者1
// 		  	,content: $('#kdcx')
// 		  	,skin: 'kdcx-class'
// 		  	,success: function(layero){
// 		  		var name=$("#order-name").text();
// 		  		$("#kd-order-img").attr("src",$(".order-info>img").attr("src"));
// 				$("#kd-order-img").attr("alt",name);
// 				$("#kd-order-name").text(name);
// 		  		kuaidi(expId,expType);//快递查询
// 			}
// 			,end:function(){
// 				$("#kdcx").css("display","none");
// 			}
// 		});
// 	}else {
// 		layer.msg("该订单还未发货，请耐心等待");
// 	}
// }