// JavaScript Document
(function($){
    //拖拽插件,参数:id或object
    $.Move = function(_this,dom){
        if(typeof(_this)=='object'){
            _this=_this;
        }else{
            _this=$("#"+_this);
        }
        if(!_this){return false;}
        _this.css({'position':'absolute'}).hover(function(){
			$(this).css("cursor","move");
		},function(){
			$(this).css("cursor","default");
		});
        _this.mousedown(function(e){//e鼠标事件
            var offset = $(this).offset();
            var x = e.pageX - offset.left;//鼠标坐标
            var y = e.pageY - offset.top;//鼠标坐标
			var stop=$(dom).position().top;//子元素
			var sleft=$(dom).position().left;//子元素
            $(dom).css({'opacity':'0.8'});
            $(document).bind("mousemove",function(ev){
				//绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件
                _this.bind('selectstart',function(){return false;});
                var _x = ev.pageX - x-offset.left;//获得X轴方向移动的值
                var _y = ev.pageY - y-offset.top;//获得Y轴方向移动的值
                $(dom).css({'left':sleft+_x+"px",'top':stop+_y+"px"});
            });
        });
        $(document).mouseup(function(){
            $(this).unbind("mousemove");
            $(dom).css({'opacity':''});
        });
    };
})(jQuery);