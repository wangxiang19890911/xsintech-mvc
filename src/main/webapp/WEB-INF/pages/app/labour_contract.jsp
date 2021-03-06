<jsp:directive.page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8' session='true' />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Xsintech - 劳动合同作成</title>

<!-- css -->
<link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/xsintech.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-default" role="navigation" style="background-color: black;">
    <div class="container-fluid">
	    <div class="navbar-header col-md-2 col-sm-3">
	        <span class="navbar-brand" style="color: white;">Xsintech</span>
	    </div>
	    <div class="col-md-offset-8 col-sm-offset-7 col-md-1 col-sm-2">
	        <ul class="nav navbar-nav">
	            <li class="dropdown">
	                <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="background-color:black;">
	                    <span class="input-group-addon"><i class="glyphicon glyphicon-user">&nbsp;${default_userId1 }</i> </span>
	                </a>
	                <ul class="dropdown-menu">
	                    <li><a href="#">系统设定</a></li>
	                    <li><a href="#">个人设定</a></li>
	                    <li class="divider"></li>
	                    <li><a href="#">退出</a></li>
	                </ul>
	            </li>
	        </ul>
	    </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 collapse in sidebar">
                <ul id="left-menus" class="nav nav-pills nav-stacked">
                    <li><a href="taxfree	" class="taxfree">免税合同作成</a></li>
                    <li class="active"><a href="labour">劳动合同作成</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2">
                <div class="col-xs-12 col-sm-6 col-md-3" style="border:1px solid;">
                    bbb
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3" style="border:1px solid;">
                    bbb
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3" style="border:1px solid;">
                    bb
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3" style="border:1px solid;">
                    bb
                </div>
            </div>
        </div>
    </div>
</div>

<!-- js -->
<script src="${pageContext.request.contextPath}/common/jquery/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/common/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/common/angular/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/util.js"></script>
<script src="${pageContext.request.contextPath}/js/app/labour_contract.js"></script>
</body>
</html>
