<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../_head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
</head>
<body>
	<div class="middle">
		<div class="index_top">
			<ul>
				<li>
					<!-- 作业计划 --> <a href="javascript:setOperationData();"><img
						src="../common/images/common/zuoyejihua.png" alt=""
						id="selectOperation" /> </a>
					<div class="num" style=" display:none;" id="operationSum">0</div></li>
				<li>
					<!-- 现场维护资源 --> <a href="javascript:setResqualData();"><img
						src="../common/images/common/xcwh.png" alt="" id="selectResqual" />
				</a>
					<div class="num" style=" display:none;" id="resqualSum">0</div></li>
				<li>
					<!-- 工程随工 --> <a href="javascript:setProjectData();"><img
						src="../common/images/common/gcsg.png" alt="" id="selectProject" />
				</a>
					<div class="num" style=" display:none;" id="projectSum">0</div></li>
				<li>
					<!-- 指挥任务 --> <a href="javascript:setPlanData();"><img
						src="../common/images/common/zhrw.png" alt="" id="selectPlan" />
				</a>
					<div class="num" style=" display:none;" id="planSum">0</div></li>
				<li>
					<!-- 障碍处理 --> <a href="javascript:setBalkData();"><img
						src="../common/images/common/zacl.png" alt="" id="balkhandle" />
				</a>
					<div class="num" style=" display:none;" id="balkSum">0</div></li>
				<li>
					<!-- 设备退网与投诉 --> <a href="javascript:setEquData();"><img
						src="../common/images/common/sbdw.png" alt="" id="retrnetWork" />
				</a>
					<div class="num" style=" display:none;" id="retrnetSum">0</div></li>
				<li style="display:none;">
					<!-- 局数据 --> <a href="javascript:setLocationData();"><img
						src="../common/images/common/jsj2.png" alt="" /> </a>
					<div class="num" style=" display:none;">0</div></li>
				<li>
					<!-- 风险操作 --> <a href="javascript:setOperaRiskData();"><img
						src="../common/images/common/wlfx.png" alt="" id="operaRisk" /> </a>
					<div class="num" style=" display:none;" id="operaRiskSum">0</div></li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="daibsw">
			<div class="daban">
				<div class="hometitle">
					<div class="title">
						<span id="moreTask"><a href="">更多&gt&gt</a> </span> <img
							src="../common/images/common/biaoshi.png" alt=""
							align='absmiddle' id="moreTaskImg" /> 待办任务
					</div>
				</div>
				<!-- 待办任务展示 -->
				<ul id="addTask">

				</ul>
			</div>
			<div class="yiban">
				<div class="hometitle">
					<div class="title">
						<span id="moreFinshed"><a href="">更多&gt&gt</a> </span> <img
							src="../common/images/common/biaoshi.png" alt=""
							align='absmiddle' id="moreFinishedImg" /> 已办任务
					</div>
				</div>
				<!-- 已办任务展示 -->
				<ul id="addFinished">

				</ul>
			</div>
		</div>
		<div class="clear"></div>
		<div class="messagezx">
			<div class="hometitle">
				<div class="title">
					<img src="../common/images/common/xiaoxi.png" alt=""
						align='absmiddle' /> 消息中心
				</div>
			</div>
			<ul>
				<li style="display:none;"><small>今日：</small> <span
					id="today_workItems" style="color:red">0</span> 条待办</li>
				<li style="display:none;"><small>本月：</small> <span
					id="mounth_finished_cnt"></span>
				</li>
				<li><small>版本更新：</small> 6月25号版本升级，现已全面优化系统UI。</li>
				<li><small>系统公告：</small>
					集约化运维平台使用过程中如遇到问题，可联系02552459617，或加QQ群311363223</li>
				<input type="hidden" id="localAddrPort"
					value="本服务器是<%=request.getLocalAddr()%>:<%=request.getLocalPort()%>" />
			</ul>
		</div>

		<!-- 用来展示转派功能 -->
		<div id="newWindow"
			style="width: 100%;height: 100%;background:#F4F7FA;font-size: 12px;">
		</div>
	</div>
</body>
</html>