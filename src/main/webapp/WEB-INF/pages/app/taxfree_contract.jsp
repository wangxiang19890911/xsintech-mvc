<jsp:directive.page language='java'
	contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'
	session='true' />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<%@ page isELIgnored="false"%>
<title>Xsintech - 免税合同作成</title>

<!-- css -->
<link
	href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/buttons.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/xsintech.css"
	rel="stylesheet">

</head>
<body ng-controller="SecurityController">

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="background-color: black;">
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
								<li><a href="#">个人设定</a></li>
								<li class="divider"></li>
								<li><a href="#">用户管理</a></li>
								<li class="divider"></li>
								<li><a href="#">退出</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 collapse in sidebar">
					<ul id="left-menus" class="nav nav-pills nav-stacked">
						<li class="active"><a href="#">免税合同作成</a></li>
						<li><a href="#" class="labour">劳动合同作成</a></li>
					</ul>
				</div>
				<div
					class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 context">
					<div style="margin: 50px;">
						项目名称:<input type="text" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						委托方（甲方）:<input type="text" /><br /> 制作时间:<input type="text" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						受托方（乙方）:<input type="text" /> <input type="button" value="搜索"
							class="btn btn-primary" />
					</div>
					<div class="row">
						<h2 class="pull-left">劳动合同作成</h2>
					</div>
					<div class="row">
						<a href="#"
							class="pull-left button button-glow button-rounded button-raised button-primary button-small">新建</a>
						<a href="#"
							class="pull-left button button-glow button-rounded button-raised button-caution button-small">删除</a>
					</div>
					<div class="row" ng-app="taxfree" ng-controller="customersCtrl">
						<table class="table" >
							<tr>
								<th>name</th>
								<th>City</th>
								<th>Country</th>
							</tr>
							<tr id = "tr">
                   <td></td>  
                   <td></td>  
                   <td></td>      
							</tr>
							<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
						</table>
						<div >
							<input type="button" id="pix" name="pix" value="上一页"
								style="margin-top: -5px;" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							 <input type="button" id="next" name="next" value="下一页" />
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<p></p><p></p><p></p>
						</div>
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
		src="${pageContext.request.contextPath}/common/angular/angular.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/util.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/app/taxfree_contract.js"></script>
</body>
</html>
