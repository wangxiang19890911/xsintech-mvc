function TheUserName1(){
	var flag = true;   
	var name = $("#password").val();
	if(name==""||name ==null){
		  $("#sss").text("用户名不能为空");
		  $("#sss").css("color","red");
		   		flag = false;
		  }else{
		   		$("#sss").text("");
		   		flag = true;
		   }
	var a = $("#password1").val();
	var b = $("#password").val();
	if(flag){
		if(a!=b){
			$("#sss").text("错误");
			$("#sss").css("color","red");
		}else{
			$("#sss").text("正确")
			$("#sss").css("color","greed");
		}
	}
}
$(document).ready(function() {
	var default_user =  $('#username').val($('#default_userId1').val());
});