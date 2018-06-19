$(function(){
	serac(null);
});
//查询全部
function serac(num){
	var statusId=num;
	if(num==null){
		layer.msg('弱弱的提醒,您现在查看的是您的全部订单', {icon: 6});
	}else if(num==1){
		layer.msg('弱弱的提醒,您现在查看的是您的待付款订单', {icon: 6});
	}else if(num==2){
		layer.msg('弱弱的提醒,您现在查看的是您的待发货订单', {icon: 6});
	}else if(num==3){
		layer.msg('弱弱的提醒,您现在查看的是您的待收货订单', {icon: 6});
	}else if(num==4){
		layer.msg('弱弱的提醒,您现在查看的是您的待评价订单', {icon: 6});
	}else{
		layer.msg('弱弱的提醒,您现在查看的是您的退款订单', {icon: 6});
		$.ajax({
			url:'/icei/Getmyorderrefund',
			success:function(data){
				console.log(data);
				$(".orderScroll>div").remove();
				$.each(data,function(v,val){
					console.log(data);
					var $dom=$('<div class="order-item"><div class="item-top"><div class="order-summary">'+
							'<div class="status">'+val.orderStatus.statusDec+'</div><div class="order-xxi">'+
							'<div id="order-time">'+val.creationDate+'</div><span>|</span>'+
							'<div id="order-id">订单号:<span>'+val.orderIndex+'</span></div><span>|</span>'+
							'<div id="payid">'+val.payMent.paymentType+'</div></div></div>'+
							'<div class="order-money">订单金额:<span>'+val.orderPrice+'</span>元</div>'+
							'<div class="order-del" orderId='+val.orderId+' onclick="delOrder(this)">x</div></div>'+
							'<div class="order-info"><img src="http://spoons.test.upcdn.net'+val.orderDetail.brandGoods.goodsImg+'">'+
							'<p id="order-name">'+val.orderDetail.brandGoods.goodsName+'</p><p>类型:<span>'+val.orderDetail.brandGoods.materials+'</span></p></div>'+
							'<input type="hidden" name="orderId" value='+val.orderDetail.orderId+'> '+
							'<input type="hidden" name="brandId" value='+val.orderDetail.brandGoods.brandId+'> '+
							'<input type="hidden" name="statusId" value='+val.orderStatus.statusId+'> '+
							'<input type="hidden" name="goodsId" value='+val.orderDetail.brandGoods.goodsId+'> '+
							'<input type="hidden" name="detailId" value='+val.orderDetail.detailId+'> '+
							'</div>');
					if(val.orderStatus.statusId==8||val.orderStatus.statusId==5){
						 var $button=$('<div class="order-btn">'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="cacelRefundOrder(this)">取消退款</button>'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">退款中</button>'+
								'</div>');
						 $dom.append($button);
					}else if(val.orderStatus.statusId==9){
						 var $button=$('<div class="order-btn">'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">❤</button>'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">退款成功</button>'+
								'</div>');
						 $dom.append($button);
					}else if(val.orderStatus.statusId==10){
						 var $button=$('<div class="order-btn">'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">o(╥﹏╥)o</button>'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">退款失败</button>'+
								'</div>');
						 $dom.append($button);
					}
					$(".orderScroll").append($dom);
				})
			}
		 })
		return;
	}
	$.ajax({
		url:'/icei/Getmyorder',
		data:{statusId:statusId},
		success:function(data){
			console.log(data);
			$(".orderScroll>div").remove();
			$.each(data,function(v,val){
				console.log(data);
				var $dom=$('<div class="order-item"><div class="item-top"><div class="order-summary">'+
					'<div class="status">'+val.orderStatus.statusDec+'</div><div class="order-xxi">'+
					'<div id="order-time">'+val.creationDate+'</div><span>|</span>'+
					'<div id="order-id">订单号:<span>'+val.orderIndex+'</span></div><span>|</span>'+
					'<div id="payid">'+val.payMent.paymentType+'</div></div></div>'+
					'<div class="order-money">订单金额:<span>'+val.orderPrice+'</span>元</div>'+
					'<div class="order-del" orderId='+val.orderId+' onclick="delOrder(this)">x</div></div>'+
					'<div class="order-info"><img src="http://spoons.test.upcdn.net'+val.orderDetail.brandGoods.goodsImg+'">'+
					'<p id="order-name">'+val.orderDetail.brandGoods.goodsName+'</p><p>材料:<span>'+val.orderDetail.brandGoods.materials+'</span></p></div>'+
					'<input type="hidden" name="orderId" value='+val.orderDetail.orderId+'> '+
					'<input type="hidden" name="brandId" value='+val.orderDetail.brandGoods.brandId+'> '+
					'<input type="hidden" name="statusId" value='+val.orderStatus.statusId+'> '+
					'<input type="hidden" name="goodsId" value='+val.orderDetail.brandGoods.goodsId+'> '+
					'<input type="hidden" name="detailId" value='+val.orderDetail.detailId+'> '+
					'</div>');
				if(val.orderStatus.statusId==1){
					var $button=$('<div class="order-btn">'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="toPay(this)">立即支付</button>'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">放弃</button>'+
								'</div>');
					$dom.append($button);

					//待支付倒计时
                    var $span=$('<span>|</span>');
                    var $timeOut=$('<div class="timeOut">剩余23时59分59秒</div>');//订单剩余时间
                    $dom.find('.order-xxi').append($span).append($timeOut);
                    InTimeOut($dom.find('.timeOut'),val.creationDate);//支付倒计时

				}else if(val.orderStatus.statusId==2){
					var $button=$('<div class="order-btn">'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">提醒发货</button>'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="refund(this)">退款</button>'+
							'</div>');
					$dom.append($button);
				}else if(val.orderStatus.statusId==3){
					var $button=$('<div class="order-btn">'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="refund(this)">退款</button>'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="kdcx('+val.expId+',\''+val.expType+'\')">快递查询</button>'+
							'</div>');
					$dom.append($button);
				}else if(val.orderStatus.statusId==4){
					var $button=$('<div class="order-btn">'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="assessOrder(this)">立即评价</button>'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">卖了换钱</button>'+
							'</div>');
					$dom.append($button);
				}else if(val.orderStatus.statusId>=5){
					if(val.orderStatus.statusId==8||val.orderStatus.statusId==5){
						var $button=$('<div class="order-btn">'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="cacelRefundOrder(this)">取消退款</button>'+
							'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">退款中</button>'+
							'</div>');
						$dom.append($button);
					}else if(val.orderStatus.statusId==9){
						 var $button=$('<div class="order-btn">'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="assessOrder(this)">❤</button>'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">退款成功</button>'+
								'</div>');
						 $dom.append($button);
					}else if(val.orderStatus.statusId==10){
						 var $button=$('<div class="order-btn">'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">o(╥﹏╥)o</button>'+
								'<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">退款失败</button>'+
								'</div>');
						 $dom.append($button);
					}
				}
				$(".orderScroll").append($dom);
			})
		}
	})
}
//退款
var orderIds=null
var brandIds=null
var price=null;
var goodsId=null;
var goodsModel=null;
var detailId=null;
function refund(dom){
		layer.open({
			type: 1
			,title: false //不显示标题栏
			,closeBtn: false
			,area: ['550px','430px']
			,shade: 0.5 //遮罩
			,shadeClose: true//是否点击遮罩关闭
			,anim: 2//弹出动画
			,id: 'LAY_layuipro' //设定一个id，防止重复弹出
			,resize: false
			,moveType: 1 //拖拽模式，0或者1
			,content: $('#refund')
			,skin: 'kdcx-class'
			,end:function(){
				 $('form').hide();
			}
		});
		orderIds=$(dom).parent().siblings("input[name='orderId']").val();
		brandIds=$(dom).parent().siblings("input[name='brandId']").val();
		price=$(dom).parent().siblings(".item-top").find(".order-money").find("span").text();
		$("input[name='price']").attr('placeholder',"￥"  +price+".00");
}
function refundPay(){
	//退款添加
	var	formData = new FormData();
	formData.append("orderId",orderIds);
	formData.append("brandId",brandIds);
	formData.append("userId",1);
	formData.append("refundContent",$("input[name='refundContent']").val());
	formData.append("brandContent",null);
	formData.append('file', $('#upload')[0].files[0]);
	console.log($('#upload')[0].files[0]);
	$(this).yunimg(formData,'/icei/orderRefund');
}
/*取消退款*/
function cacelRefundOrder(dom){
	$.ajax({
		url:'/icei/cacelRefundOrder',
		data:{orderIds:$(dom).parent().siblings("input[name='orderId']").val(),userId:1},
		success:function(data){
			if(data==1){
				layer.msg("已取消退款",{
					icon:1,
					time:1500
				});
			}else{
				layer.msg("该订单已经取消退款，请勿重新提交");
			}
		}
	})
}
/*取消退款结束*/
/*订单打分*/
var goodsQuality=5;
var serverAttitude=5;
layui.use('rate', function(){
	var rate = layui.rate;
	//渲染
	var ins1 = rate.render({
	  elem: '#test1'  //绑定元素
	  ,value:3
	  ,choose: function(value){
		  goodsQuality=value;
		  if(value > 4){

		  }
		}
	});
	//渲染
	var ins2 = rate.render({
	  elem: '#test2'  //绑定元素
	  ,value:3
	  ,choose: function(value){
		}
	});
	//渲染
	var ins3 = rate.render({
	  elem: '#test3'  //绑定元素
	  ,value:3
	  ,choose: function(value){
		  serverAttitude=value;
		  if(value > 4){
			  layer.msg('么么哒', {icon: 6});
			$(".layui-word-aux").text("么么哒");
		  }
		}
	});
});
/*订单打分结束*/
/*订单评价*/
function assessOrder(dom){
	layer.open({
		type: 1
		,title: false //不显示标题栏
		,closeBtn: false
		,area: ['550px','507px']
		,shade: 0.5 //遮罩
		,shadeClose: true//是否点击遮罩关闭
		,anim: 2//弹出动画
		,id: 'LAY_layuipro' //设定一个id，防止重复弹出
		,resize: false
		,moveType: 1 //拖拽模式，0或者1
		,content: $('#assess')
		,skin: 'kdcx-class'
		,end:function(){
			 $('form').hide();
		}
		,success: function(layero){
			var name=$("#order-name").text();
			$("#kd-order-img1").attr("src",$(".order-info>img").attr("src"));
			$("#kd-order-img1").attr("alt",name);
			$("#kd-order-name1").text(name);
		}
	});
	goodsId=$(dom).parent().siblings("input[name='goodsId']").val();
	detailId=$(dom).parent().siblings("input[name='detailId']").val();
	goodsModel=$(dom).parent().siblings(".order-info").find("p:eq(1)").find("span").text();
}
function addAssess(){
	//添加评价
	var	formData = new FormData();
	formData.append("detailId",detailId);
	formData.append("goodsId",goodsId);
	formData.append("userId",1);
	formData.append("assessDec",$(".layui-textarea").val());
	formData.append("goodsQuality",goodsQuality);
	formData.append("serverAttitude",serverAttitude);
	formData.append("goodsModel",goodsModel);
	formData.append('file', $('#upload1')[0].files[0]);
	$(this).yunimg(formData,'/icei/addOrderAssess');
}


/*跳转支付*/
function toPay(dom){
	//获取订单号
	var orderIndex=$(dom).parent().siblings(".item-top").find(".order-summary").find(".order-xxi").find("div:eq(1)").find("span").text();
	window.location="/alipay/pay/"+orderIndex;
}

/*
 *支付倒计时
 * creationDate 订单时间
 * dom dom对象
 * */
var InTimeOut=function (dom,creationDate) {
    //动态实现
    var dataTime=new Date(creationDate);//订单时间
    var m=(new Date().getTime()-dataTime.getTime())/1000;//时间差(秒)
    if(m>=86400){
        console.log("订单已超时"+m);
        $(dom).text('订单已超时');
    }else {
        var setInt=setInterval(function(){
            var time24=86400-(new Date().getTime()-dataTime.getTime())/1000;//剩余时间
            if(time24>0){
                $(dom).text('剩余'+formatSeconds(time24));
            }else {
                $(dom).text('订单已超时');
                clearTimeout(setInt);
            }
        },1000);
        /*秒转时分秒*/
        function formatSeconds(value) {
            var theTime = parseInt(value);// 秒
            var theTime1 = 0;// 分
            var theTime2 = 0;// 小时
            if(theTime > 60) {
                theTime1 = parseInt(theTime/60);
                theTime = parseInt(theTime%60);
                if(theTime1 > 60) {
                    theTime2 = parseInt(theTime1/60);
                    theTime1 = parseInt(theTime1%60);
                }
            }
            var result = ""+parseInt(theTime)+"秒";
            if(theTime1 > 0) {
                result = ""+parseInt(theTime1)+"分"+result;
            }
            if(theTime2 > 0) {
                result = ""+parseInt(theTime2)+"时"+result;
            }
            return result;
        }
    }
}
