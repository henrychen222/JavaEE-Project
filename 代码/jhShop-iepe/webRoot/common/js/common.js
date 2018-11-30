//js获取contextpath，不需要写jsp标签。
//author:wangyan
function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
var contextPath = getContextPath();
window.contextPath = window.contextPath || contextPath;

// wangyan added @ 20150209 for set iframe size to content size
$(function() {
	setInterval(function() {
		var iframe = document.getElementById("iframeContent");
		if (iframe) {
			iframe.height = document.documentElement.scrollHeight - 145;
		}
	}, 100);
});