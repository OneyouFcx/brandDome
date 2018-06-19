/*
 * 基于layui务必引用 layui官方包
 * FileChangeFn  文件选择回调 dome当前对象 mado文件格式
 * yunimg  文件上传 formData对象 url服务器地址
 */
(function($) {
	$.fn.extend({
		/*文件选择回调 dome当前对象 mado文件格式*/
		FileChangeFn: function (dome,mado) {
			//文件选择完毕时
			var dom = '',
		        ofile = $(dome).get(0).files[0],
		        otype = ofile.type || '获取失败', //文件类型
		        osize = ofile.size / 1054000, //文件大小
		        ourl = window.URL.createObjectURL(ofile); //文件临时地址
			//当前对象的父级里的元素追加
			if(mado==0){
				 if ('image/jpeg' == otype || 'image/png' == otype || 'image/gif' == otype) {
			        osize.toFixed(2)+"MB)";//文件大小
			        $(dome).parent().children("img").attr("src",ourl);
				 }else {
			    	layer.msg('请选择img格式文件');
				 }
			} else if (mado==1){
				if ('video/mp4' == otype || 'video/avi' == otype || 'video/x-msvideo' == otype) {
					$(dome).parent().children("video").attr("src",ourl);
			    }else {
			    	layer.msg('请选择视频格式文件');
			    }
			}
		},

		/*文件上传 formData对象 url服务器地址*/
		yunimg: function (formData,url) {
			//侦查附件上传情况,大概0.05-0.1秒执行一次
			function OnProgRess(event) {
			    var event = event || window.event;
			    var loaded = Math.floor(100 * (event.loaded / event.total));//已经上传的百分比
                console.log("已经上传：" + event.loaded+"百分比："+loaded+"%");
			    layer.msg('加载中'+loaded, {
			    	icon: 16
			    	,shade: 0.01
		    	});
			    if(loaded==100){
                    layer.msg('请稍等,服务器处理中...',{
                    	icon: 6	,
                        time: 99999999999,//类似不关闭
                    });
                }
			};
			//ajax图片上传
			function UploadFileFn(){
				var xhr = $.ajaxSettings.xhr();
				$.ajax({
			        type: "POST",
			        url: url,
			        data: formData,//formData数据
			        cache: false,//缓存
			        async: true,//异步执行
			        processData: false,//处理发送的数据(必须false避开jQuery对formdata的默认处理)
			        contentType: false,//设置Content-Type请求头
			        xhr: function() {
			            if (OnProgRess && xhr.upload) {
			                xhr.upload.addEventListener("progress", OnProgRess, false);
			                return xhr;
			            }
			        },
			        dataType:"json",
			        success: function(res) {
			        	if(res.code==0&&res.data==1){
			        		layer.msg("提交成功", {
								icon: 6,
								time:1500,
								end:function(){
									window.location.reload();//刷新当前页面
								}
							});
			        	}else if (res.code==0&&res.data==null) {
			        		layer.msg("请重试", {
								icon: 5,
								time:1500,
								end:function(){
									window.location.reload();//刷新当前页面
								}
							});
						}else{
							layer.msg(res.msg, {
								icon: 5,
								time:1500,
								end:function(){
								}
							});
						}
			        },
			        error: function(returndata) {
			            layer.msg('服务器错误', function(){});
			        }
			    });
			}UploadFileFn();
		}
	});
 })(jQuery);