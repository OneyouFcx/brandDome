//广告轮播
var swiperMain=function(){
	var swiper1 = new Swiper('.c-hero-img',{
		//loop : true,
		effect : 'fade',
		allowTouchMove: false,
		fadeEffect: {crossFade: false,},
		on:{
			init: function(){
				swiperAnimateCache(this);
				swiperAnimate(this);
			},
			slideChangeTransitionEnd: function(){ 
				swiperAnimate(this);
			}
		},
	})
	var swiper2 = new Swiper('.c-hero_text', {
		//loop : true,
		effect : 'fade',
		allowTouchMove: false,
		fadeEffect: {crossFade: false,},
		controller: {control: swiper1},
		on:{
			init: function(){
				swiperAnimateCache(this);
				swiperAnimate(this);
			}, 
			slideChangeTransitionEnd: function(){ 
				swiperAnimate(this);
			}
		},
	})
	swiper1.controller.control = swiper2;
	swiper2.controller.control = swiper1;
	var swiper3 = new Swiper('.c-hero-back',{
		//loop : true,
		effect : 'fade',
		autoplay: {
			delay: 10000,
			disableOnInteraction: false,
		},
		fadeEffect: {crossFade: false,},
		controller: {control: swiper2},
		on:{
			init: function(){
				backNum(0);
			},
			slideChangeTransitionEnd:function(){
				backNum(this.activeIndex);
			},
		},
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev'
		},
	})
	function backNum(num){
		var t = new TimelineMax();
		var $c_back=$(".c-back").eq(num);
		t.to(".c-hero-back", 0.5, { backgroundColor:$c_back.attr('data-color')});
		//$('.c-hero-back').css('background-color',$c_back.attr('data-color'));
		$('.back-video').trigger('pause');
		$('.back-video').eq(num).trigger('play');
		if($c_back.children().length>0){
			$('.c-hero-title').eq(num).children().css({'color':'#fff','text-shadow':' 0 0 3px rgba(0,0,0,0.66)'});
			$('.c-hero-referral').eq(num).children().css({'color':'#fff','text-shadow':' 0 0 3px rgba(0,0,0,0.66)'});
		}
	}
}
