var defauleName = "请输入用户名";
var url = window.contextPath + "/login/login.do?";
$(function() {
	var loginbtn = $(".loginbtu");
	$(document).keypress(function(e) {
		if (e.which == 13) {
			loginbtn.click();
		}
	});
	loginbtn.click(function() {
		var userAccount = $("#id").val();
		var pwd = $("#password").val();
		if (!userAccount) {
			// $.messager.alert("提示", "请输入用户名");
			$("#error  font").text("请输入用户名");
			return;
		}
		if (!pwd) {
			// $.messager.alert("提示", "请输入密码");
			$("#error font").text("请输入密码");
			return;
		}
		$("#myForm").submit();
	});

	$("#uname").click(function() {
		$(this).hide();
		$("#id").focus();
	});
	$("#upsw").click(function() {
		$(this).hide();
		$("#password").focus();
	});

});

$(function() {
	$("#focus .input_txt").each(function() {
		var thisVal = $(this).val();
		// 判断文本框的值是否为空，有值的情况就隐藏提示语，没有值就显示
		if (thisVal != "") {
			$(this).siblings("span").hide();
		} else {
			$(this).siblings("span").show();
		}
		// 聚焦型输入框验证
		$(this).focus(function() {
			$(this).siblings("span").hide();
		}).blur(function() {
			var val = $(this).val();
			if (val != "") {
				$(this).siblings("span").hide();
			} else {
				$(this).siblings("span").show();
			}
		});
	});
	$("#keydown .input_txt").each(function() {
		var thisVal = $(this).val();
		// 判断文本框的值是否为空，有值的情况就隐藏提示语，没有值就显示
		if (thisVal != "") {
			$(this).siblings("span").hide();
		} else {
			$(this).siblings("span").show();
		}
		$(this).keyup(function() {
			var val = $(this).val();
			$(this).siblings("span").hide();
		}).blur(function() {
			var val = $(this).val();
			if (val != "") {
				$(this).siblings("span").hide();
			} else {
				$(this).siblings("span").show();
			}
		});
	});
});