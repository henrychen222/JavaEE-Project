/**
 * 查找带回功能
 * 
 * @author wangyan
 * @base 本文件为查找带回功能支持脚本文件。用于对input框指定查找带回功能。 放置位置：easyui后。
 */
function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
var contextPath = getContextPath();
var QUERY_BACK_ATTR_NAME = "query-back";
var QUERY_BACK_SQL_ATTR_NAME = "query-back-sql";
var QUERY_BACK_SQL_ATTR_KEY = "queryBackSql";
var QUERY_BACK_WIN_DATA_OPT_KEY = "windowDataOptions";
var QUERY_BACK_DTG_DATA_OPT_KEY = "datagridDataOptions";
var QUERY_BACK_WINDOW_ID = "query-back-window";
var QUERY_BACK_INNER_TABLE_ID = "query-back-inner-table";

$(function() {
	document.write("<div id='" + QUERY_BACK_WINDOW_ID + "'></div>");
	$("input").each(findAndProcessQueryBackInput);
});

function findAndProcessQueryBackInput() {
	var o = $(this);
	if (o.attr(QUERY_BACK_ATTR_NAME)) {
		var confJson = $.parseJSON(o.attr(QUERY_BACK_ATTR_NAME).replace(/\'/g,
				"\""));
		if (confJson.enabled) {
			if (o.attr(QUERY_BACK_SQL_ATTR_NAME)) {
				confJson[QUERY_BACK_SQL_ATTR_KEY] = o
						.attr(QUERY_BACK_SQL_ATTR_NAME);
			}
			o.attr(QUERY_BACK_ATTR_NAME, JSON.stringify(confJson));
			o.click(queryBackInput_onClick);
		}
	}
}
function queryBackInput_onClick() {
	var o = $(this);
	var confJson = $.parseJSON(o.attr(QUERY_BACK_ATTR_NAME));
	var winJson = confJson[QUERY_BACK_WIN_DATA_OPT_KEY];
	var datagridJson = confJson[QUERY_BACK_DTG_DATA_OPT_KEY];
	// 处理居中显示。
	if (winJson["height"]) {
		var winHeight = parseFloat((winJson["height"] + "").replace(/px/g, ""));
		var docHeight = $("body").height();
		winJson["top"] = (docHeight / 2 - winHeight / 2);
	}
	if (winJson["width"]) {
		var winWidth = parseFloat((winJson["width"] + "").replace(/px/g, ""));
		var docWidth = $("body").width();
		winJson["left"] = (docWidth / 2 - winWidth / 2);
	}
	winJson.content = "<table id='" + QUERY_BACK_INNER_TABLE_ID + "'></table>";
	$("#" + QUERY_BACK_WINDOW_ID).window(winJson);
	$("#" + QUERY_BACK_WINDOW_ID).window("open");
	loadDatagrid(datagridJson, confJson[QUERY_BACK_SQL_ATTR_KEY]);
}

function loadDatagrid(json, sql) {
	$("#" + QUERY_BACK_INNER_TABLE_ID).datagrid(json);
	$("#" + QUERY_BACK_INNER_TABLE_ID).datagrid("options").url = contextPath
			+ "/common/queryBySqllistPage.do";
	if (sql) {
		$("#" + QUERY_BACK_INNER_TABLE_ID).datagrid("load");
	} else {
		$("#" + QUERY_BACK_INNER_TABLE_ID).datagrid("load");
	}
}