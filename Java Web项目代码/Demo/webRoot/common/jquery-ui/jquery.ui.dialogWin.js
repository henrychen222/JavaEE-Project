(function(c, l) {
    var m = {
        "buttons": !0,
        "height": !0,
        "maxHeight": !0,
        "maxWidth": !0,
        "minHeight": !0,
        "minWidth": !0,
        "width": !0
    }, n = {
        "maxHeight": !0,
        "maxWidth": !0,
        "minHeight": !0,
        "minWidth": !0
    }, o = c.attrFn || {
        "val": !0,
        "css": !0,
        "html": !0,
        "text": !0,
        "data": !0,
        "width": !0,
        "height": !0,
        "offset": !0,
        "click": !0
    };
    c.widget("ui.dialogWin", {
        "options": {
            "autoOpen": !0,
            "buttons": {},
            "closeOnEscape": !0,
            "closeText": "关闭",
            "dialogClass": "",
            "draggable": !0,
            "hide": null,
            "height": "auto",
            "maxHeight": !1,
            "maxWidth": !1,
            "minHeight": 150,
            "minWidth": 150,
            "modal": !1,
            "position": {
                "my": "center",
                "at": "center",
                "collision": "fit",
                "using": function(a) {
                    var b = c(this).css(a).offset().top;
                    b < 0 && c(this).css("top", a.top - b);
                }
            },
            "resizable": !0,
            "show": null,
            "stack": !0,
            "title": "",
            "width": 300,
			"className": "",
			"closeBut": "",
            "zIndex": 1e3
        },
        "_create": function() {
            this.originalTitle = this.element.attr("title"), typeof this.originalTitle != "string" && (this.originalTitle = ""), this.options.title = this.options.title || this.originalTitle;
            var a = this, b = a.options, d = b.title || "&#160;", e = c.ui.dialogWin.getTitleId(a.element), g = (a.uiDialog = c("<div></div>")).appendTo(document.body).hide().addClass(b.className).css({
                "zIndex": b.zIndex
            }).attr("tabIndex", -1).css("outline", 0).keydown(function(i) {
                b.closeOnEscape && !i.isDefaultPrevented() && i.keyCode && i.keyCode === c.ui.keyCode.ESCAPE && (a.close(i), i.preventDefault());
            }).attr({
                "role": "dialog",
                "aria-labelledby": e
            }).mousedown(function(i) {
                a.moveToTop(!1, i);
            });
			var box = c('<div></div>').addClass("box").appendTo(g);
            a.element.show().removeAttr("title").addClass("box_main").appendTo(box);
			var h = (a.uiDialogTitlebar = c('<a href="javascript:;"></a>')).addClass("close").attr("title",b.closeText).hover(function() {
					//h.addClass("ui-state-hover");
				}, function() {
					//h.removeClass("ui-state-hover");
				}).focus(function() {
					//h.addClass("ui-state-focus");
				}).blur(function() {
					//h.removeClass("ui-state-focus");
				}).click(function(i) {
					return a.close(i), !1;
				}).appendTo(box);
			if(b.closeBut!=""){
				box.find(b.closeBut).click(function(i) {
					return a.close(i), !1;
				});
			}
			(a.uiDialogTitlebar = c("<h3></h3>")).addClass("title").attr("id", e).html(d).prependTo(box), c.isFunction(b.beforeclose) && !c.isFunction(b.beforeClose) && (b.beforeClose = b.beforeclose), b.draggable && c.fn.draggable && a._makeDraggable(), b.resizable && c.fn.resizable && a._makeResizable(), a._createButtons(b.buttons), a._isOpen = !1, c.fn.bgiframe && g.bgiframe();
        },
        "_init": function() {
            this.options.autoOpen && this.open();
        },
        "destroy": function() {
            var a = this;
            return a.overlay && a.overlay.destroy(), a.uiDialog.hide(), a.element.unbind(".dialogWin").removeData("dialog").removeClass("box_main").hide().appendTo("body"), a.uiDialog.remove(), a.originalTitle && a.element.attr("title", a.originalTitle), a;
        },
        "widget": function() {
            return this.uiDialog;
        },
        "close": function(a) {
            var b = this, d, e;
            if (!1 !== b._trigger("beforeClose", a)) return b.overlay && b.overlay.destroy(), b.uiDialog.unbind("keypress.ui-dialog"), b._isOpen = !1, b.options.hide ? b.uiDialog.hide(b.options.hide, function() {
                b._trigger("close", a);
            }) : (b.uiDialog.hide(), b._trigger("close", a)), c.ui.dialogWin.overlay.resize(), b.options.modal && (d = 0, c(".ui-dialog").each(function() {
                this !== b.uiDialog[0] && (e = c(this).css("z-index"), isNaN(e) || (d = Math.max(d, e)));
            }), c.ui.dialogWin.maxZ = d), b;
        },
        "isOpen": function() {
            return this._isOpen;
        },
        "moveToTop": function(a, b) {
            var d = this, e = d.options;
            return e.modal && !a || !e.stack && !e.modal ? d._trigger("focus", b) : (e.zIndex > c.ui.dialogWin.maxZ && (c.ui.dialogWin.maxZ = e.zIndex), d.overlay && (c.ui.dialogWin.maxZ += 1, d.overlay.$el.css("z-index", c.ui.dialogWin.overlay.maxZ = c.ui.dialogWin.maxZ)), a = {
                "scrollTop": d.element.scrollTop(),
                "scrollLeft": d.element.scrollLeft()
            }, c.ui.dialogWin.maxZ += 1, d.uiDialog.css("z-index", c.ui.dialogWin.maxZ), d.element.attr(a), d._trigger("focus", b), d);
        },
        "open": function() {
            if (!this._isOpen) {
                var a = this, b = a.options, d = a.uiDialog;
                return a.overlay = b.modal ? new c.ui.dialogWin.overlay(a) : null, a._size(), a._position(b.position), d.show(b.show), a.moveToTop(!0), b.modal && d.bind("keypress.ui-dialog", function(e) {
                    if (e.keyCode === c.ui.keyCode.TAB) {
                        var g = c(":tabbable", this), f = g.filter(":first");
                        g = g.filter(":last");
                        if (e.target === g[0] && !e.shiftKey) return f.focus(1), !1;
                        if (e.target === f[0] && e.shiftKey) return g.focus(1), !1;
                    }
                }), c(a.element.find(":tabbable").get().concat(d.find(".ui-dialog-buttonpane :tabbable").get().concat(d.get()))).eq(0).focus(), a._isOpen = !0, a._trigger("open"), a;
            }
        },
        "_createButtons": function(a) {
			/*
			//底下关闭按钮
            var b = this, d = !1, e = c("<div></div>").addClass("ui-dialog-buttonpane ui-widget-content ui-helper-clearfix"), g = c("<div></div>").addClass("ui-dialog-buttonset").appendTo(e);
            b.uiDialog.find(".ui-dialog-buttonpane").remove(), typeof a == "object" && a !== null && c.each(a, function() {
                return !(d = !0);
            }), d && (c.each(a, function(f, h) {
                h = c.isFunction(h) ? {
                    "click": h,
                    "text": f
                } : h;
                var i = c('<button type="button"></button>').click(function() {
                    h.click.apply(b.element[0], arguments);
                }).appendTo(g);
                c.each(h, function(j, k) {
                    j !== "click" && (j in o ? i[j](k) : i.attr(j, k));
                }), c.fn.button && i.button();
            }), e.appendTo(b.uiDialogBox));
			*/
        },
        "_makeDraggable": function() {
            function a(f) {
                return {
                    "position": f.position,
                    "offset": f.offset
                };
            }
            var b = this, d = b.options, e = c(document), g;
            b.uiDialog.draggable({
                "cancel": ".box_main, .close",/*取消拖动的对象*/
                "handle": ".title",/*需要拖动的对象*/
                "containment": "document",
                "start": function(f, h) {
                    g = d.height === "auto" ? "auto" : c(this).height(), c(this).height(c(this).height()), b._trigger("dragStart", f, a(h));
                },
                "drag": function(f, h) {
                    b._trigger("drag", f, a(h));
                },
                "stop": function(f, h) {
                    d.position = [ h.position.left - e.scrollLeft(), h.position.top - e.scrollTop() ], c(this).height(g), b._trigger("dragStop", f, a(h)), c.ui.dialogWin.overlay.resize();
                }
            });
        },
        "_makeResizable": function(a) {
            function b(f) {
                return {
                    "originalPosition": f.originalPosition,
                    "originalSize": f.originalSize,
                    "position": f.position,
                    "size": f.size
                };
            }
            a = a === l ? this.options.resizable : a;
            var d = this, e = d.options, g = d.uiDialog.css("position");
            a = typeof a == "string" ? a : "n,e,s,w,se,sw,ne,nw", d.uiDialog.resizable({
                "cancel": ".ui-dialog-content",
                "containment": "document",
                "alsoResize": d.element,
                "maxWidth": e.maxWidth,
                "maxHeight": e.maxHeight,
                "minWidth": e.minWidth,
                "minHeight": d._minHeight(),
                "handles": a,
                "start": function(f, h) {
                    c(this).addClass("ui-dialog-resizing"), d._trigger("resizeStart", f, b(h));
                },
                "resize": function(f, h) {
                    d._trigger("resize", f, b(h));
                },
                "stop": function(f, h) {
                    c(this).removeClass("ui-dialog-resizing"), e.height = c(this).height(), e.width = c(this).width(), d._trigger("resizeStop", f, b(h)), c.ui.dialogWin.overlay.resize();
                }
            }).css("position", g).find(".ui-resizable-se").addClass("ui-icon ui-icon-grip-diagonal-se");
        },
        "_minHeight": function() {
            var a = this.options;
            return a.height === "auto" ? a.minHeight : Math.min(a.minHeight, a.height);
        },
        "_position": function(a) {
            var b = [], d = [ 0, 0 ], e;
            if (a) {
                if (typeof a == "string" || typeof a == "object" && "0" in a) b = a.split ? a.split(" ") : [ a[0], a[1] ], b.length === 1 && (b[1] = b[0]), c.each([ "left", "top" ], function(g, f) {
                    +b[g] === b[g] && (d[g] = b[g], b[g] = f);
                }), a = {
                    "my": b.join(" "),
                    "at": b.join(" "),
                    "offset": d.join(" ")
                };
                a = c.extend({}, c.ui.dialogWin.prototype.options.position, a);
            } else a = c.ui.dialogWin.prototype.options.position;
            (e = this.uiDialog.is(":visible")) || this.uiDialog.show(), this.uiDialog.css({
                "top": 0,
                "left": 0
            }).position(c.extend({
                "of": window
            }, a)), e || this.uiDialog.hide();
        },
        "_setOptions": function(a) {
            var b = this, d = {}, e = !1;
            c.each(a, function(g, f) {
                b._setOption(g, f), g in m && (e = !0), g in n && (d[g] = f);
            }), e && this._size(), this.uiDialog.is(":data(resizable)") && this.uiDialog.resizable("option", d);
        },
        "_setOption": function(a, b) {
            var d = this, e = d.uiDialog;
            switch (a) {
              case "beforeclose":
                a = "beforeClose";
                break;
              case "buttons":
                d._createButtons(b);
                break;
              case "closeText":
                d.uiDialogTitlebarCloseText.text("" + b);
                break;
              case "dialogClass":
                e.removeClass(d.options.dialogClass).addClass(b.options.className);
                break;
              case "disabled":
                b ? e.addClass("ui-dialog-disabled") : e.removeClass("ui-dialog-disabled");
                break;
              case "draggable":
                var g = e.is(":data(draggable)");
                g && !b && e.draggable("destroy"), !g && b && d._makeDraggable();
                break;
              case "position":
                d._position(b);
                break;
              case "resizable":
                (g = e.is(":data(resizable)")) && !b && e.resizable("destroy"), g && typeof b == "string" && e.resizable("option", "handles", b), !g && b !== !1 && d._makeResizable(b);
                break;
              case "title":
                c(".title", d.uiDialogTitlebar).html("" + (b || "&#160;"));
            }
            c.Widget.prototype._setOption.apply(d, arguments);
        },
        "_size": function() {
            var a = this.options, b, d, e = this.uiDialog.is(":visible");
            this.element.show().css({
                "width": "auto",
                "minHeight": 0,
                "height": 0
            }), a.minWidth > a.width && (a.width = a.minWidth), b = this.uiDialog.css({
                "height": "auto",
                "width": a.width
            }).height(), d = Math.max(0, a.minHeight - b), a.height === "auto" ? c.support.minHeight ? this.element.css({
                "minHeight": d,
                "height": "auto"
            }) : (this.uiDialog.show(), a = this.element.css("height", "auto").height(), e || this.uiDialog.hide(), this.element.height(Math.max(a, d))) : this.element.height(Math.max(a.height - b, 0)), this.uiDialog.is(":data(resizable)") && this.uiDialog.resizable("option", "minHeight", this._minHeight());
        }
    }), c.extend(c.ui.dialogWin, {
        "version": "1.8.16",
        "uuid": 0,
        "maxZ": 0,
        "getTitleId": function(a) {
            return a = a.attr("id"), a || (this.uuid += 1, a = this.uuid), "title-" + a;//给标题设置ID
        },
        "overlay": function(a) {
            this.$el = c.ui.dialogWin.overlay.create(a);
        }
    }), c.extend(c.ui.dialogWin.overlay, {
        "instances": [],
        "oldInstances": [],
        "maxZ": 0,
        "events": c.map("focus,mousedown,mouseup,keydown,keypress,click".split(","), function(a) {
            return a + ".dialogWin-overlay";
        }).join(" "),
        "create": function(a) {
            this.instances.length === 0 && (setTimeout(function() {
                c.ui.dialogWin.overlay.instances.length && c(document).bind(c.ui.dialogWin.overlay.events, function(d) {
                    if (c(d.target).zIndex() < c.ui.dialogWin.overlay.maxZ) return !1;
                });
            }, 1), c(document).bind("keydown.dialogWin-overlay", function(d) {
                a.options.closeOnEscape && !d.isDefaultPrevented() && d.keyCode && d.keyCode === c.ui.keyCode.ESCAPE && (a.close(d), d.preventDefault());
            }), c(window).bind("resize.dialogWin-overlay", c.ui.dialogWin.overlay.resize));
            var b = (this.oldInstances.pop() || c("<div></div>").addClass("LayerWindow_bg")).appendTo(document.body).css({
                "width": this.width(),
                "height": this.height()
            });
            return c.fn.bgiframe && b.bgiframe(), this.instances.push(b), b;
        },
        "destroy": function(a) {
            var b = c.inArray(a, this.instances);
            b != -1 && this.oldInstances.push(this.instances.splice(b, 1)[0]), this.instances.length === 0 && c([ document, window ]).unbind(".dialogWin-overlay"), a.remove();
            var d = 0;
            c.each(this.instances, function() {
                d = Math.max(d, this.css("z-index"));
            }), this.maxZ = d;
        },
        "height": function() {
            var a, b;
            return c.browser.msie && c.browser.version < 7 ? (a = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight), b = Math.max(document.documentElement.offsetHeight, document.body.offsetHeight), a < b ? c(window).height() + "px" : a + "px") : c(document).height() + "px";
        },
        "width": function() {
            var a, b;
            return c.browser.msie ? (a = Math.max(document.documentElement.scrollWidth, document.body.scrollWidth), b = Math.max(document.documentElement.offsetWidth, document.body.offsetWidth), a < b ? c(window).width() + "px" : a + "px") : c(document).width() + "px";
        },
        "resize": function() {
            var a = c([]);
            c.each(c.ui.dialogWin.overlay.instances, function() {
                a = a.add(this);
            }), a.css({
                "width": 0,
                "height": 0
            }).css({
                "width": c.ui.dialogWin.overlay.width(),
                "height": c.ui.dialogWin.overlay.height()
            });
        }
    }), c.extend(c.ui.dialogWin.overlay.prototype, {
        "destroy": function() {
            c.ui.dialogWin.overlay.destroy(this.$el);
        }
    });
})(jQuery);