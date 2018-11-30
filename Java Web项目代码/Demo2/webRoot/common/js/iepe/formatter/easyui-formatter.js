/**
 * 使用本方法来创建一个依托于sql查询的转义格式化器， sql为查询语句，keyCol为该语句结果集中的作为键的那一列，
 * valueCol为作为值的那一列，用法示例： formatter:makeBySqlFormatter("select a,b from c",a,b)
 * 
 * @author wangyan
 */
function makeBySqlFormatter(sql, keyCol, valueCol) {
	var json = {};
	$.ajax({
		url : contextPath + "/common/queryBySql.do",
		type : "POST",
		async : false,
		data : {
			sql : sql
		},
		success : function(arr) {
			if (arr != "") {
				arr = eval(arr);
				for ( var i in arr) {
					var o = arr[i];
					json[o[keyCol]] = o[valueCol];
				}
			}
		}
	});
	var func = new Function("value", "rowData", "rowIndex", "json",
			"return keyValueFormatter(value, rowData, rowIndex, "
					+ JSON.stringify(json) + ");");
	return func;
}
/**
 * 使用本方法来创建一个根据自定义键值对来转义格式化器， keyValString为自定义的键值对，格式为半角逗号分割的，以半角等号为分隔符的键和值，
 * 如：1=是,2=否，则所以为1的值会被格式化为文字“是”。示例：
 * formatter:makeBySqlFormatter("1=未配置,2=小,3=中,4=大")
 */
function makeKeyValueFormatter(keyValString) {
	var json = {};
	var arr = keyValString.split(",");
	for ( var i in arr) {
		var pair = arr[i];
		var key = pair.split("=")[0];
		var val = pair.split("=")[1];
		json[key] = val;
	}
	var func = new Function("value", "rowData", "rowIndex", "json",
			"return keyValueFormatter(value, rowData, rowIndex, "
					+ JSON.stringify(json) + ");");
	return func;
}

function keyValueFormatter(value, rowData, rowIndex, json) {
	return json[value] ? json[value] : value;
}

function dateFormatter(value, rowData, rowIndex) {
	if (value != null && value != "") {
		return new Date(value).format("yyyy-MM-dd HH:mm:ss");
	}
}
