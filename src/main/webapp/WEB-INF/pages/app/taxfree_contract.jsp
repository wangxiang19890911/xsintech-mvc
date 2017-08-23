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
<body>

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
				<div
					class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 context">
					<div class="row">
						<h2 class="pull-left col-sm-12 col-md-12">劳动合同作成</h2>
						<div class="col-sm-14 col-md-14 context">
							<div class="form-inline">
								<div class="form-group col-sm-5 col-md-5">
									<label for="exampleInputEmail1" class="col-sm-5 col-md-5">项目名称:</label>
									<input type="email" class="form-control col-sm-4 col-md-4"
										id="a1"  name ="a1">
								</div>

								<div
									class="form-group  col-sm-5 col-md-5 col-sm-offset-1 col-md-offset-1 ">
									<label for="exampleInputEmail1" class="col-sm-5 col-md-5 ">制作时间:</label>
									<input type="email" class="form-control col-sm-4 col-md-4"
										id="a4" name ="a4">
								</div>
							</div>

							<div class="form-inline">
								<div class="form-group  col-sm-5 col-md-5">
									<label for="exampleInputEmail1" class="col-sm-5 col-md-5">委托方（甲方）:</label>
									<input type="email" class="form-control col-sm-4 col-md-4"
										id="a2" name ="a2">
								</div>

								<div
									class="form-group  col-sm-5 col-md-5 col-sm-offset-1 col-md-offset-1">
									<label for="exampleInputEmail1" class="col-sm-5 col-md-5">受托方（乙方）:</label>
									<input type="email" class="form-control col-sm-4 col-md-4"
										id="a3" name ="a3">
								</div>
							</div>
						</div>

						<button
							class="button button-glow button-border button-rounded button-primary"
							style="margin-top: 7px;" onclick="f2()" >搜索</button>
						<button
							class="button button-glow button-border button-rounded button-primary"
							style="margin-top: 7px;" onclick="f1()">重置</button>
					</div>

					<!-- 表格显示 -->
					<div class="row">
						<div class="col-md-12" style="margin-top: 20px;">
							<div class="panel panel-info">
								<table id="table"
									class="table table-striped table-bordered table-hover datatable">
									<thead>
										<tr>
											<th  style="background:#669999">项目名称</th>
											<th  style="background:#669999">甲方</th>
											<th  style="background:#669999">乙方</th>
										</tr>
									</thead>
									<tbody id="tem">
										<tr>
											<td id="studentId">项目名称</td>
											<td id="studentName">甲方</td>
											<td id="courseId">乙方</td>
										</tr>
									</tbody>
									<tbody>

									</tbody>
								</table>
							</div>
						</div>

						<div class="row">
							<a href="insert/into"
								class="pull-left button button-glow button-rounded button-raised button-primary button-small">新建</a>
							<a href="delete/de"
								class="pull-left button button-glow button-rounded button-raised button-caution button-small">删除</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- wang end -->

	<!-- 第2页 -->
	<div style="margin-left: 58%">
		<ul id="previousNext">
			<li onclick="previous()" class="prev disabled"><a
				id="previousPage" href="#">上一页</a></li>
			<select id="pageNum" onchange="search()" class='select'
				style="width: 50px; margin-right: 1px;"
				aria-controls="DataTables_Table_0" size="1"
				name="DataTables_Table_0_length">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<li class="next" onclick="next()"><a id="nextPage" href="#">下一页</a></li>
		</ul>
	</div>

	<div id="bottomTool" class="row-fluid" style="margin-left: 50%; margin-top:-2.2%">
		<div class="span6" style="width: 25%; margin-right: 10px;">
			<div class="dataTables_length" id="DataTables_Table_0_length">
				<label> 每页 <select id="pageSize" onchange="research()"
					aria-controls="DataTables_Table_0" size="1"
					name="DataTables_Table_0_length">
						<option selected="selected" value="10">10</option>
						<option value="25">25</option>
						<option value="50">50</option>
						<option value="100">100</option>
				</select> 条记录
				</label>
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
