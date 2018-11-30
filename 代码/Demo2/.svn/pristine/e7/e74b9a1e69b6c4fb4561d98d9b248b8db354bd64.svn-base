/**
 * Meta data manager
 * 
 * @author: wangyan
 */
(function($) {
	if (top == this) { // this page is in the top iframe.
		window.MetaManager = window.MetaManager || {
			metaData : {}
		};
		var pathName = document.location.pathname;
		var index = pathName.substr(1).indexOf("/");
		var contextPath = pathName.substr(0, index + 1);
		$
				.ajax({
					url : contextPath + "/meta/getMetaData.do",
					dataType : "json",
					success : function(arr) {
						var metaData = window.MetaManager.metaData;
						for ( var i in arr) {
							var json = arr[i];
							metaData[json.TYPE_ID] = metaData[json.TYPE_ID]
									|| {
										TYPE_ID : json.TYPE_ID,
										TYPE_NAME : json.TYPE_NAME
									};
							metaData[json.TYPE_ID][json.KEY_ID] = metaData[json.TYPE_ID][json.KEY_ID]
									|| {
										KEY_ID : json.KEY_ID,
										KEY_NAME : json.KEY_NAME,
										KEY_CHN_NAME : json.KEY_CHN_NAME
									};
							metaData[json.TYPE_ID][json.KEY_ID][json.VALUE_ID] = metaData[json.TYPE_ID][json.KEY_ID][json.VALUE_ID]
									|| {
										VALUE_ID : json.VALUE_ID,
										VALUE_TITLE : json.VALUE_TITLE,
										VALUE : json.VALUE
									};
						}
					}
				});
	} else { // this page is in the iframe, using the top meta manager.
		window.MetaManager = top.MetaManager;
	}
})(jQuery);
