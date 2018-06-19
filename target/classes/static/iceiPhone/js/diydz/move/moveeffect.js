(function($){
    var deltaX=0,deltaY=0;
    var initScale = 1; //放大倍数
    var initAngle = 0;//旋转角度
    var transform = {//图像效果
        translate: {x: 0, y: 0},
        scale: 1,
        angle: 0,
        rx: 0,
        ry: 0,
        rz: 0
    };
    $.MoverEffect=function(el,el1){
        var ticking = false;
        var hammertime=new Hammer.Manager(el.get(0));//用管理器 可以同时触发旋转 拖拽 移动

        hammertime.add(new Hammer.Pan({ threshold: 0, pointers: 0 }));
        hammertime.add(new Hammer.Rotate({ threshold: 0 })).recognizeWith(hammertime.get('pan'));
        hammertime.add(new Hammer.Pinch({ threshold: 0 })).recognizeWith([hammertime.get('pan'), hammertime.get('rotate')]);
        hammertime.add(new Hammer.Tap({event: 'doubletap', taps: 2}));

        hammertime.on("panstart panmove", onPan);//拖动开始+拖动过程
        hammertime.on("pinchstart pinchmove", onPinch);//多点触控开始+多点触控过程
        hammertime.on("rotatestart rotatemove", onRotate);//旋转开始+旋转过程
        hammertime.on("doubletap", onDoubleTap);//双击

        hammertime.on("panstart pinchstart rotatestart", function (ev) {//开始事件
            console.log("开始了")
            $("#dz-back").css("transition","all 0s");
        });
        hammertime.on("panend",function f(ev) {
            //拖动结束
            console.log("结束了")
            deltaX=deltaX+ev.deltaX;
            deltaY=deltaY+ev.deltaY;
            $("#dz-back").css("transition","all 1s");
        })

        /*拖动*/
        function onPan(ev) {
            el.className = '';
            transform.translate = {
                x: ev.deltaX+deltaX,
                y: ev.deltaY+deltaY
            };
            requestElementUpdate();
        }
        /*多点触控*/
        function onPinch(ev) {
            if (ev.type == 'pinchstart') {
                initScale = transform.scale || 1;
            }
            el1.className = '';
            transform.scale = initScale * ev.scale;
            requestElementUpdate();
        }

        /*旋转*/
        function onRotate(ev) {
            console.log("旋转")
            console.log(ev.rotation)
            if (ev.type == 'rotatestart') {
                initAngle = transform.angle || 0;
            }
            el1.className = '';
            transform.rz = 1;
            transform.angle = initAngle + ev.rotation;
            requestElementUpdate();
        }

        /*双击*/
        var onDouble=true,tranScale;
        function onDoubleTap(ev) {
            //执行的事件
            if (onDouble){
                tranScale=transform.scale;
                transform.scale=transform.scale*2;//放大1.1倍
                onDouble=false;
            }else {
                transform.scale=tranScale;//恢复上次大小
                onDouble=true;
            }
            requestElementUpdate();
        }

        /*更新*/
        function requestElementUpdate() {
            if (!ticking) {
                $("#restoration").fadeIn();//复位按钮显示
                reqAnimationFrame(updateElementTransform);
                ticking = true;
            }
        }

        var reqAnimationFrame = (function () {
            return window[Hammer.prefixed(window, 'requestAnimationFrame')] || function (callback) {
                window.setTimeout(callback, 1000 / 60);//延迟执行
            };
        })();

        /*dom赋值*/
        function updateElementTransform() {
            var value = [
                'translate3d(' + transform.translate.x + 'px, ' + transform.translate.y + 'px, 0)',
                'scale(' + transform.scale + ', ' + transform.scale + ')',
                'rotate3d(' + transform.rx + ',' + transform.ry + ',' + transform.rz + ',' + transform.angle + 'deg)'
            ];
            value = value.join(" ");
            //el1.get(0).textContent = value;
            el1.get(0).style.webkitTransform = value;
            el1.get(0).style.mozTransform = value;
            el1.get(0).style.transform = value;
            ticking = false;
        }
    },
    $.RecoverAll=function(){
        //恢复原始
        deltaX=0;
        deltaY=0;
        transform = {
            translate: {x: 0, y: 0},
            scale: 1,
            angle: 0,
            rx: 0,
            ry: 0,
            rz: 0
        };
        recover();//复位
    },
    $.RecoverScale=function () {
        //恢复大小
        transform.scale=1;
    },
    $.RecoverAngle=function () {
        //恢复角度
        transform.angle=0;
        transform.rx=0;
        transform.ry=0;
        transform.rz=0;
    },
    $.RecoverSite=function () {
        //恢复位置
        transform.translate.x=0;
        transform.translate.y=0;
    }
    var recover=function(){
        var value = [
            'translate3d(' + transform.translate.x + 'px, ' + transform.translate.y + 'px, 0)',
            'scale(' + transform.scale + ', ' + transform.scale + ')',
            'rotate3d(' + transform.rx + ',' + transform.ry + ',' + transform.rz + ',' + transform.angle + 'deg)'
        ];
        value = value.join(" ");
        $("#dz-back").css("transition","all 1s");
        $("#dz-back").get(0).style.webkitTransform = value;
        $("#dz-back").get(0).style.mozTransform = value;
        $("#dz-back").get(0).style.transform = value;
        $("#restoration").fadeOut();//隐藏复位按钮
    }
})(jQuery);