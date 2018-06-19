function OnProgRess(event) {
    var event = event || window.event;
    console.log("已经上传：" + event.loaded); //已经上传大小情况(已上传大小，上传完毕后就 等于 附件总大小)
    var loaded = Math.floor(100 * (event.loaded / event.total)); //已经上传的百分比 
    layui.element.progress('demo', loaded+'%');//设置页面进度条
};