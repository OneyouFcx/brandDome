// JavaScript Document
$(function(){
	$(".clearfix").click(function(){
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
		$(".toolbar-title").text($(this).find("nav-title").text()+"模板");
	});
});