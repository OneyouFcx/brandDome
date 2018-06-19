// JavaScript Document
 /*生成canvas图形*/
function canvasV(content) {
	html2canvas(content, {
		onrendered: function(canvas) {
			canvas.id = "thecanvas";
			$("#canvas").empty();
			$("#canvas").append($(canvas));
		}
	});
}
/**
 * canvas转base64
 */
function boacun(){
	var oCanvas = document.getElementById("thecanvas");//获取生成的canvas
	var d=oCanvas.toDataURL("image/png").replace("image/png", "image/octet-stream");
	return d;
}
/**
 * 将以base64的图片url数据转换为Blob
 * @param urlData
 * 用url方式表示的base64图片数据
 */
function convertBase64UrlToBlob(urlData){
    var bytes=window.atob(urlData.split(',')[1]);//去掉url的头，并转换为byte
    //处理异常,将ascii码小于0的转换为大于0
    var ab=new ArrayBuffer(bytes.length);
    var ia=new Uint8Array(ab);
    for (var i=0;i<bytes.length;i++){
        ia[i]=bytes.charCodeAt(i);
    }
    return new Blob([ab],{type:'image/png'});
}
/**
 * img转base64
 * img为路径
 */
function getBase64(img){//传入图片路径，返回base64
	var image = new Image();
	image.crossOrigin = '';
	image.src = img;
	var deferred=$.Deferred();
	if(img){
		image.onload =function (){
			deferred.resolve(getBase64Image(image));//将base64传给done上传处理
		};
		return deferred.promise();//问题要让onload完成后再return sessionStorage['imgTest']
	}
	function getBase64Image(img) {//width、height调用时传入具体像素值，控制大小 ,不传则默认图像大小
		var canvas = document.createElement("canvas");//创建canvas
		canvas.width = img.width;
		canvas.height = img.height;
		var ctx = canvas.getContext("2d");
		ctx.drawImage(img, 0, 0, canvas.width, canvas.height);
		var dataURL = canvas.toDataURL();
		return dataURL;
	}
}