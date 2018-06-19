/*
 * 这里是图库的接口
 * 调用UploadFileFn()
 */
//ajax图片上传
function topimg(url,oFile){
	var formData = new FormData(); //创建FormData对象
	xhr = $.ajaxSettings.xhr(); //创建并返回XMLHttpRequest对象的回调函数(jQuery中$.ajax中的方法)
	formData.append("UploadForm[image]", oFile); //将上传name属性名(注意：一定要和 file元素中的name名相同)，和file元素追加到FormData对象中去
	$.ajax({
        type: "POST",
        url: url, // 后端服务器上传地址
        data: formData, // formData数据
        cache: false, // 是否缓存
        async: true, // 是否异步执行
        processData: false, // 是否处理发送的数据  (必须false才会避开jQuery对 formdata 的默认处理)
        contentType: false, // 是否设置Content-Type请求头
        xhr: function() {
            if (OnProgRess && xhr.upload) {
                xhr.upload.addEventListener("progress", OnProgRess, false);
                return xhr;
            }
        },
        dataType:"json",
        success: function(res) {
        	if(res.code == 0){
        		biaodan(res.data.title,10000);
          	}else{
          		return layer.msg('图片上传失败');
          	}
        },
        error: function(returndata) {
            layer.msg('服务器错误');
        }
    });
};
//表单上传
function biaodan(url,id){
	var content="手机壳定制专用图片";
 	var title="记录最美的自己,时间停留";
 	$.ajax({
		url:siteUrl+"zhiqu/UserPicServlet",
		type:"POST",
		data:{"num":3,"picUrl":url,"userId":id,"title":title,"content":content},
		async: false, // 是否异步执行
		dataType:"json",
		success:show
	});
	function show(data){
		if(data.code==0){
			var topimgurl=data.UserPic.userPicSite;//返回图片地址
			topdom(topimgurl);//上传
			layer.msg('好了');
		}else{
			layer.msg('可能遇到点问题');
		}
	}
}