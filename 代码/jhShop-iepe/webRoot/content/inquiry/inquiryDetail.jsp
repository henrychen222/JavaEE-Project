<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>俱合家具电商平台--询价详情页</title>
   	<link rel="stylesheet" type="text/css" href="${ctx}/content/inquiry/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/content/inquiry/inquiryDetail.css">
    <script src="${ctx}/common/js/libs/jquery-1.8.1.js" type="text/javascript"></script>
    <script src="${ctx}/content/inquiry/fileType.js" type="text/javascript"></script>
    <style>
		html { overflow-x:hidden; }
	</style>
</head>
<body>
    <!--中间部分-->
    <div class="center" style="/* width: 998px; */width: 978px;">
        <!--产品基本信息-->
        <div class="pro-infor-wrap" style="width: 100%">
            <div class="pro-infor-right">
                <h2 class="pro-name" title="${jhInquiry.title}">${jhInquiry.title}</h2>
                 <div class="pro-price-wrap">
                    <div class="pro-price-tg">
                        <span class="tit">询价内容:&nbsp;&nbsp;</span>
                        <span class="txt">${jhInquiry.detail}</span>
                    </div>
                </div>
                <div class="inquiry-company-info">
                	<span class="inquiry-company-title">咨询企业信息：</span>
                	<div class="inquiry-company-content">
                	<div class="line">
                		<div class="inqiry-company-person">
	                		<!-- <span class="tit">联系人&nbsp;:</span> -->
	                        <span class="txt" style="font-size: 14px">${jhInquiry.person}${jhInquiry.sex==1?"先生":"女士"}(${jhInquiry.phone})</span>
                		</div>
                		<div class="inqiry-company-phone">
	                		<!-- <span class="tit">联系电话&nbsp;:</span> 
	                        <span class="txt">${jhInquiry.phone}</span>-->
	                        <span class="txt">&nbsp</span>
                		</div> 
                	</div>
                	</div>
                </div>
                <c:if test="${!empty jhInquiry.type}">
	                <div class="pro-model">
	                    <div class="pro-model-tit">询价厂家类型：</div>
	                  	<ul>
	                  		<li class="pro-bid-tag">
		                  		<c:forEach items="${jhInquiry.type}" var="typeName" varStatus="s">
									<a href="javascript:void(0)">${typeName}</a>
								</c:forEach>
							</li>
						</ul>
	                </div>
                </c:if>
                <div class="pro-model">
                    <div class="pro-model-tit">询价类型：</div>
                  	<div class="pro-model-txt">${jhInquiry.ifTargeted eq 1?"全网":"定向"}</div>
                </div>
                
                <c:if test="${jhInquiry.ifTargeted eq 2}">
	                <div class="pro-model">
	                    <div class="pro-model-tit">询价单位：</div>
	                    <c:if test="${!empty jhInquiry.companys}">
	                	<c:forEach items="${jhInquiry.companys}" var="company" >
	                		<div class="pro-model-txt">${company.companyName}</div>
	                	</c:forEach>
	                	</c:if>
	                </div>
                </c:if>
                <c:if test="${!empty jhInquiry.jhAttachment}">
                <div class="pro-model">
                    <div class="pro-model-tit">附件：</div>
                  	<div class="pro-model-txt">
						<ul>
						<c:forEach items="${jhInquiry.jhAttachment}" var="file" varStatus="b">
						<li style="text-align: center;margin-right:25px;float:left;" >
							<a  target="_blank" href="${file.attachPath}">
							<img id="file_img_${file.id}" src=""/>
                         	<p style="white-space:nowrap; overflow:hidden; text-overflow:ellipsis;font-size: 12px;color:#a0a0a0">${file.attachName}</p>
                         	</a>
                         	<script type="text/javascript">
                         			var name = "${file.attachName}";
                         			$('#file_img_${file.id}').attr('src',getFliePath(name.substr(name.lastIndexOf('.'),name.lenght)));
                         	</script>
						</li>
						</c:forEach>
                       	</ul>
					</div>
                </div>
                </c:if>
            </div>
        </div><!--产品基本信息/-->
        <!--产品详细信息-->
    </div><!--中间部分/-->
</body>
</html>
