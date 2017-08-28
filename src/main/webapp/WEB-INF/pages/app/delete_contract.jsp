<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/xsintech.css"rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/login.css"	rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/buttons.css"	rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="background-color: black;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="navbar-header col-md-2 col-sm-3">
					<span class="navbar-brand" style="color: white;">Xsintech</span>
				</div>
				<div class="col-md-offset-8 col-sm-offset-7 col-md-1 col-sm-2">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" style="background-color: black;"> <span
								class="input-group-addon"><i
									class="glyphicon glyphicon-user">&nbsp;${default_userId1 }</i>
							</span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="settings">个人设定</a></li>
								<li class="divider"></li>
								<li><a href="#">用户管理</a></li>
								<li class="divider"></li>
								<li><a href="signOut">退出</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!-- wang start -->
	<div class="container-fluid">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 collapse in sidebar">
					<ul id="left-menus" class="nav nav-pills nav-stacked">
						<li class="active"><a href="#">免税合同作成</a></li>
						<li><a href="#" class="abour">劳动合同作成</a></li>
					</ul>
				</div>
				<div class = "col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
					<div style="padding: 100px 100px 10px;">
						<form class="bs-example bs-example-form"   action="${pageContext.request.contextPath}/delete"  method="post" id="form1">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">项目名称:</span>
								<input type="text" class="form-control" name="name" id="name" onblur="f2()"  /><span id="sss" class="input-group-addon"></span>
							</div><br />
								<input type="submit" id="submit" name="submit" value="确认删除" class="btn btn-success"></input>
						</form>
					</div>
				</div>	
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/common/jquery/jquery-3.2.1.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/delete.js"></script>
</body>
</html>