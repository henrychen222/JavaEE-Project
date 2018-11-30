<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>海事学院注册页</title>
<script src="<%=request.getContextPath()%>/common/bootstrap/js/bootstrap3.validation.js"></script>
<script src="<%=request.getContextPath()%>/common/assets/js/jquery-2.0.3.min.js"></script>
		
<script src="<%=request.getContextPath()%>/common/assets/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/common/assets/css/bootstrap.min.css" rel="stylesheet" />
</head>
  <body>
	<form class="form-horizontal"  action="#" role="form">
	  <div class="form-group">
        <label for="mail" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="mail" placeholder="xxxx@qq.com" check-type="mail required">
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="name" check-type="required" required-message="请填写你的大名。">
        </div>
      </div>

      <div class="form-group">
        <label for="pw1" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" id="pw1" check-type="required" minlength="6">
        </div>
      </div>

      <div class="form-group">
        <label for="pw2" class="col-sm-2 control-label">确认密码</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" id="pw2" check-type="required" minlength="6">
        </div>
      </div>  

      <div class="form-group">
        <label for="vercode" class="col-sm-2 control-label">验证码</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="vercode" check-type="number" range="2.2,5">
        </div>
      </div>  

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary col-sm-4">注册</button>
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <span id="error-text" style="color: #FF0000;"></span>
        </div>
      </div>
    </form>
  </body>
</html>
