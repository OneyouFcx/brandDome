$(document).ready(function() {
	//滚动特效
	new WOW().init();
	//滚动视觉差
	var rellax = new Rellax('.rellax');
	//跟随鼠标移动
	$.each($('.saying'),function(k,v){
		var saying=new Parallax(v, {
			relativeInput: true,
			invertX:false,invertY:false,
			frictionX:0.5,frictionY:0
		});
	})
	$.each($('.c-hero-title'),function(k,v){
		var c_hero_title=new Parallax(v, {
			relativeInput: false,
			frictionX:0.4,frictionY:0.4
		});
	});
})
var ParallaxImg=function () {
    $.each($('.c-hero-imgs'),function(k,v){
        var c_hero_img=new Parallax(v, {
            relativeInput: true,
            invertX:false,
        });
    })
}