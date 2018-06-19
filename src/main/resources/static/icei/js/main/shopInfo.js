var bubbles = [{
		s: .6,
		x: 1134,
		y: 45
	}, {
		s: .6,
		x: 1620,
		y: 271
	}, {
		s: .6,
		x: 1761,
		y: 372
	}, {
		s: .6,
		x: 2499,
		y: 79
	}, {
		s: .6,
		x: 2704,
		y: 334
	}, {
		s: .6,
		x: 2271,
		y: 356
	}, {
		s: .6,
		x: 795,
		y: 226
	}, {
		s: .6,
		x: 276,
		y: 256
	}, {
		s: .6,
		x: 1210,
		y: 365
	}, {
		s: .6,
		x: 444,
		y: 193
	}, {
		s: .6,
		x: 2545,
		y: 387
	}, {
		s: .8,
		x: 1303,
		y: 193
	}, {
		s: .8,
		x: 907,
		y: 88
	}, {
		s: .8,
		x: 633,
		y: 320
	}, {
		s: .8,
		x: 323,
		y: 60
	}, {
		s: .8,
		x: 129,
		y: 357
	}, {
		s: .8,
		x: 1440,
		y: 342
	}, {
		s: .8,
		x: 1929,
		y: 293
	}, {
		s: .8,
		x: 2135,
		y: 198
	}, {
		s: .8,
		x: 2276,
		y: 82
	}, {
		s: .8,
		x: 2654,
		y: 182
	}, {
		s: .8,
		x: 2783,
		y: 60
	}, {
		x: 1519,
		y: 118
	}, {
		x: 1071,
		y: 233
	}, {
		x: 1773,
		y: 148
	}, {
		x: 2098,
		y: 385
	}, {
		x: 2423,
		y: 244
	}, {
		x: 901,
		y: 385
	}, {
		x: 624,
		y: 111
	}, {
		x: 75,
		y: 103
	}, {
		x: 413,
		y: 367
	}, {
		x: 2895,
		y: 271
	}, {
		x: 1990,
		y: 75
	}];
function LogoBubbles(e) {
	function n() {
		c.vertShrink = s(1e3, 800, window.innerHeight), c.vertShrink = d(c.vertShrink, 0, 1)
	}

	function t() {
		var e = c.container.getBoundingClientRect();
		(e.bottom < 0 || e.top > window.innerHeight) && 1 == c.playing ? c.playing = !1 : e.bottom > 0 && e.top < window.innerHeight && 0 == c.playing && (c.playing = !0, requestAnimationFrame(function (e) {
			c.tick(e)
		}))
	}

	function o(e) {
		var n = e.x + e.noiseX + c.scrollX,
			t = e.y + e.noiseY;
		t = a(t, c.containerHeight / 2, c.vertShrink * c.maxShrink), n < -200 && (e.x += c.containerWidth);
		var o = r(e.introProgress) / 20 + .95;
		o *= e.scale, e.el.style.opacity = r(e.introProgress), e.el.style.transform = "translate(" + n + "px, " + t + "px) scale(" + o + ")"
	}

	function i(e) {
		var n = 0,
			t = 0,
			o = null;
		for (n = e.length - 1; n > 0; n -= 1) t = Math.floor(Math.random() * (n + 1)), o = e[n], e[n] = e[t], e[t] = o
	}

	function r(e) {
		return e < .5 ? 2 * e * e : -1 + (4 - 2 * e) * e
	}

	function a(e, n, t) {
		return e * (1 - t) + n * t
	}

	function s(e, n, t) {
		return (t - e) / (n - e)
	}

	function d(e, n, t) {
		return Math.max(Math.min(e, t), n)
	}
	var c = this;
	for (u in e) c[u] = e[u];
	c.container = document.querySelector(c.containerSelector), c.noiseT = 0, c.scrollX = 0, c.logos.forEach(function (e, n) {
		c.logos[n] = {
			index: n,
			title: e
		}
	}), i(c.logos), c.vertShrink = 0, n(), window.addEventListener("resize", n), c.playing = !1, t(), window.addEventListener("scroll", t), c.logosLoaded = !1;
	var l = "./img/logo/logo.png";
	Gee.load.images(l, function () {
		c.logosLoaded = !0
	});
	for (var u = 0; u < c.bubbles.length; u++) {
		var f = c.bubbles[u],
			h = u % c.logos.length;
		f.scale = f.s || 1, f.seedX = 1e4 * Math.random(),
		f.seedY = 1e4 * Math.random(),
		f.noiseX = f.noiseY = 0, 
		f.introDelay = Math.random() * c.introDelay, f.introProgress = 0,
		f.el = document.createElement("div"),
		f.el.className = c.classPrefix + c.logos[h].index,//类名
		//f.el.data=c.idPrefix+c.logos[h].index,
		f.el.style.backgroundImage="url("+c.imgs[h]+")";//背景
        f.el.id=c.shopid[h],//id
		f.tagEl = document.createElement("span"),
		f.tagEl.innerHTML = c.logos[h].title,
		f.el.appendChild(f.tagEl), o(f),
		c.container.appendChild(f.el)

	}
	c.firstTick = null, c.lastTick = 0, c.tick = function (e) {
		c.firstTick || (c.firstTick = e), e -= c.firstTick;
		var n = e - c.lastTick;
		c.lastTick = e, c.noiseT += n * c.noiseSpeed, c.scrollX -= n * c.scrollSpeed;
		for (var t = 0; t < c.bubbles.length; t++) {
			var i = c.bubbles[t];
			i.noiseX = noise(i.seedX + c.noiseT) * c.noiseScale - c.noiseScale / 2, i.noiseY = noise(i.seedY + c.noiseT) * c.noiseScale - c.noiseScale / 2, c.logosLoaded && i.introProgress < 1 && e > i.introDelay && (i.introProgress = Math.min(1, i.introProgress + n / c.introDuration)), o(i)
		}
		c.playing && requestAnimationFrame(c.tick)
	}
}
var forEach = function (e, n, t) {
		for (var o = 0; o < e.length; o++) n.call(t, o, e[o])
	},
	randomIntFromInterval = function (e, n) {
		return Math.floor(Math.random() * (n - e + 1) + e)
	},
	$mapPins = document.querySelectorAll("#Map-shape g");
forEach($mapPins, function (e, n) {
	n.groupTimeline = new TimelineMax({
		paused: !0
	}), n.groupTimeline.to(n, .25, {
		opacity: 0
	});
	var t = new TimelineMax({
		repeat: -1,
		delay: randomIntFromInterval(1, 3),
		repeatDelay: randomIntFromInterval(0, 1)
	});
	t.to(n.querySelector(".Pin-back"), 3, {
		scale: 50,
		transformOrigin: "center center",
		opacity: 0
	})
}), forEach(document.querySelectorAll(".js-Location-nav [data-location]"), function (e, n) {
	n.addEventListener("mouseenter", function (e) {
		var n = e.target.getAttribute("data-location");
		forEach($mapPins, function (e, t) {
			t.getAttribute("data-location") !== n && t.groupTimeline.play()
		})
	}, !1), n.addEventListener("mouseleave", function (e) {
		forEach($mapPins, function (e, n) {
			n.groupTimeline.reverse()
		})
	}, !1)
}), $(".weixin").mouseenter(function () {
	$(".wx").css({
		opacity: 1,
		"z-index": 999
	})
}), $(".weixin").mouseleave(function () {
	$(".wx").css({
		opacity: 0,
		"z-index": 0
	})
});
var Gee = {
	random: function (e, n) {
		return Math.random() * (n - e) + e
	},
	arrayRandom: function (e) {
		return e[Math.floor(Math.random() * e.length)]
	},
	interpolate: function (e, n, t) {
		return e * (1 - t) + n * t
	},
	rangePosition: function (e, n, t) {
		return (t - e) / (n - e)
	},
	clamp: function (e, n, t) {
		return Math.max(Math.min(e, t), n)
	},
	queryArray: function (e, n) {
		return n || (n = document.body), Array.prototype.slice.call(n.querySelectorAll(e))
	},
	ready: function (e) {
		"loading" !== document.readyState ? e() : document.addEventListener("DOMContentLoaded", e)
	}
};
Gee.isRetina = window.devicePixelRatio > 1.3, Gee.mobileViewportWidth = 670, Gee.isMobileViewport = window.innerWidth < Gee.mobileViewportWidth, window.addEventListener("resize", function () {
	Gee.isMobileViewport = window.innerWidth < Gee.mobileViewportWidth
}), Gee.touch = {
	isSupported: "ontouchstart" in window || navigator.maxTouchPoints,
	isDragging: !1
}, document.addEventListener("DOMContentLoaded", function () {
	document.body.addEventListener("touchmove", function () {
		Gee.touch.isDragging = !0
	}), document.body.addEventListener("touchstart", function () {
		Gee.touch.isDragging = !1
	})
}), Gee.load = {
	images: function (e, n) {
		"string" == typeof e && (e = [e]);
		var t = -e.length;
		e.forEach(function (e) {
			var o = new Image;
			o.src = e, o.onload = function () {
				t++, 0 === t && n && n()
			}
		})
	},
	css: function (e, n) {
		var t = document.createElement("link"),
			o = window.readConfig("Gee_files") || {},
			i = o[e];
		if (!i) throw new Error('CSS file "' + e + '" not found in Gee_files config');
		t.href = i, t.rel = "stylesheet", document.head.appendChild(t), n && (t.onload = n)
	},
	js: function (e, n) {
		var t = document.createElement("script"),
			o = window.readConfig("Gee_files") || {},
			i = o[e];
		if (!i) throw new Error('Javascript file "' + e + '" not found in Gee_files config');
		t.src = i, t.async = !1, document.head.appendChild(t), n && (t.onload = n)
	}
};
var PERLIN_ZWRAPB = 8,
	PERLIN_ZWRAP = 1 << PERLIN_ZWRAPB,
	PERLIN_SIZE = 4095,
	perlin_octaves = 4,
	perlin_amp_falloff = .5,
	scaled_cosine = function (e) {
		return .5 * (1 - Math.cos(e * Math.PI))
	},
	perlin, noise = function (e) {
		if (null == perlin) {
			perlin = new Array(PERLIN_SIZE + 1);
			for (var n = 0; n < PERLIN_SIZE + 1; n++) perlin[n] = Math.random()
		}
		e < 0 && (e = -e);
		for (var t, o, i = Math.floor(e), r = e - i, a = 0, s = .5, d = 0; d < perlin_octaves; d++) t = scaled_cosine(r), o = perlin[i & PERLIN_SIZE], o += t * (perlin[i + 1 & PERLIN_SIZE] - o), a += o * s, s *= perlin_amp_falloff, i <<= 1, r *= 2, r >= 1 && (i++, r--);
		return a
	};
Gee.ready(function () {
	Gee.queryArray(".Section-quotePhoto--video").forEach(function (e) {
		function n() {
			var e = Gee.interpolate(20, 100, Gee.clamp(Gee.rangePosition(670, 1160, window.innerWidth), 0, 1));
			return {
				left: e,
				right: e,
				top: 0,
				bottom: 0
			}
		}

		function t(e) {
			var n = e.getBoundingClientRect();
			return {
				top: n.top,
				left: n.left,
				right: window.innerWidth - n.right,
				bottom: window.innerHeight - n.bottom
			}
		}

		function o(e, n) {
			["top", "right", "bottom", "left"].forEach(function (t) {
				e.style[t] = n[t] + "px"
			})
		}

		function i() {
			a.style.display = "block", s.offsetHeight, a.classList.remove("inactive")
		}

		function r() {
			a.classList.add("inactive"), a.addEventListener("transitionend", function () {
				a.style.display = "none"
			}, {
				once: !0
			})
		}
		var a = document.getElementById(e.getAttribute("data-video")),
			s = a.querySelector(".VideoContainer-wrapper"),
			d = a.querySelector("video");
		e.addEventListener("click", function (a) {
			return navigator.userAgent.match(/(iPhone|iPod)/g) ? (o(s, n()), void d.play()) : (s.classList.add("no-anim"), o(s, t(e)), s.offsetHeight, s.classList.remove("no-anim"), o(s, n()), i(), d.play(), document.body.addEventListener("keyup", function (n) {
				"Escape" == n.key && (o(s, t(e)), r(), d.pause())
			}, {
				once: !0
			}), void 0)
		}), a.addEventListener("click", function (n) {
			o(s, t(e)), r(), d.pause()
		}), d.addEventListener("click", function (e) {
			e.stopPropagation(), d.paused ? d.play() : d.pause()
		})
	})
});
//Gee.ready(function () {
//	window.logoBubbles = new LogoBubbles({
//		bubbles: bubbles,
//		logos: logos,
//		classPrefix: "Icon Icon-img",
//		containerSelector: ".IconsContainer",
//		containerWidth: 3e3,
//		containerHeight: 460,
//		maxShrink: .2,
//		noiseSpeed: 55e-6,
//		noiseScale: 80,
//		scrollSpeed: .0175,
//		introDelay: 1500,
//		introDuration: 1500
//	})
//}), "use strict";