var tfDrawer=false;
var tdrawer = new TimelineMax();
tdrawer.to('.right-drawer',0.5,{right:0,onComplete: function () { }});
tdrawer.to('.user-login',0.5,{left:200,top:10},0);
tdrawer.stop();
//抽屉切换
var drawer=function(index){
    tdrawer.play();
    $('.drawer_menu-btn').eq(0).click();
    setTimeout(function(){
        $('.drawer_section').eq(index).click();
    },500);
    tfDrawer=true;
}

$(document).ready(function () {
    var $demo = $('.right-drawer');
    var numOfSections = $('.drawer_section').length;
    $(document).on('click', '.drawer_menu-btn', function () {
        $demo.addClass('menu-active');
    });
    $(document).on('click', '.drawer_close-menu', function () {
        $demo.removeClass('menu-active');
    });
    $(document).on('click', '.right-drawer.menu-active .drawer_section', function () {
        var $section = $(this);
        var index = +$section.data('section');
        $('.drawer_section.active').removeClass('active');
        $('.drawer_section.inactive').removeClass('inactive');
        $section.addClass('active');
        $demo.removeClass('menu-active');
        for (var i = index + 1; i <= numOfSections; i++) {
            if (window.CP.shouldStopExecution(1)) {
                break;
            }
            $('.drawer_section[data-section=' + i + ']').addClass('inactive');
        }
        window.CP.exitedLoop(1);
    });
    $('.switch').click(function () {
        if(tfDrawer){
            tdrawer.reverse();
            tfDrawer=false;
        }else {
            drawer(3);
        }
    })
    $('.switch').click();
});