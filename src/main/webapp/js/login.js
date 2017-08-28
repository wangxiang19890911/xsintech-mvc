$(document).ready(function() {
	var default_user =  $('#username').val($('#default_userId').val());
});
function submitForm(){
	if($('input[id="chk_userId"]').prop("checked")){
		$("#flag").val(1);
	}else{
		$("#flag").val(0);
	}
	var username = $("#username").val();
	var password = $("#password").val();
	if(username == ""  ){
	   alert("用户名不能为空");
	   return;
	 }
	 if(password == ""){
	 alert("密码不能为空");
	   return;
	 }else{
	 $("#userForm").submit();
	 }
}
function save(){
	window.location.replace("doSave");
}






