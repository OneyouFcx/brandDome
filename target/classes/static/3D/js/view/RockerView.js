var RockerView = (function(_super){
	var obj;
    function RockerView(obj_param){
        RockerView.super(this);
         /***当前多点触摸id****/
        this.curTouchId = 0;
        /***手指（鼠标）是否按下****/
        this.isDown = false;
        /***摇杆的角度****/
        this.angle = -1;        
        /***摇杆的弧度****/
        this.radians = -1;
        /***是否左手遥控****/
        this.isleftControl = true;   
        //鼠标按下事件监听
        Laya.stage.on(Laya.Event.MOUSE_DOWN,this,onMouseDown);
        //鼠标抬起事件监听
        Laya.stage.on(Laya.Event.MOUSE_UP,this,onMouseUp);
        //鼠标是否移除屏幕事件监听
        // this.touchRect.on(Laya.Event.MOUSE_OUT,this,onBlur);
        //控制器中心点位置初始化
        this.originPiont = new Laya.Point(this.width/2,this.height/2);
        //默认为控制器显示
        this.visible = true;
        
        obj=obj_param;
        
        this.pos(0,250);
    }
    Laya.class(RockerView,"RockerView",_super);
    /*鼠标按下事件回调*/
    function onMouseDown(e){
        //左右手遥控
        if(this.isleftControl){
            //如果按下时是右边屏幕位置或已经按下鼠标，则返回
            if(e.stageX > Laya.stage.width/2 || this.isDown)return;
        }
        else{
            //如果按下时是左边屏幕位置或已经按下鼠标，则返回
            if(e.stageX < Laya.stage.width/2 || this.isDown)return;
        }
        //记录当前按下id
         this.curTouchId = e.touchId;
         //已按下
         this.isDown = true;
         //摇杆移动控制事件监听
         Laya.stage.on(Laya.Event.MOUSE_MOVE,this,onMove);
    }
    /*鼠标抬起事件回调*/
    function onMouseUp(e){
        //如果不是上次的点击id，返回（避免多点抬起，以第一次按下id为准）
        if(e.touchId != this.curTouchId)return;
        this.isDown = false;
         //初始化摇杆控制点位置
         this.knob.pos(this.width / 2, this.height / 2);
        //移除摇杆移动事件监听
        Laya.stage.off(Laya.Event.MOUSE_MOVE,this,onMove);
        //修改摇杆角度与弧度为-1（代表无角度）
        this.radians = this.angle = -1;
    }
    /*鼠标移动事件回调*/
   
	var lastPos_x = 0;
    function onMove(e){
        //如果不是上次的点击id，返回（避免多点抬起，以第一次按下id为准）
        if(e.touchId != this.curTouchId)return;
        //将移动时的鼠标屏幕坐标转化为摇杆局部坐标
        var locationPos = this.globalToLocal(new Laya.Point(Laya.stage.mouseX,Laya.stage.mouseY),false);
        //更新摇杆控制点位置
        this.knob.pos(locationPos.x,locationPos.y);
        //更新控制点与摇杆中心点位置距离
        this.deltaX = locationPos.x - this.originPiont.x;
        this.deltaY = locationPos.y - this.originPiont.y;
        //计算控制点在摇杆中的角度
        var dx = this.deltaX * this.deltaX;
        var dy = this.deltaY * this.deltaY;
        this.angle = Math.atan2(this.deltaX,this.deltaY) * 180 / Math.PI; 
        if(this.angle < 0) this.angle += 360;
        //对角度取整
        this.angle = Math.round(this.angle);
        //计算控制点在摇杆中的弧度
        this.radians = Math.PI / 180 * this.angle;
        //强制控制点与中心距离不超过80像素
        if(dx+dy >= 80*80){
            //控制点在半径为80像素的位置（根据弧度变化）
            var x = Math.floor(Math.sin(this.radians) * 80 +this.originPiont.x);
            var y = Math.floor(Math.cos(this.radians) * 80 + this.originPiont.y);
            this.knob.pos(x,y);
        }
        else{
            //不超过80像素取原坐标
            this.knob.pos(locationPos.x,locationPos.y);
        }
        if(locationPos.x <= lastPos_x) {
			obj.transform.rotate(new Laya.Vector3(0, -4, 0), false, false);
		} else {

			obj.transform.rotate(new Laya.Vector3(0, 4, 0), false, false);
		}
		lastPos_x = locationPos.x;
    }
    return RockerView;
})(ui.RockerUI);