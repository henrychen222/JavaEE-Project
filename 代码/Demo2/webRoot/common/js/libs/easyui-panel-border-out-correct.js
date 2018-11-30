var ie = $.browser.msie ? $.browser.version : 0;
var easyuiPanelOnResize = function(width, height) {

};
var easyuiPanelOnMove = function(left, top) {

};

$.fn.window.defaults.onResize = easyuiPanelOnResize;
$.fn.dialog.defaults.onResize = easyuiPanelOnResize;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;