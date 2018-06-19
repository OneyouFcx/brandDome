$(function(){
	 //加载关注商品
	 $('.drawer_section').eq(0).click(function(){
		 loadGoods();
	 });
	//加载关注商品END
	//加载关注店铺
	 $('.drawer_section').eq(1).click(function(){
		 loadBrand()
	 });
	//加载关注店铺END
	//加载收货地址
	 $('.drawer_section').eq(3).click(function(){
		 loadAddress();
	 });
	//加载收货地址END
})//初始化函数结束

//加载收货地址
function loadAddress(){
	$.ajax({
		url:'/icei/getUserAddress',
		data:{userId:1},
		success:function(l){
			$('.drawer_section').eq(3).find(".address-itme").remove();
			$.each(l.data,function(v,val){
				var div="<div class='address-itme'>"+
							"<input type='hidden' name='field＿name' value="+val.addressId+">"+
							"<div class='address-info'>"+
			                    "<p>"+ 
			                        "<span class='address-name'>"+val.name+"</span>"+
			                        "<span class='address-phone'>"+val.phone+"</span>"+
			                    "</p>"+
			                    "<p class='address-region'>"+val.region+"</p>"+
			                    "<p class='address-details'>"+val.street+"</p>"+
		                    "</div>"+
			                "<div class='address-handle'>"+
			                    "<div class='address-tally'>"+val.tally+"</div>"+
			                    "<div class='tally-btn'><i class='layui-icon'>&#xe642;</i></div>"+
			                    "<div class='tally-btn detele' onclick='detele(this)'><i class='layui-icon'>&#xe640;</i></div>"+
			                "</div>"+
			               "</div>";
				 $('.drawer_section').eq(3).append(div);
			})
		}
	}) 
}//加载收货地址结束
//加载关注商品
function loadGoods(){
	$.ajax({
		url:'/icei/getUserLikeGoods',
		data:{userId:1},
		success:function(data){
			$(".goods-items>div").remove();
			console.log(data);
			$.each(data,function(v,val){
				var div="<div class='goods-item'>"+
								"<input type='hidden' name='field＿name' value='"+val.goodsId+"'>"+
			                    "<div class='goods-img'><img src='http://spoons.test.upcdn.net"+val.goodsImg+"'></div>"+
			                    "<div class='goods-info'>"+
		                        "<p class='goods-name'>"+val.goodsName+"</p>"+
		                        "<p class='goods-price'>￥"+val.goodsPrice+"</p>"+
		                    "</div>"+
		                    "<span onclick='cancelGoods(this)'>×</span>"+
		               "</div>";
				$(".goods-items").append(div);
			})
		}
	}) 
}
//加载关注商品结束
//加载关注店铺
function loadBrand(){
	$.ajax({
		url:'/icei/getUserLikeBrand',
		data:{userId:1},
		success:function(data){
			$(".layui-show>.drawer-store").remove();
			$.each(data,function(v,val){
				var div=" <div class='drawer-store'>"+
							"<input type='hidden' name='field＿name' value='"+val.brandId+"'>"+
                            "<div class='drawer-img'><img src='http://spoons.test.upcdn.net"+val.iconPath+"'></div>"+
                            "<div class='drawer-name'>"+
                                "<h2>"+val.brandName+"<span>企业店铺</span></h2>"+
                            "</div>"+
                            "<div class='drawer-tab' onclick='collect(this)'>"+
                                "<i class='layui-icon' style='font-size:18px; color:#000;'>&#xe65f;</i>"+
                            "</div>"+
                            /*收藏与屏蔽*/
                           "<div class='collect'>"+
                               "<span>屏蔽动态</span>"+
                               "<span onclick='cancel(this)' id='cancel'>取消关注</span>"+
                               "<span>特别关注</span>"+
                           "</div>"+
                        "</div>";
				$(".layui-show").append(div);
			})
		}
	}) 
}
//加载关注店铺结束
//删除收货地址
function detele(dom){
		var addressId=$(dom).parent().siblings("input").val();
		$.ajax({
			url:'/icei/delUserAddress',
			data:{addressId:addressId},
			type:'Post',
			success:function(data){
				if(data.code==0){
					  layer.msg('删除成功', {icon: 1});
					  loadAddress();
				}else{
					 layer.tips('删不掉呀！', "dom",{
		                    tips: 1,
		                    time:800,
		                });
				}
			}
		})
	}
var num=1
//点击显示收藏与隐藏
function collect(dom){
	$('.drawer_section').eq(1).unbind();
	if(num%2==0){
		$(dom).parent().animate({"margin-left":"0px"});
	}else{
		$(dom).parent().animate({"margin-left":"-215px"});
	}
	num++;
}
//点击显示收藏与隐藏END
//取消收藏店铺
function cancel(dom){
	var brandId=$(dom).parent().siblings("input").val();//店铺ID
	$.ajax({
		url:'/icei/cancelLikeBrand',
		data:{brandId:brandId,userId:1},
		type:'Put',
		success:function(data){
			if(data==1){
				  layer.msg('取消关注', {icon: 1});
				  loadBrand();
			}else{
				 layer.tips('删不掉呀！', "dom",{
	                    tips: 1,
	                    time:800,
	             });
			}
		}
	})
}
//取消收藏商品
function cancelGoods(dom){
	var goodsId=$(dom).siblings("input").val();//店铺ID
	$.ajax({
		url:'/icei/cancelLikeGoods',
		data:{goodsId:goodsId,userId:1},
		type:'Put',
		success:function(data){
			if(data==1){
				  layer.msg('取消关注', {icon: 1});
				  loadGoods();
			}else{
				 layer.tips('删不掉呀！', "dom",{
	                    tips: 1,
	                    time:800,
	             });
			}
		}
	})
}