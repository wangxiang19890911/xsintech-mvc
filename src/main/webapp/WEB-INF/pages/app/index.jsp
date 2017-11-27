<jsp:directive.page language='java'
	contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'
	session='true' />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Xsintech - Dashboard</title>

<!-- css -->
<link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">

</head>
<body>

	<div class="container vertical-center">
		<div class="row" >
			<h1>dashboard</h1>
		</div>
	</div>

	<!-- path -->
	<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}" />

	<!-- js -->
	<script src="${pageContext.request.contextPath}/common/jquery/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/common/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/js/app/login.js"></script>
</body>
</html>
