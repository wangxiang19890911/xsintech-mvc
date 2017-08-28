<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script language="javascript">
var secs = 3; //倒计时的秒数 
var URL ;
function Load(url){
URL = url;
for(var i=secs;i>=0;i--) 
{ 
   window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000); 
} 
}
function doUpdate(num) 
{ 
document.getElementById('ShowDiv').innerHTML = '将在'+num+'秒后自动跳转到登录页面' ;
if(num == 0) { window.location = "login"; }
}
</script>
</head>
<body onload="Load('index.asp')">
	<div id="ShowDiv"></div>
</body>
</html>