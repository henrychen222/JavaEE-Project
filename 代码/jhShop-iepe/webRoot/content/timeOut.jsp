<!DOCTYPE html>
<html>

<head>
</head>

<body>
<script type="text/javascript">
	var o = self.name;
	if(o  == "workSpace"){
		top.parent.location.href= '${pageContext.request.contextPath}/login/index.do';  
	}else{
		top.location.href = '${pageContext.request.contextPath}/login/index.do';
	}
</script>
</body>
</html>