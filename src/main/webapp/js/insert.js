var now = new Date(); 
date.value=(now.getYear()+1900) + "-"+ (now.getMonth()+1)+"-"+now.getDate(); 
document.getElementById("submit").disabled = "true";//阻止submit按钮

var flag = true;   
function f2(){
	   		var name = $("#name").val();
	   		if(name==""||name ==null){
	   			$("#sss").text("合同不能为空");
	   			$("#sss").css("color","red");
	   			flag = false;
	   		}else{
	   			$("#sss").text("");
	   			flag = true;
	   		}
	   		if(flag){
	   			$.ajax({
	   	            type:"GET",
	   	            url:"contract",
	   	            dataType:"json",
	   	            data:"name="+$("#name").val(),
	   	            beforeSend:function(XMLHttpRequest){
	   	                    $("#sss").text("正在查询");
	   	                    //Pause(this,100000);
	   	           },success:function(data){
	   	        	   if (data.result) {
	   	        		$("#sss").text(data.message);
	   	        		$("#sss").css("color","green");
	   	        		document.getElementById("submit").removeAttribute("disabled");//开启submit
	   	        	   } else {
	   	        		$("#sss").text(data.message);
	   	        		$("#sss").css("color","red");
	   	        	   }
	   	           },
	   	          error:function(date){
	   	        	alert('后台出现异常');
	   	        	$("#submit").click(function(){
	   		            $("input").blur();
	   		            if(flag){
	   		                $("#submit").submit();
	   		            }
	   		    });
	   	          }
	   	       });
	   		}
}