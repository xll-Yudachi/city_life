var jconfirm, Jconfirm;
!function (e) {
  jconfirm = function (t) {
    void 0 === t && (t = {}), jconfirm.defaults && e.extend(jconfirm.pluginDefaults, jconfirm.defaults);
    var t = e.extend({}, jconfirm.pluginDefaults, t);
    return new Jconfirm(t)
  }, Jconfirm = function (t) {
    e.extend(this, t), this._init()
  }, Jconfirm.prototype = {
    setDialogCenter: function () {
      if ("none" == this.$contentPane.css("display")) var t = 0, i = 0; else {
        var t = this.$content.outerHeight(), i = this.$contentPane.height();
        0 == i && (i = t)
      }
      var n = this.$content.outerWidth();
      this.$content.css({clip: "rect(0px " + (100 + n) + "px " + t + "px -100px)"}), this.$contentPane.css({height: t});
      var s = e(window).height(), a = this.$b.outerHeight() - i + t, o = (s - a) / 2;
      if (a > s - 100) {
        var r = {"margin-top": 50, "margin-bottom": 50};
        e("body").addClass("jconfirm-noscroll")
      } else {
        var r = {"margin-top": o};
        e("body").removeClass("jconfirm-noscroll")
      }
      this.$b.css(r)
    }, close: function () {
      var t = this;
      if (this.isClosed()) return !1;
      "function" == typeof this.onClose && this.onClose(), this._unwatchContent(), t._lastFocused.focus(), e(window).unbind("resize." + this._rand), this.keyboardEnabled && e(window).unbind("keyup." + this._rand), t.$el.find(".jconfirm-bg").removeClass("seen"), e("body").removeClass("jconfirm-noscroll"), this.$b.addClass(this.closeAnimation);
      var i = "anim-none" == this.closeAnimation ? 0 : this.animationSpeed;
      return setTimeout(function () {
        t.$el.remove()
      }, 25 * i / 100), jconfirm.record.closed += 1, jconfirm.record.currentlyOpen -= 1, !0
    }, open: function () {
      var e = this;
      if (this.isClosed()) return !1;
      e.$el.find(".jconfirm-bg").addClass("seen"), this.$b.removeClass(this.animation), this.$b.find("input[autofocus]:visible:first").focus(), jconfirm.record.opened += 1, jconfirm.record.currentlyOpen += 1, "function" == typeof this.onOpen && this.onOpen();
      var t = "jconfirm-box" + this._rand;
      return this.$b.attr("aria-labelledby", t).attr("tabindex", -1).focus(), this.$title ? this.$title.attr("id", t) : this.$content && this.$content.attr("id", t), setTimeout(function () {
        e.$b.css({"transition-property": e.$b.css("transition-property") + ", margin"}), e._modalReady.resolve()
      }, this.animationSpeed), !0
    }, isClosed: function () {
      return "" === this.$el.css("display")
    }
  }, jconfirm.pluginDefaults = {
    template: '<div class="jconfirm"><div class="jconfirm-bg"></div><div class="jconfirm-scrollpane"><div class="container"><div class="row"><div class="jconfirm-box-container"><div class="jconfirm-box" role="dialog" aria-labelledby="labelled" tabindex="-1"><div class="closeIcon">&times;</div><div class="title-c"><span class="icon-c"></span><span class="title"></span></div><div class="content-pane"><div class="content"></div></div><div class="buttons"></div><div class="jquery-clear"></div></div></div></div></div></div></div>',
    title: "提示",
    content: "确定吗",
    contentLoaded: function () {
    },
    icon: "",
    opacity: null,
    confirmButton: "确定",
    cancelButton: "取消",
    confirmButtonClass: "btn",
    cancelButtonClass: "btn btn-slight",
    buttonsReverse: !1,
    theme: "white",
    animation: "scale",
    closeAnimation: "none",
    animationSpeed: 500,
    animationBounce: 1.2,
    keyboardEnabled: !1,
    rtl: !1,
    confirmKeys: [13],
    cancelKeys: [27],
    container: "body",
    confirm: function () {
    },
    cancel: function () {
    },
    backgroundDismiss: !0,
    autoClose: !1,
    closeIcon: null,
    closeIconClass: !1,
    watchInterval: 100,
    columnClass: "pop-container",
    onOpen: function () {
    },
    onClose: function () {
    },
    onAction: function () {
    }
  }, jconfirm.record = {opened: 0, closed: 0, currentlyOpen: 0}
}(jQuery), function (e, t, i) {
  "use strict";
  var n = (e(t), e(document), !-[1] && t.XMLHttpRequest, !1), s = function (t) {
    this.settings = e.extend({}, s.defaults, t), this.init()
  };
  s.defaults = {
    bind: !1,
    wrapClass: "",
    content: "请稍等...",
    title: "提示",
    onCancel: null,
    onOpen: null,
    onConfirm: null,
    onClose: null,
    closeText: !0,
    confirmText: "确定",
    cancelText: "取消",
    position: "center",
    inline: !1,
    isSelecter: !1,
    element: null,
    preKa: "",
    autoTime: null,
    lock: !0,
    closeLayer: !0,
    opacityLock: !1
  }, s.prototype = {
    init: function () {
      this.create()
    }, create: function () {
      var t = "", i = "", n = "", s = "", a = "", o = "", r = "";
      this.settings.type && (t = '<i class="icon-dialog icon-dialog-' + this.settings.type + '"></i>'), this.settings.lock && (n = '<div class="dialog-layer"></div>', this.settings.opacityLock && (n = '<div class="dialog-layer dialog-opacity-layer"></div>')), this.settings.preKa && (s = this.settings.preKa + "_"), ("around" == this.settings.position || this.settings.inline) && (a = '<span class="icon-dialog-arrow"></span>'), this.settings.closeText && (o = '<a href="javascript:;" class="close" ka="' + s + 'dialog_close"><i class="icon-close"></i></a>'), (this.settings.confirmText || this.settings.cancelText) && (r = '<div class="dialog-footer"><div class="btns"></div></div>'), i = '<div class="dialog-wrap">' + n + '<div class="dialog-container">' + a + '<div class="dialog-title">' + t + '<h3 class="title">' + this.settings.title + "</h3>" + o + '</div><div class="dialog-con">' + this.settings.content + "</div>" + r + "</div></div>", e(".dialog-wrap").length && !this.settings.inline && e(".dialog-wrap").each(function () {
        e(this).hasClass("v-transfer-dom") || e(this).remove()
      }), this.settings.inline && this.settings.element ? this.dialog = e(i).appendTo(e(this.settings.element).parent()) : this.dialog = e(i).appendTo("body"), (this.settings.onConfirm || this.settings.confirmText) && this.onConfirm(), (this.settings.onCancel && !1 !== this.settings.cancelText || this.settings.cancelText) && this.onCancel(), this.settings.wrapClass && this.dialog.addClass(this.settings.wrapClass), this.settings.type && this.dialog.addClass("dialog-icons-default"), this.settings.position && this.position(), this.bindEvent(), e("body").addClass("dialog-open"), e.isFunction(this.settings.onOpen) && (this.settings.bind ? this.settings.onOpen.apply(this, this.dialog) : this.settings.onOpen(this.dialog)), this.settings.lock && this.lock(), this.autoInter && clearInterval(this.autoInter), e.isNumeric(this.settings.autoTime) && this.autoCloseTimer()
    }, onConfirm: function () {
      var t = this, i = this.dialog.find(".dialog-footer .btns");
      e("<span>", {
        ClASS: "btn btn-sure",
        text: t.settings.confirmText,
        ka: (t.settings.preKa ? t.settings.preKa + "_" : "") + "dialog_confirm",
        click: function () {
          e.isFunction(t.settings.onConfirm) ? t.settings.bind ? t.settings.onConfirm.apply(t, t.dialog) : t.settings.onConfirm(t.dialog) : t.close("confirm")
        }
      }).prependTo(i)
    }, onCancel: function () {
      var t = this, i = this.dialog.find(".dialog-footer .btns");
      e("<span>", {
        ClASS: "btn btn-outline btn-cancel",
        text: t.settings.cancelText,
        ka: (t.settings.preKa ? t.settings.preKa + "_" : "") + "dialog_cancel",
        click: function () {
          e.isFunction(t.settings.onCancel) ? t.settings.bind ? t.settings.onCancel.apply(t, t.dialog) : t.settings.onCancel(t.dialog) : t.close("cancel")
        }
      }).prependTo(i)
    }, size: function () {
      var e = this.dialog.find(".dialog-con");
      this.dialog.find(".dialog-container");
      e.css({width: this.settings.width, height: this.settings.height})
    }, position: function () {
      if (this.settings.element) {
        var i = this, n = i.settings.element, s = i.dialog.find(".dialog-container").outerWidth(), a = e(n).offset(),
          o = a.left + n.width() / 2;
        o < s && (o = s / 2), i.settings.inline || "around" != i.settings.position || i.dialog.css({
          left: o + "px",
          top: a.top + "px"
        }), i.settings.inline && (i.dialog.get(0).getBoundingClientRect().top > 330 && t.innerHeight - i.dialog.get(0).getBoundingClientRect().top < 280 && i.dialog.addClass("dialog-up-default"), i.settings.isSelecter && e(document).on("click", function (t) {
          t.target == n.get(0) || t.target.parentNode == n.get(0) || e(t.target).closest(".dialog-selecter-default").length || (i.dialog.closest(".dropdown-wrap").removeClass("dropdown-menu-open"), i.close())
        }))
      }
    }, lock: function () {
      if (!n) {
        var e = this;
        e.dialog.find(".dialog-container");
        this.settings.closeLayer && e.dialog.find(".dialog-layer").on("click", function () {
          e.close()
        })
      }
    }, unLock: function () {
      this.settings.lock && n && (e("html,body").css("overflow", "visible"), n = !1)
    }, close: function (t) {
      e.isFunction(this.settings.onClose) && this.settings.onClose(this.dialog, t || ""), this.dialog.remove(), this.unLock(), this.autoInter && clearInterval(this.autoInter), e("body").removeClass("dialog-open")
    }, hide: function (t) {
      e.isFunction(this.settings.onClose) && this.settings.onClose(this.dialog, t || ""), this.dialog.hide(), this.unLock(), e("body").removeClass("dialog-open")
    }, autoCloseTimer: function () {
      var e = this, t = e.dialog.find(".btn-sure"), i = e.settings.autoTime, n = t.text();
      i && (e.autoInter && clearInterval(e.autoInter), e.autoInter = setInterval(function () {
        i <= 1 ? (clearInterval(e.autoInter), e.close("timer")) : (i--, t.text(n + "(" + i + "s)"))
      }, 1e3))
    }, bindEvent: function () {
      var i = this;
      this.dialog.find(".close").on("click", function () {
        i.close("")
      }), e(t).on("resize.dialog", function () {
        i.settings.onResize && i.settings.onResize(i.dialog)
      })
    }
  }, e.dialog = function (e) {
    return new s(e)
  }
}(jQuery, window);

$(function () {
  $(".job-location .job-location-map[data-content]").each(function () {
    var e = $(this), t = e.attr("data-content");
    !$.trim(e.html()) && t && (new AMap.Geocoder).getLocation(t, function (t, i) {
      if ("complete" === t && "OK" === i.info) {
        var n = i.geocodes[0].location;
        e.html('<img src="https://restapi.amap.com/v3/staticmap?zoom=16&amp;size=836*174&amp;markers=mid,0xFF0000,A:' + n.lng + "," + n.lat + '&amp;key=21b56a6cc83fad7668dbb0e9564759a7" alt="公司地址"><p>点击查看地图</p>')
      }
    })
  })
  $(".js-open-map").on("click", function () {
    var e = $(this).find("img").attr("src").match(/:([^&]+)/g), t = e[1].replace(":", ""),
      i = $(this).attr("data-content"),
      n = ['<div class="job-location job-location-width">', '<div class="location-address">' + i + "</div>", '<div id="map-container" class="map-container" data-long-lat="' + t + '"></div>', "</div>"];
    $.dialog({
      content: n.join(""),
      title: "",
      closeText: !0,
      cancelText: "",
      confirmText: "",
      wrapClass: "map-pop",
      onOpen: function (e) {
        var n = t.split(","),
          s = new AMap.Map("map-container", {resizeEnable: !0, scrollWheel: !0, center: [n[0], n[1]], zoom: 16}),
          a = (s.on("click", function () {
          }), s.on("mouseout", function () {
          }), new AMap.Marker({
            map: s,
            position: [n[0], n[1]],
            icon: new AMap.Icon({
              size: new AMap.Size(42, 50),
              image: "https://static.zhipin.com/zhipin/v40//web/geek/images/icon-poi.png",
              imageOffset: new AMap.Pixel(0, -60)
            })
          }));
        AMap.event.addListener(a, "click", function () {
          infoWindow.open(s, a.getPosition())
        }), AMap.plugin(["AMap.ToolBar", "AMap.Scale"], function () {
          var e = new AMap.ToolBar, t = new AMap.Scale;
          s.addControl(e), s.addControl(t)
        }), infoWindow = new AMap.InfoWindow({
          content: i,
          offset: new AMap.Pixel(5, -25)
        }), infoWindow.open(s, s.getCenter()), e.find(".dialog-container").css({margin: "-250px 0 0 -330px"})
      }
    })
  })
  $(".js-open-detail").on("click", function () {
    var e = $(this).attr("data-id"), t = $(this).attr("data-lat"), i = $(this).attr("data-content"),
      n = ['<div class="location-item show-map location-item-pop">', '<div class="location-address"><a href="javascript:;" class="more-view><i class="fz fz-slidedown"></i></a>' + i + "</div>", '<div class="map-container js-map-container" id="' + e + '" data-long-lat="' + t + '"></div>', "</div>"];
    $.dialog({
      content: n.join(""),
      title: "",
      closeText: !0,
      cancelText: "",
      confirmText: "",
      wrapClass: "map-pop",
      onOpen: function (e) {
        $(".js-map-container").each(function () {
          var e = $(this).attr("id"), t = $(this).attr("data-long-lat").split(","),
            n = new AMap.Map(e, {resizeEnable: !0, scrollWheel: !0, center: [t[0], t[1]], zoom: 16}),
            s = (n.on("click", function () {
            }), n.on("mouseout", function () {
            }), new AMap.Marker({
              map: n,
              position: [t[0], t[1]],
              icon: new AMap.Icon({
                size: new AMap.Size(42, 50),
                image: "https://static.zhipin.com/zhipin/v40//web/geek/images/icon-poi.png",
                imageOffset: new AMap.Pixel(0, -60)
              })
            }));
          AMap.event.addListener(s, "click", function () {
            infoWindow.open(n, s.getPosition())
          }), infoWindow = new AMap.InfoWindow({
            content: i,
            offset: new AMap.Pixel(5, -25)
          }), infoWindow.open(n, n.getCenter()), AMap.plugin(["AMap.ToolBar", "AMap.Scale"], function () {
            var e = new AMap.ToolBar, t = new AMap.Scale;
            n.addControl(e), n.addControl(t)
          })
        }), $(".dialog-container").css({margin: "-250px 0 0 -325px"})
      }
    }), $(".dialog-container").css({margin: "-250px 0 0 -325px"})
  })
});
