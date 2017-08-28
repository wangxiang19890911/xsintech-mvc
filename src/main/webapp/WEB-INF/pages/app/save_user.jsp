<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="IE=edge,chrome=1" />
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<h1 style="color:green; margin-left:45%">注册页面</h1>
	<div class = "col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
	<div style="padding: 100px 100px 10px;">
		<form class="bs-example bs-example-form"  action="${pageContext.request.contextPath}/save"  method="post">
			<div class="input-group input-group-sm">
				<span class="input-group-addon">账号:</span>
				<input type="text" class="form-control" name="userName" id="userName"  onblur="TheUserName()" /><span id="sss" class="input-group-addon"></span>
			</div><br />
			<div class="input-group input-group-sm">
			<span class="input-group-addon">姓氏:</span>
			<input type="text"  name="name" id="name" class="form-control" /><div style="display: none;" id="error_userName"></div>
		</div><br/>
		<div class="input-group input-group-sm">
			<span class="input-group-addon">名字:</span>
			<input type="text"  name="name1" id="name1" class="form-control" /><div style="display: none;" id="error_userName"></div>
		</div><br/>
				<div class="input-group input-group-sm">
					<span class="input-group-addon">性别:</span>
						<label>
							<input type="radio" name="gender" id="optionsRadios1" value="男"  checked="checked" />男
						</label>
				&nbsp;&nbsp;&nbsp;
						<label>
							<input type="radio" name="gender" id="optionsRadios2" value="女" />女
						</label>
				</div><br/>
		<div class="input-group input-group-sm">
			<span class="input-group-addon">年龄:</span>
			<input type="text"  name="old" id="old" class="form-control" /><div style="display: none;" id="error_userName"></div>
		</div><br/>
		<div class="input-group input-group-sm">
			<span class="input-group-addon">电话:</span>
			<input type="text"  name="photo" id="photo" class="form-control" /><div style="display: none;" id="error_userName"></div>
		</div><br/>
		<div class="input-group input-group-sm">
			<span class="input-group-addon">邮箱:</span>
			<input type="text"  name="email" id="email" class="form-control"  onblur="mile()" /><span id="yyy" class="input-group-addon"></span>
		</div><br/>
		<!-- 生成12位的随机密码  英文数组组合 -->
		<!-- 用 Java mail 将用户名和密码发送到邮箱中 -->
		<input type="submit" id="submit" value="确认" class="btn btn-success" />
		<input type="button" onclick="f1()" value="重置" class="btn btn-success" />
	</form>
	</div>
	</div>
	<script src="${pageContext.request.contextPath}/common/jquery/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/common/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/save.js"></script>
</body>

</html>