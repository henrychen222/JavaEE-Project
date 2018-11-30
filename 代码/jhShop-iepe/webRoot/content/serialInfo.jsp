<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="${ctx}/common/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/common/css/UIControl.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/common/css/order-manage.css">
</head>
<body>
    <!--中间部分-->
    <div class="center" style="width:1150px;overflow:auto;margin: 5px auto;">
        <div class="right-cont" style="float:left;width:2200px;min-height:0px;margin-left: 0px;">
            <div class="order-cont">
                <div class="tab-cont">
                    <div id="orderTabCont1">
                  	  <table class="orderlist">
                            <thead>
                                <tr>
                                <th colspan="3" class="checkbox">
                                <input type="checkbox" class="checkboxClass" onclick="checkAll(this)">
                                    <span>全选</span>
                                </th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>金额</th>
                                <th>状态</th>
                                <th>操作</th>
                                <th>其他操作</th>
                                <th style="width:270px">商品信息</th>
                                <th>所属供应商</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>金额</th>
                                <th>状态</th>
                                <th>操作</th>
                                <th>其他操作</th>
                            </tr>
                           </thead>
                           <thead>
                                <tr>
                                <th class="checkbox">
                                <input type="checkbox" class="checkboxClass" onclick="checkAll(this)">
                                    <span>全选</span>
                                </th>
                                <th style="width:270px">商品信息</th>
                                <th>所属供应商</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>金额</th>
                                <th>状态</th>
                                <th>操作</th>
                                <th>其他操作</th>
                                <th style="width:270px">商品信息</th>
                                <th>所属供应商</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>金额</th>
                                <th>状态</th>
                                <th>操作</th>
                                <th>其他操作</th>
                            </tr>
                           </thead>
                            <tbody>
	                            <tr class="pro-list-wrap"><td class="checkbox">
	                            	<input type="checkbox" class="checkboxClass" onclick="checkAll(this)">
	                                </td>
	                                <td style="width:270px">商品信息</td>
	                                <td>所属供应商</td>
	                                <td>价格</td>
	                                <td>数量</td>
	                                <td>金额</td>
	                                <td>状态</td>
	                                <td>操作</td>
	                                <td>其他操作</td>
	                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="orderTabCont2" style="display:none">

                    </div>
                    <div id="orderTabCont3" style="display:none">
                    </div>
                    <div id="orderTabCont4" style="display:none">
                    </div>
                </div>
            </div>
        </div>
        <!-- 分页 -->
		<%--<div class="page-nav" data-url="orderPage" data-cup="${currentPage }" data-num="10" data-pgc="${pageCount }"> --%>
        <div class="page-nav" data-url="orderPage" data-cup="5" data-num="10" data-pgc="9">
        </div>
    	</div><!--中间部分/-->
</body>
</html>
