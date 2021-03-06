<jsp:directive.page language='java'
	contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'
	session='true' />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Xsintech - 管理系统</title>

<!-- css -->
<link
	href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet">

</head>
<body ng-app="myApp" ng-controller="LoginController">

	<div class="container vertical-center">
		<div class="row" >
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1" >
				<div class="panel panel-default" >
					<div class="panel-heading" >
						<strong class=""> 登陆 </strong>
					</div>
					<p class="text-center"  style="font-size:14px; height:22px;"><span class=text-danger style="font-size:12px"> ${error } </span></p>
					<div class="panel-body" >
						<form action="${pageContext.request.contextPath}/getUser"  method="POST"  id="userForm" >
						<div class="form-group input-group" >
							<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id="username" name="userName"  class="form-control" placeholder="请输入用户名" />
						</div>
						<div class="form-group input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i>
							</span> <input type="password" id="password" name="passWord"  class="form-control" placeholder="请输入密码" />
						</div>
						<div class="form-group">
							<label class="checkbox-inline" style="margin-top: 8px;">
								<input id="chk_userId" type="checkbox" /> 记住账号
								<input type="hidden" id="flag"  name="flag" />
								<input type="hidden" id="default_userId"  name="default_userId" value="${default_userId }" />
							</label> 
							<span class="pull-right"> <input id="login" type="button"
								class="btn btn-primary" value="登陆" onclick="submitForm()" />
							</span>
							 <span class="pull-right"> <input id="login" type="button"
								class="btn btn-primary" value="注册" onclick="save()" />
							</span>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- js -->
	<script
		src="${pageContext.request.contextPath}/common/jquery/jquery-3.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/common/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<script
		src="${pageContext.request.contextPath}/js/login.js"></script>
	
</body>
</html>
