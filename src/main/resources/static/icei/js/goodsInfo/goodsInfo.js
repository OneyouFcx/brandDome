
/**
 * 轮播
 */
new WOW().init();
$(function () {
    var swiper1 = new Swiper('.content_rotate',{
        //loop : true,
        autoplay: {
            delay: 10000,
            disableOnInteraction: false,
        },
        fadeEffect: {crossFade: false,},
        on:{
            init: function(){
                backNum(0);
            },
            slideChangeTransitionEnd:function(){
                backNum(this.activeIndex);
            },
        },
        navigation: {
            nextEl: '.right_button',
            prevEl: '.left_button',
        },
    })
})
$(function () {
    //评价显示
    var evaTf=true;
    var tEvaluate = new TimelineMax();
    tEvaluate.to('.evaluate', 0.8, {top:0});
    tEvaluate.to('.product-specification', 0.7, {transform: 'scale(0.9)',top:-100},0);
    tEvaluate.stop();
    $('.icon-shouye3').click(function () {
        if(evaTf){
            evaTf=false;
            tEvaluate.play();
        }else {
            evaTf=true;
            tEvaluate.reverse();
        }
    });
    $('.evaluate-rut').click(function () {
        tEvaluate.reverse();
    })
})
var backNum=function(num){
    var t1 = new TimelineMax();
    var t = new TimelineMax();
    var $box=$('.content_rotate .swiper-slide>div');
    var $img=$('.content_rotate .swiper-slide>.imgs>div');
    t1.to( $box, 0, {transform: 'scale(0.8)'});
    t1.to($img, 0, {transform: 'scale(1.4)'},0);
    t.to($box.eq(num), 0.8, {transform: 'scale(1)'});
    t.to($img.eq(num), 1, {transform: 'scale(1)'},0);
    $('.goods-img').children("video").trigger('pause');
    $('.goods-img').eq(num).children("video").trigger('play');
}

//定制选择
$(".buy").click(function(){
    $(".buy-diy").css("display","block");
})
      


      


