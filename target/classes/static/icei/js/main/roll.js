$(document).ready(function() {
	var pagesNum=0;
	$('html,body').mousewheel(function(event) {
		if($("html").is(":animated") || $("body").is(":animated")) {
			console.log("html正在移动");
			return;
		}
		if(event.deltaY <= 0) {
			indicator_down();
		} else {
			indicator_up();
		}
	});
	function indicator_down(){
		if(pagesNum==$('.pages').length){
			return;
		}
		$("html,body").animate({
			scrollTop: $($('.pages').get(pagesNum+1)).position().top
		},1200,function(){
		});
		pagesNum++;
	}
	function indicator_up(){
		if(pagesNum==0){
			return;
		}
		$("html,body").animate({
			scrollTop: $($('.pages').get(pagesNum-1)).position().top
		},1200,function(){
		});
		pagesNum--;
	}
	//$("body").niceScroll();
});