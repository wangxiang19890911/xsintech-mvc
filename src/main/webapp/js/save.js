var flag = true;   
document.getElementById("submit").disabled = "true";//阻止submit按钮
function TheUserName(){
	   		var name = $("#userName").val();
	   		if(name==""||name ==null){
	   			$("#sss").text("用户名不能为空");
	   			$("#sss").css("color","red");
	   			flag = false;
	   		}else{
	   			$("#sss").text("");
	   			flag = true;
	   		}
	   		if(flag){
	   			$.ajax({
	   	            type:"GET",
	   	            url:"saveOne",
	   	            dataType:"json",
	   	            data:"userName="+$("#userName").val(),
	   	            beforeSend:function(XMLHttpRequest){
	   	                    $("#sss").text("正在查询");
	   	                    //Pause(this,100000);
	   	           },success:function(data){
	   	        	   if (data.result) {
	   	        		$("#sss").text(data.message);
	   	        		$("#sss").css("color","green")
	   	        		document.getElementById("submit").removeAttribute("disabled");//开启submit
	   	        	   } else {
	   	        		$("#sss").text(data.message);
	   	        		$("#sss").css("color","red")
	   	        	   }
	   	           },
	   	          error:function(date){
	   	        	alert('后台出现异常');
	   	          }
	   	       });
	   		}
}
function mile(){
	var mile = $("#email").val();
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var flag = reg.test(mile);
	if(flag){
		$("#yyy").text("可以使用");
	}else{
		$("#yyy").text("请重新输入");
	}
}

function f1(){
	$("#userName").val("")
	$("#old").val("")
	$("#photo").val("")
	$("#email").val("")
}