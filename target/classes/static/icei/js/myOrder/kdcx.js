function kuaidi(id,type){
	layer.load(1);
	$.ajax({
		url:"/kdcx/ems",
		type:"Get",
		data:{"num":id,"type":type},
		dataType:"json",
		success:show
	});
	function show(data){
		console.log(data);
		var msg=data["msg"],//提示信息
			status=data["status"],//状态
			deliverystatus=data["result"].deliverystatus;//投递状态
		//状态判断
		if(status==0){
			$("#order-is").text("状态  正常");
			verystatus();
		}else if(status==201){
			$("#order-is").text("状态 快递单号为空");
		}else{
			$("#order-is").text("状态  快递服务异常请联系客服");
		}
		function verystatus(){
			$("#order-kdno").text(data["result"].expName+":"+data["result"].number);//快递
			//投递状态
			if(deliverystatus==1){
				$(".kd-step-item").siblings().removeClass("kd-step-item-current");
				$(".kd-step-item").eq(deliverystatus).addClass("kd-step-item-current");
			}else if(deliverystatus==2){
				$(".kd-step-item").siblings().removeClass("kd-step-item-current");
				$(".kd-step-item").eq(deliverystatus).addClass("kd-step-item-current");
			}else if(deliverystatus==3){
				$(".kd-step-item").siblings().removeClass("kd-step-item-current");
				$(".kd-step-item").eq(deliverystatus).addClass("kd-step-item-current");
			}else if(deliverystatus==4){
				$(".kd-step-item").siblings().removeClass("kd-step-item-current");
				$(".kd-step-item").eq(deliverystatus).addClass("kd-step-item-current");
			}
			list();
		}
		/*状态详细*/
		function list(){
			$(".kd-timeline-content").empty();
			$.each(data["result"].list,function(k1,v1){
				var dom=$('<li class="kd-timeline-item"><em class="kd-timeline-icon"></em>'+
							'<p class="">'+v1.status+'</p>'+
							'<p style="margin-top: 10px;">'+v1.time+'</p></li>');
				$(".kd-timeline-content").append(dom);
			});
			var dom=$('<li class="kd-timeline-item"><em class="kd-timeline-icon"></em>'+
					'<p class="">小哥正在备货中</p>'+
					'<p style="margin-top: 10px;">...</p></li>');
			$(".kd-timeline-content").append(dom);
		}
		layer.closeAll('loading');
	}
};