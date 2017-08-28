<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div class = "col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
	<div style="padding: 100px 100px 10px;">
		<form class="bs-example bs-example-form"  action="${pageContext.request.contextPath}/updat"  method="post">
			<div class="input-group input-group-sm">
				<span class="input-group-addon">账号:</span>
				<input type="text" class="form-control" name="username" id="username"  readonly="readonly"  />
			</div><br />
			<div class="input-group input-group-sm">
				<span class="input-group-addon">密码:</span>
				<input type="text" class="form-control" name="password1" id="password1"   />
			</div><br />
		<div class="input-group input-group-sm">
			<span class="input-group-addon">确认密码:</span>
			<input type="text"  name="password" id="password" class="form-control" onblur="TheUserName1()"/><span id="sss" class="input-group-addon"></span>
		</div><br/>
		<script src="${pageContext.request.contextPath}/common/jquery/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/common/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/up.js"></script>
		<input type="submit" onclick="" value="确认" class="btn btn-success" />
		<input type="hidden" id="default_userId1"  name="default_userId1" value="${default_userId1 }" />
		</form>
		</div>
		</div>
</body>
</html>