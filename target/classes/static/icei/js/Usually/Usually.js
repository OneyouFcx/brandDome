$(function () {
    addclass_wave(0);//初始化
    var t = new TimelineMax();
    t.to('#Control_pulley', 0.6, {left:-230,transform: 'scale(0.9)'});
    t.to('.Right_message', 0.8, {left:0,backgroundColor:'rgb(255, 255, 255,0.9)'},0);
    t.stop();
    /*伸缩窗口*/
    $(".block_ul_li_a").click(function(){
       t.play();
       $(".goods_leftFixe").show();
    });
    $(".goods_leftFixe").click(function(){
        t.reverse();
        $(".goods_leftFixe").hide();
    })
})

var num=1;

/*动态追加波浪效果*/
function addclass_wave(number){
    remove_wave();//初始化
	var color=$('.block_ul_li_a').eq(number).attr('data-color');
	console.log(color);
	$('#Control_pulley').animate({'backgroundColor':color});
	$('body').animate({'backgroundColor':color});
    $('.block_ul').children().eq(number).animate({'opacity':1});
    $('.enter_label').eq(number).animate({'opacity':1});
    $(".addclass_b").eq(number).children().show();
    $('.code_mes_outer').eq(number).addClass('code_mes_outer1');
    $('.code_mes_within').eq(number).addClass('code_mes_within1');
}
/*删除波浪效果*/
function remove_wave(){
    $('.block_ul').children().animate({'opacity':0.5});
    $('.enter_label').animate({'opacity':0.3});
    $(".addclass_b").find(" div").hide();
    $('.code_mes_outer').removeClass('code_mes_outer1');
    $('.code_mes_within').removeClass('code_mes_within1');
}
/*加载滚动条*/
$('#Control_pulley').mousewheel(function(event) {
	 if($(".block_ul").is(":animated")||$(".left_ul").is(":animated")){
		return;
	 }
	 else{
		if(parseInt(event.deltaY)>-1){
		  if(num>1){
				num--;
				next_page(1);
		   }
		}else{
			if(num<$('.block_ul').children().length){
				num++;
				up_page(1);
			}
		}
	 }
});
/*像上返回*/
function next_page(un_size){
    var ul_top=parseInt($(".block_ul").css("top"))+(400+100)*un_size ;
	var num_le=parseInt($(".left_ul").css("top"))+40*un_size;
	$(".left_ul").css({"top":num_le});
	$(".block_ul").animate({"top":ul_top});
	addclass_wave(num-1);//波浪
	actionSilide(num);//分类样式
}
/*向下un_size几个，num第几个*/
function  up_page(un_size){
	var ul_top=parseInt($(".block_ul").css("top"))+(-(400+100)*un_size);
	var num_le=parseInt($(".left_ul").css("top"))-40*un_size;
	$(".left_ul").css({"top":num_le});
	$(".block_ul").animate({top:ul_top});
	addclass_wave(num-1);//波浪
	actionSilide(num)//;//分类样式
}
/*滑动时同步分类*/
function actionSilide(numbers){
	$(".click_synchronization").removeClass("nei_style nei_style1");
	$(".click_synchronization").addClass("nei_style2");
	if(numbers>1){
		$(".click_synchronization").eq(numbers-2).addClass("nei_style1");
	}
	$(".click_synchronization").eq(numbers-1).addClass("nei_style");
	$(".click_synchronization").eq(numbers-1).removeClass("nei_style2");
	$(".click_synchronization").eq(numbers).addClass("nei_style1");
}
/*单机分类时同步分类信息*/
$(".click_synchronization").click(function(){
	var i=num;
	var index=parseInt($(this).attr('i'));//获取i
	console.log(index)
	/*单机滑动分类文字*/
	if(index>num){
		num=index;
		up_page(index-i);
	}else{
        num=index;
		next_page(i-index);
	}
})