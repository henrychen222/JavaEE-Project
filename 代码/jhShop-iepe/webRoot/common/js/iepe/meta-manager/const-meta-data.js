/**
 * Meta data manager
 * 
 * @author: wangyan
 */
(function($) {
	if (top == this) { // this page is in the top iframe.
		window.MetaManager = window.MetaManager || {
			metaData : {
				"1" : {
					"10001" : {
						"1" : {
							"VALUE_ID" : 1,
							"VALUE_TITLE" : "信息不全",
							"VALUE" : "1"
						},
						"2" : {
							"VALUE_ID" : 2,
							"VALUE_TITLE" : "材料不全",
							"VALUE" : "2"
						},
						"KEY_ID" : 10001,
						"KEY_NAME" : "refuseReason",
						"KEY_CHN_NAME" : "退回原因"
					},
					"TYPE_ID" : 1,
					"TYPE_NAME" : "页面元素"
				}
			}
		};
	} else { // this page is in the iframe, using the top meta manager.
		window.MetaManager = top.MetaManager;
	}
})(jQuery);