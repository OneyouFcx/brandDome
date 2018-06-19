// JavaScript Document
function Bar(obj) {
	this.bar_obj = $(obj); // 进度条的容器
	this.drag_obj = this.bar_obj.find('.drag'); // 可以拖动的按钮
	this.precent = this.bar_obj.find('.percent'); // 显示百分比的容器
	this.rate_bar = this.bar_obj.find('.rate-bar'); // 有颜色部分的百分比
}
/* *
 * 绘制进度条
 * */
Bar.prototype._progressBar = function (num) {
		num = parseFloat(num);
		num = num > 1 ? 1 : num;
		num = num < 0 || !num ? 0 : num;
		var left = this.bar_obj.width() * num + 'px'; // 进度条按钮距左侧的距离  = 进度条的长度 * 百分比
		this.precent.html(parseInt(num * 100 - 50)); // 显示百分比---------
		this.rate_bar.css('width', left); // 有颜色部分的长度
		this.drag_obj.css('left', left); // 按钮的位置
	};
/* *
 * 设置进度条可拖拽
 * */
Bar.prototype._dragBar = function (opts) {
	var _this = this;
	_this.drag_obj.on('mousedown', function (e) {
		var e = e || window.event;
		document.onmousemove = function (e) {
			if (opts != false) {
				var pro_bar = e.clientX - _this.bar_obj[0].offsetLeft; // 获取按钮距进度条最左边的距离
				$(this).css('left', pro_bar);
				var num = (pro_bar / _this.bar_obj.width()).toFixed(2); // 计算百分比
				_this._progressBar(num); // 根据百分比绘制进度条
				//开始啦------------------------------------------------------------------------------------
				var bfb=((num*100+50)/100-1)*3+1;
				$("#dz-back img").css("transform","translate(0px, 0px) scale("+bfb+","+bfb+") rotate(0deg)");
			}
		};
		document.onmouseup = new Function('this.onmousemove=null');
	});
};
/* *
 * 封装成jQuery组件
 * */
(function ($) {
	$.fn.extend({
		dragBar: function (num, opts) {
			var bar = new Bar(this);
			bar._progressBar(num);
			bar._dragBar(opts);
			return this;
		}
	});
})(jQuery);
/* *
 * 调用方法
 * $(ele).dragBar(num, opts);
 * num: 进度条的百分比，传入小数
 * opts: 可选，默认是true(可以拖拽)。false: 不可拖拽
 * */
$('.pro-bar').dragBar(0.5); //可拖动
//恢复原始
function recoverSize(){
	$('.pro-bar').dragBar(0.5); //可拖动
	$("#dz-back img").css("transform","translate(0px, 0px) scale(1,1) rotate(0deg)");
	$("#dz-back").css({"top":0,"left":0});
}
/*滚动大小*/
function mousewheel(){
	var daltaY=0;
	$('.dz-box').mousewheel(function(event) {
		var sun=parseInt($(".percent").text())/100+0.5;
	    daltaY=sun+(event.deltaY/100)*2;
	    $('.pro-bar').dragBar(daltaY); //可拖动
	    var bfb=((daltaY*100+50)/100-1)*3+1;
		$("#dz-back img").css("transform","translate(0px, 0px) scale("+bfb+","+bfb+") rotate(0deg)");
	});
}