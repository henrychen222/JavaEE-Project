<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${ctx==null }">
	<c:set scope="application" value="<%=request.getContextPath()%>" var="ctx"></c:set>
</c:if>
<!-- css -->
<!--<link href="<%=request.getContextPath()%>/common/css/css/css.css" rel="stylesheet"  type="text/css"></link>-->
<link href="<%=request.getContextPath()%>/common/easyui-themes/bootstrap/easyui.css" rel="stylesheet"  type="text/css"></link>
<link href="<%=request.getContextPath()%>/common/easyui-themes/color.css" rel="stylesheet"  type="text/css"></link>
<link href="<%=request.getContextPath()%>/common/easyui-themes/icon.css" rel="stylesheet"  type="text/css"></link>
<link href="<%=request.getContextPath()%>/common/css/style.css" rel="stylesheet"  type="text/css"></link>

<!--link href="<%=request.getContextPath()%>/common/css/style2.css" rel="stylesheet"  type="text/css"></link>-->

<link href="<%=request.getContextPath()%>/common/css/ymPrompt.css" rel="stylesheet"  type="text/css"></link>
<link href="<%=request.getContextPath()%>/common/css/easyui-override.css" rel="stylesheet"  type="text/css"></link>
<link href="<%=request.getContextPath()%>/common/uploadify/css/uploadify.css" rel="stylesheet"  type="text/css"></link>

<!-- lib js -->
<script src="<%=request.getContextPath()%>/common/js/libs/jquery-1.8.1.js" type="text/javascript"></script>
<!-- restore the deprecated functions in jquery 1.11.1 -->
<script src="<%=request.getContextPath()%>/common/js/libs/jquery-migrate-1.1.1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/jquery.easyui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/easyui-panel-border-out-correct.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/jquery-ztree-2.5.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/js.util.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/json2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/ymPrompt.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/StringUtil.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/jq_pngAlpha.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/libs/carousel.js" type="text/javascript"></script>
<!-- <script src="<%=request.getContextPath()%>/common/js/js.easyui.extend.js" type="text/javascript"></script> -->

<!-- common js -->
<script src="<%=request.getContextPath()%>/common/js/libs/extends.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/ajaxFormSubmit.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/js/common.js" type="text/javascript"></script>

<!-- iepe js -->
<script src="<%=request.getContextPath()%>/common/js/iepe/formatter/easyui-formatter.js" type="text/javascript"></script>
<!-- <script src="<%=request.getContextPath()%>/common/js/iepe/component/query-back.js" type="text/javascript"></script> -->
<script src="<%=request.getContextPath()%>/common/js/iepe/meta-manager/meta-manager.js" type="text/javascript"></script>
<!--<script src="<%=request.getContextPath()%>/common/js/iepe/meta-manager/const-meta-data.js" type="text/javascript"></script>-->
<script src="<%=request.getContextPath()%>/common/js/iepe/component/iepe-controls.js" type="text/javascript"></script>

<!-- kindeditor -->
<script src="<%=request.getContextPath()%>/common/kindeditor-4.1.10/kindeditor-all-min.js" type="text/javascript"></script>

<!-- upload -->
<script src="<%=request.getContextPath()%>/common/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/common/js/validate.js" type="text/javascript"></script>


<!-- custom js -->
<script type="text/javascript">
$(function(){
	$(".datebox :text").attr("readonly","readonly");
});
</script>
