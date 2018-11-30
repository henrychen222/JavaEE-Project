//easyui extends
$.extend($.fn.validatebox.defaults.rules, {
	equalTo : {
		validator : function(value, param) {
			return $(param[0]).val() == value;
		},
		message : "两次输入密码不一致！"
	}
});

// jquery extends
$.extend({
	array2Json : function(array) {
		var json = {};
		var i = 0;
		$(array).each(function() {
			if (!json[this.name]) {
				json[this.name] = this.value;
				i = 1;
			} else {
				json[this.name + '[' + i + ']'] = this.value;
				i++;
			}
		});
		return json;
	}
});
// javascript extends
Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"H+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
};
