(function($) {
	$.fn.extend({
		FileChangeFn: function (dome) {
			//文件选择完毕时
			var dom = '',
		        ofile = $(dome).get(0).files[0],
		        otype = ofile.type || '获取失败', //文件类型
		        osize = ofile.size / 1054000, //文件大小
		        ourl = window.URL.createObjectURL(ofile); //文件临时地址
		    if ('image/jpeg' == otype || 'image/png' == otype || 'image/gif' == otype) {
		        osize.toFixed(2)+"MB)";//文件大小
		        $(dome).parent().children("img").attr("src",ourl);
		    }else {
		    	layer.msg('请选择img格式文件');
			}
		},
		yunimg: function (formData) {
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
			        url: "/icei/addBrandAudit",
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
			        	if(res.code == 0){
			        		layer.alert('提交成功成功情耐心等待,您的回执编码为:('+res.data+'),请牢记左上角为查询！', {icon: 6});
			          	}else{
			          		layer.msg(res.msg, {icon: 5});
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