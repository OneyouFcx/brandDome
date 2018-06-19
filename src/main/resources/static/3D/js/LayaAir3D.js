var LayaAir3D = (function() {
	function LayaAir3D() {

		//初始化引擎
		Laya3D.init(0, 0, true);

		//适配模式
		Laya.stage.scaleMode = Laya.Stage.SCALE_FULL;
		Laya.stage.screenMode = Laya.Stage.SCREEN_NONE;

		//开启统计信息
		//Laya.Stat.show();

		//添加3D场景
		var scene = Laya.stage.addChild(new Laya.Scene());

		//添加照相机
		var camera = (scene.addChild(new Laya.Camera()));
		camera.transform.translate(new Laya.Vector3(0, 1, 1));
		camera.clearColor = null;
		camera.clearFlag = Laya.BaseCamera.CLEARFLAG_SKY;
		camera.orthographicProjection = true;

		//添加平行光
		var light = scene.addChild(new Laya.DirectionLight());
		//设置平行光的方向
		light.direction = new Laya.Vector3(-0.5, -1, -3);

		//加载摇杆
		//Laya.loader.load("res/atlas/comp.atlas", Laya.Handler.create(this, on2DComplete));

		/*function on2DComplete() {
			LayaAir3D.rocker = new RockerView(this.obj);
			Laya.stage.addChild(LayaAir3D.rocker);
			Laya.stage.setChildIndex(scene, 0);
		}*/

		this.obj = Laya.Sprite3D.load("3D/h5/LayaScene_SampleScene/SampleScene.lh");

		this.obj.on(Laya.Event.HIERARCHY_LOADED, this, onLoadComplete);

		var _cupBody;

		function onLoadComplete() {
			this.obj.transform.rotate(new Laya.Vector3(-90, -90, 0), false, false);
			this.obj.transform.localScale = new Laya.Vector3(4, 4, 4);
			scene.addChild(this.obj);
			camera.transform.lookAt(this.obj.transform.position, new Laya.Vector3(0, 0, 0));
			this.cupBody = this.obj.getChildAt(0).getChildAt(1);
			this.cupHand = this.obj.getChildAt(0).getChildAt(0);
			_cupBody = this.cupBody;

			this.cupHand.meshRender.material.albedo = new Laya.Vector4(1, 1, 1, 1);
			this.cupBody.meshRender.material.ambientColor = new Laya.Vector4(1, 1, 1, 1);

			//使用BlinnPhongMaterial材质
			var material = new Laya.BlinnPhongMaterial();
			material.albedoTexture = Laya.Texture2D.load("http://zhiqutuku.test.upcdn.net/zhiqu/sysImg/pingpushoujibizhi/55804249.jpg");
			this.cupBody.meshRender.material = material;
			//设置贴图偏移
			/*
			transformUV.offset = new Laya.Vector2(0.2, 0);
			material.transformUV = transformUV;*/

			//使用标准材质
			/*var material= Laya.StandardMaterial.load("h5/LayaScene_SampleScene/Assets/Materials/Colorful.lmat");
			this.cupBody.meshRender.material=material;
			var transformUV = new Laya.TransformUV();
			transformUV.offset = new Laya.Vector2(0.7, 0);
			material.transformUV = transformUV;*/
		}

		Laya.stage.on(Laya.Event.MOUSE_DOWN, scene, onMouseDown);
		Laya.stage.on(Laya.Event.MOUSE_UP, scene, onMouseUp);
		Laya.stage.on(Laya.Event.MOUSE_WHEEL, scene, onMouseWheel);
		math.config({
			number: 'BigNumber'
		});

		function onMouseMove() {
			var locationPos = this.globalToLocal(new Laya.Point(Laya.stage.mouseX, Laya.stage.mouseY), false);
			var target_y = (locationPos.x - lastPos_x) >= 0 ? 6 : -6;
			var target_x = (locationPos.y - lastPos_y) >= 0 ? 0.1 : -0.1;
			obj.transform.rotate(new Laya.Vector3(0, target_y, 0), false, false);

			//对于Y轴处理
			if(target_x > 0) {
				if(camera.transform.position.y > 1.4) {
					camera.transform.position.z = 0.3;
					return;
				}
			} else {
				if(camera.transform.position.y < -0.4) {
					camera.transform.position.z = 1.2;
					return;
				}
			}
			//对于Z轴处理
			var target_z;
			if(camera.transform.position.z > 1.2) {
				target_z = 1.2;
			} else if(camera.transform.position.z < 0.3) {
				target_z = 0.3;
			}

			camera.transform.translate(new Laya.Vector3(0, target_x, 0));
			camera.transform.lookAt(obj.transform.position, new Laya.Vector3(0, 1, 0), false);
			//camera.transform.position.y = (camera.transform.position.y).toFixed(2);
			lastPos_x = locationPos.x;
			lastPos_y = locationPos.y;
		}

		function onMouseWheel(e) {
			var _x = obj.transform.localScale.x;
			var _y = obj.transform.localScale.y;
			var _z = obj.transform.localScale.z;
			if(e.delta > 0) {
				//向上滚动，放大视角
					obj.transform.localScale = new Laya.Vector3(_x + 0.1, _y + 0.1, _z + 0.1);
			} else {
				//向下滚动，缩小视角
				if(_z >= 2) {
					obj.transform.localScale = new Laya.Vector3(_x - 0.1, _y - 0.1, _z - 0.1);
				}
			}
		}

		function onMouseDown() {
			Laya.stage.on(Laya.Event.MOUSE_MOVE, scene, onMouseMove);
			var locationPos = this.globalToLocal(new Laya.Point(Laya.stage.mouseX, Laya.stage.mouseY), false);
			lastPos_x = locationPos.x;
			lastPos_y = locationPos.y;
		}
		var lastPos_x = 0;
		var lastPos_y = 0;

		function onMouseUp() {
			Laya.stage.off(Laya.Event.MOUSE_MOVE, scene, onMouseMove);
			lastPos_x = 0;
			lastPos_y = 0;
		}

		var support = {
				transitions: Modernizr.csstransitions
			},
			// transition end event name
			transEndEventNames = {
				'WebkitTransition': 'webkitTransitionEnd',
				'MozTransition': 'transitionend',
				'OTransition': 'oTransitionEnd',
				'msTransition': 'MSTransitionEnd',
				'transition': 'transitionend'
			},
			transEndEventName = transEndEventNames[Modernizr.prefixed('transition')],
			onEndTransition = function(el, callback) {
				var onEndCallbackFn = function(ev) {
					if(support.transitions) {
						if(ev.target != this) return;
						this.removeEventListener(transEndEventName, onEndCallbackFn);
					}
					if(callback && typeof callback === 'function') {
						callback.call(this);
					}
				};
				if(support.transitions) {
					el.addEventListener(transEndEventName, onEndCallbackFn);
				} else {
					onEndCallbackFn();
				}
			};

		var _instance;
		var _item;
		new GridFx(document.querySelector('.grid'), {
			imgPosition: {
				x: -0.5,
				y: 1
			},
			onOpenItem: function(instance, item) {
				_instance = instance;
				_item = item;
				instance.items.forEach(function(el) {
					if(item != el) {
						var delay = Math.floor(Math.random() * 50);
						el.style.WebkitTransition = 'opacity .5s ' + delay + 'ms cubic-bezier(.7,0,.3,1), -webkit-transform .5s ' + delay + 'ms cubic-bezier(.7,0,.3,1)';
						el.style.transition = 'opacity .5s ' + delay + 'ms cubic-bezier(.7,0,.3,1), transform .5s ' + delay + 'ms cubic-bezier(.7,0,.3,1)';
						el.style.WebkitTransform = 'scale3d(0.1,0.1,1)';
						el.style.transform = 'scale3d(0.1,0.1,1)';
						el.style.opacity = 0;
					}
				});
				tm.to(".circle", 0.5, {
					opacity: "0",
					onComplete: function() {
						$(".circle").hide();
					}
				});
			},
			onCloseItem: function(instance, item) {
				instance.items.forEach(function(el) {
					if(item != el) {
						el.style.WebkitTransition = 'opacity .4s, -webkit-transform .4s';
						el.style.transition = 'opacity .4s, transform .4s';
						el.style.WebkitTransform = 'scale3d(1,1,1)';
						el.style.transform = 'scale3d(1,1,1)';
						el.style.opacity = 1;

						onEndTransition(el, function() {
							el.style.transition = 'none';
							el.style.WebkitTransform = 'none';
						});
					}
				});
				tm.to(".circle", 0.5, {
					opacity: "1",
					onComplete: function() {
						$(".circle").show();
					}
				});
			},
			onExpand: function() {
				$(".original").click(function() {
					var _src = $(this).attr("src");
					var material = new Laya.BlinnPhongMaterial();
					material.diffuseColor = new Laya.Vector3(1, 1, 1);
					material.ambientColor = new Laya.Vector3(1, 1, 1);
					material.albedoTexture = Laya.Texture2D.load(_src);
					_cupBody.meshRender.material = material;
					$(".action--close").click();
					setTimeout(function() {
						$(".circle").click();
					}, 1000);
				});
			}
		});
	}
	return LayaAir3D;
}());

LayaAir3D();