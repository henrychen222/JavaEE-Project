/**
 * iepe controls compilers
 * 
 * @author:wangyan
 */
(function($) {
	var metaData = window.MetaManager.metaData;
	var compilers = {
		// select panel, every select item compiled to checkbox, support select
		// all checkbox.
		selectPanel : function(o) {
			var arr = metaData[o.attr("metaTypeId")][o.attr("metaKeyId")];
			var html = "";
			// generate random group name, for select all checkbox.
			var tempGroup = "iepe-selectpanel-checkbox-group-" + Math.random();
			// handle new line
			var k = 0;
			var newLineCount = 0;
			if (/[0-9]+/.test(o.attr("newLineCount"))) {
				newLineCount = parseInt(o.attr("newLineCount"));
			}
			// single select sign.
			var singleSelect = /true/i.test(o.attr("singleSelect"));
			// generate select all checkbox.
			if (/true/i.test(o.attr("showSelectAll")) && !singleSelect) {
				var tempId = "iepe-selectpanel-selectitem-id-" + Math.random();
				html += "<input id='" + tempId + "' type='checkbox' name='"
						+ o.attr("name") + "' value='selectAll' "
						+ "iepe-group='" + tempGroup
						+ "' iepe-selectpanel-selectitem='1'/><label for='"
						+ tempId + "'>全选</label>";
				if (newLineCount > 0 && ++k % newLineCount == 0) {
					html += "<br/>";
				}
			}
			// generate every checkbox.
			for ( var i in arr) {
				if (/[0-9]+/.test(i)) {
					var j = arr[i];
					var tempId = "iepe-selectpanel-selectitem-id-"
							+ Math.random();
					html += "<input id='" + tempId + "' type='"
							+ (singleSelect ? "radio" : "checkbox")
							+ "' name='" + o.attr("name") + "' value='"
							+ j.VALUE + "' iepe-group='" + tempGroup
							+ "' iepe-selectpanel-selectitem='1'/><label for='"
							+ tempId + "'>" + j.VALUE_TITLE + "</label>";
					if (newLineCount > 0 && ++k % newLineCount == 0) {
						html += "<br/>";
					}
				}
			}
			// custom call js.
			var selectItemClickCallback = o.attr("selectItemClickCallback");
			// handle click event handler.
			var os = $(html);
			os.each(function() {
				if ($(this).attr("iepe-selectpanel-selectitem") == "1") {
					var o = $(this);
					// bind click event handler.
					o.click(function() {
						var o = $(this);
						var group = o.attr("iepe-group");
						var os = $("input[iepe-group='" + group
								+ "'][value!='selectAll']");
						if (this.value == "selectAll") {
							// this is select all checkbox, need to modify
							// checked status of all the checkboxes'.
							os.each(function() {
								this.checked = o.prop("checked");
							});
						} else {
							// this is select item, detected all the checked
							// status, modify the select all checkbox's checked
							// status if need.
							var oall = $("input[iepe-group='" + group
									+ "'][value='selectAll']");
							var allChecked = true;
							os.each(function() {
								if (!this.checked) {
									allChecked = false;
									// break loop.
									return false;
								}
							});
							oall.prop("checked", allChecked);
						}
						// handle custom callback method.
						eval(selectItemClickCallback);
					});
				}
			});
			os.insertBefore(o);
			o.remove();
		}
	};
	$(function() {
		$("select").each(function() {
			var o = $(this);
//			if (o.attr("compiled") != "compiled") {//原先代码
				if (o.attr("compiled") != "compiled"&&typeof(o.attr("compiled"))!= "undefined") {//修改出现不能支持indexof的错
				var classArr = o.prop("className").split(" ");
				for ( var i in classArr) {
					 var className = classArr[i];
					if (className.indexOf("iepe-") == 0) {
						var compiler = className.replace(/iepe-/, "");
						if (compilers[compiler]) {
							compilers[compiler]($(this));
							break;
						}
					}
				}
				o.attr("compiled", "compiled");
			}
		});
	});
})(jQuery);