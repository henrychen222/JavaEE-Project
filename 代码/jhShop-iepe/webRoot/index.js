function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
var contextPath = getContextPath();

/*
 * var btnMultiImage_onClick = function(e) { e.preventDefault(); e.bubbles =
 * false; $.layer({ type : 2, shadeClose : true, title : false, closeBtn : [ 0,
 * false ], shade : [ 0.8, "#000" ], border : [ 0 ], offset : [ "20px", "" ],
 * area : [ "655px", "517px" ], iframe : { src :
 * "http://192.168.102.76/upload.html" } }); return false; };
 */

$(function() {
	var div = $(".div-editor-wrap");
	div.height(div.height() - 175);
	var div2 = $(".div-upload-list");
	div2.width(div2.width() - 202);
	var o = $("#tar");
	window.editor = KindEditor.create(o, {});
	// $(".ke-icon-multiimage").parent().click(btnMultiImage_onClick);
	var divUploadCellHtml = $(".div-upload-cell").prop("outerHTML");
	$(".div-upload-cell").remove();
	var fileArr = [];
	var opt = {
		width : "168px",
		height : "34px",
		buttonImage : contextPath + "/images/btn-update-nor.png",
		swf : contextPath + "/common/uploadify/scripts/uploadify.swf",
		uploader : contextPath + "/upload/picture?vendor=vendor77",
		fileObjName : "file",
		auto : true,
		multi : true,
		onUploadStart : function(file) {
			var percentString = fileArr.length + "个文件已选择，已上传0.00%";
			fileArr.push(file);
		},
		onUploadProgress : function(file, bytesUploaded, bytesTotal,
				totalBytesUploaded, totalBytesTotal) {
			var percent = 100.0 * bytesUploaded / bytesTotal;
			var percentString = fileArr.length + "个文件已选择，已上传"
					+ percent.toFixed(2) + "%";
			$(".div-upload-status").html(percentString)
		},
		onUploadSuccess : function(file, data, response) {
			data = JSON.parse(data);
			if (data.success) {
				$(".div-upload-status").html(fileArr.length + "个文件已选择，上传已完成！");
				var o = $(divUploadCellHtml);
				$(".div-upload-list").append(o);
				for ( var k in data.content) {
					if (k.indexOf("200x150!") != -1) {
						var img = $("<img></img>").attr("src", data.content[k]);
						img.click(divImg_onClick);
						img.css("cursor", "pointer");
						img.appendTo(o);
					}
				}
				// 查找原图url。
				for ( var k in data.content) {
					var v = data.content[k];
					if (!/\_[0-9]+x[0-9]+/g.test(v)) {
						img.attr("origin-url", v);
						break;
					}
				}
			} else {
				alert(data);
			}
		}
	};
	setTimeout(function() {
		$("#file").uploadify(opt);
	}, 100);
});

// 供子页面调用。
window.appendImage = function(imgUrl) {
	window.editor.appendHtml("<img src='" + imgUrl + "' alt=''/>")
};

var divImg_onClick = function() {
	var img = $(this);
	if (parent && parent.window && parent.window.appendImage) {
		parent.window.appendImage(img.attr("origin-url"));
	}
};