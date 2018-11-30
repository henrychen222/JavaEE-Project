<%@ page pageEncoding="utf-8" %>
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<link href="<%=request.getContextPath()%>/common/easyui-themes/bootstrap/easyui.css" rel="stylesheet"  type="text/css"></link>
<link href="<%=request.getContextPath()%>/common/easyui-themes/icon.css" rel="stylesheet"  type="text/css"></link>
<!-- lib js -->
<script src="<%=request.getContextPath()%>/common/js/libs/jquery-1.11.1.min.js" type="text/javascript"></script>
<!-- restore the deprecated functions in jquery 1.11.1 -->
<script src="<%=request.getContextPath()%>/common/js/libs/jquery-migrate-1.1.1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/jquery.easyui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/easyui-lang-zh_CN.js" type="text/javascript"></script>
<!-- iepe js -->
<script src="<%=request.getContextPath()%>/common/js/iepe/formatter/easyui-formatter.js" type="text/javascript"></script>
<!-- <script src="<%=request.getContextPath()%>/common/js/iepe/component/query-back.js" type="text/javascript"></script> -->
<script src="<%=request.getContextPath()%>/common/js/iepe/meta-manager/meta-manager.js" type="text/javascript"></script>
<!--<script src="<%=request.getContextPath()%>/common/js/iepe/meta-manager/const-meta-data.js" type="text/javascript"></script>-->
<script src="<%=request.getContextPath()%>/common/js/iepe/component/iepe-controls.js" type="text/javascript"></script>

<!-- report js -->
<script src="<%=request.getContextPath()%>/common/js/libs/jquery.blockUI.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/export.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/common/css/dateExtend.css">
<link rel="stylesheet" type="text/css" href="${ctx}/common/css/iepe-table.css">
<script src="<%=request.getContextPath()%>/common/js/jquery-datebox-extend.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/dateUtil.js" type="text/javascript"></script>
<script type="text/javascript">
var $w=window.parent;

$.extend($.fn.validatebox.defaults.rules, {
    mobile: {
        validator: function(value, param){
        	var reg=/^([0-9]{3,4}-[0-9]{8,8})|(1[0-9]{10})$/;
            return reg.test(value);
        },
        message: '请正确输入联系格式,比如025-88888888/13511111111'
    }
});
</script>