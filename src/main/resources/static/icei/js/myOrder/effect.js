$(document).ready(function() {
    var tf=true;
    var t = new TimelineMax();
    t.to('.people-header-right',0.2,{width:0},0);
    t.to($('.people-header-left'),0.4,{width:300,borderRadius:10},0);
    t.to($('.order-items'),0.4,{top:-(356+20),height:466+20+356,},0.8);
    t.stop();
    $(".orderScroll").scroll(function(event){
        if($('.orderScroll').scrollTop()>10&&tf){
            tf=false;
            t.play();
        }
        if($('.orderScroll').scrollTop()<10&&!tf){
            tf=true;
            t.reverse();
        }
    });
})