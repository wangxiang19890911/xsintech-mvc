var records = [
			{"Name":"Alfreds Futterkiste","City":"Berlin","Country":"Germany"},
			{"Name":"Ana Trujillo Emparedados y helados","City":"México D.F.","Country":"Mexico"},
			{"Name":"Antonio Moreno Taquería","City":"México D.F.","Country":"Mexico"},
			{"Name":"Around the Horn","City":"London","Country":"UK"},
			{"Name":"B's Beverages","City":"London","Country":"UK"},
			{"Name":"Berglunds snabbköp","City":"Luleå","Country":"Sweden"},
			{"Name":"Blauer See Delikatessen","City":"Mannheim","Country":"Germany"},
			{"Name":"Blondel père et fils","City":"Strasbourg","Country":"France"},
			{"Name":"Bólido Comidas preparadas","City":"Madrid","Country":"Spain"},
			{"Name":"Bon app'","City":"Marseille","Country":"France"},
			{"Name":"Bottom-Dollar Marketse","City":"Tsawassen","Country":"Canada"},
			{"Name":"Cactus Comidas para llevar","City":"Buenos Aires","Country":"Argentina"},
			{"Name":"Centro comercial Moctezuma","City":"México D.F.","Country":"Mexico"},
			{"Name":"Chop-suey Chinese","City":"Bern","Country":"Switzerland"},
			{"Name":"Comércio Mineiro","City":"São Paulo","Country":"Brazil"}
			];

var app = angular.module('taxfree', []);
app.controller('customersCtrl', function($scope, $http) {
//    $http.get("/try/angularjs/data/Customers_JSON.php").then(function (result) {
        $scope.datas = records;
//    });
});


$(document).ready(function() {
	$('.labour').click(function() {
		location.href = contextPath + 'secure/labour';
	});
});
var page;
$(document).ready(function(){
	search();
})

//下一页
function next(){
    //得到当前选中项的页号
    var id=$("#pageNum option:selected").val();
    console.log(id);
    //计算下一页的页号
    var nextPage=parseInt(id)+1;
    console.log(nextPage);
    $(".selector").val("2");
    var op=document.getElementById("pageNum").options;
    console.log(op);
    //修改select的选中项
    var nextOption=op[nextPage-1];
    //调用查询方法
    nextOption.selected = true;
    //得到select中，下一页的option
    search();
}

//上一页
function previous(){

    //得到当前选中项的页号
    var id=$("#pageNum option:selected").val();
    //计算上一页的页号
    var previousPage=parseInt(id)-1;
    //得到select的option集合
    var list=document.getElementById("pageNum").options;
    //得到select中，上一页的option
    var previousOption=list[previousPage-1];
    //修改select的选中项
    previousOption.selected=true;
    //调用查询方法
    search();
}

function search(){
    //得到查询条件
    var searchString=$("#searchString").val();
    //得到每页显示条数
    var pageSize=$("#pageSize").val();
    //得到显示第几页
    var pageNum=$("#pageNum").val();
    //得到模糊查询条件
    var entryName=null;
    var AParty=null;
    var BParty=null;
    entryName = $("#entryName").val();
    if(""==entryName||null==entryName){
    	entryName="%";
    }else{
    	entryName=entryName+"%";
    }
    AParty = $("#AParty").val();
    if(""==AParty||null==AParty){
    	AParty="%";
    }else{
    	AParty=AParty+"%";
    }
    BParty = $("#BParty").val();
    if(""==BParty||null==BParty){
    	BParty="%";
    }else{
    	BParty=BParty+"%";
    }
    $.ajax({
        type: "POST",
        async: false,
        url: "judge",
        data:{"searchString":searchString,
                "pageSize":pageSize,
                "pageNum":pageNum,
                "entryName":entryName,
                "AParty":AParty,
                "BParty":BParty
            },
        dataType:"text",
        success: function (data) {
            //将json字符串转为json对象
            var pageEntity=JSON.parse(data);         
            //将除模板行的tbody删除，即删除之前的数据重新加载  
            $("tbody").eq(0).nextAll().remove();   
            //将获取到的数据动态的加载到table中  
            
            for (var i = 0; i < pageEntity.length; i++) {  
                //获取模板行，复制一行  
                var row = $("#tem").clone();  
                //给每一行赋值
                row.find("#check1").attr("name","new"+i);
                row.find("#studentId").text(pageEntity[i].name); //学号
                row.find("#studentName").text(pageEntity[i].aparty);   //学生姓名  
                row.find("#courseId").text(pageEntity[i].bparty);     //课程名称  
                //将新行添加到表格中  
                row.appendTo("#table");  
            } 
            
            //当前记录总数
            var pageNumCount=pageEntity.length;
            //当前记录开始数
            var pageNumBegin=(pageNum-1)*pageSize+1;
            //当前记录结束数
            var pageNumEnd=pageNum*pageSize
            //如果结束数大于记录总数，则等于记录总数
            if(pageNumEnd>pageNumCount){
                pageNumEnd=pageNumCount;
            }
            
            //得到总页数
            var pageCount;
            if(pageNumCount/pageSize==0){
                pageCount=pageNumCount/pageSize;
            }else{
                pageCount=Math.ceil(pageNumCount/pageSize);
            }
            
            //输出"显示第 1 至 10 项记录，共 57 项"
//            document.getElementById("DataTables_Table_0").innerHTML="显示第"+pageNumBegin.toString()
//                +" 至 "+pageNumEnd.toString()
//                +" 项记录，共 "+pageNumCount.toString()+" 项";

            //显示所有的页码数
//            var pageSelect =document.getElementById("page");
//            var pageOption="";
//            var flag;
            //删除select下所有的option，清除所有页码
//            document.getElementById("pageNum").options.length=0;
            for(var i=0;i<pageCount;i++){
                flag=(i+1).toString();
                console.log(flag)
                var option;
                //如果等于当前页码
                if(flag==pageNum){
                    //实例化一个option,则当前页码为选中状态
                    option=new Option(flag, flag, false, true);
                }else{
                    option=new Option(flag, flag, false, false);
                }
                //将option加入select中
                // jquery
               // $('#pageNum')
                document.getElementById("pageNum").options.add(option);
            }

            //如果总记录数小于5条，则不显示分页
            if((pageNumCount-1)<0){
                document.getElementById("bottomTool").style.display="none";
            }else{
                document.getElementById("bottomTool").style.display="";
            }

            /**给上一步下一步加颜色**/
            //判断是否只有一页
            if(pageCount==1){

                //如果只有一页，上一步，下一步都为灰色
                $("#previousPage").css("color","#AAA");//给上一步加灰色
                $("#nextPage").css("color","#AAA");//给下一步加灰色
            }else if(pageNum-1<1){
                //如果是首页,则给上一步加灰色，下一步变蓝
                $("#previousPage").css("color","#AAA");//给上一步加灰色
                $("#nextPage").css("color","#00F");//给下一步加蓝色
            }else if(pageNum==pageCount){
                //如果是尾页,则给上一步加蓝色，下一步灰色
                $("#previousPage").css("color","#00F");//给上一步标签加蓝色
                $("#nextPage").css("color","#AAA");//给下一步标签加灰色
            }else{
                //上一步为蓝色，下一步为绿色
                $("#previousPage").css("color","#00F");//给上一步加蓝色
                $("#nextPage").css("color","#00F");//给下一步加蓝色
            }
        }
    });
}

//搜索按钮绑定回车事件
document.onkeydown = function(event){
    if (event.keyCode == 13) {
        event.cancelBubble = true;
        event.returnValue = false;
        search();
    }
}   


function research() {
    //得到select的option集合
    var list=document.getElementById("pageNum").options;
    console.log(list);
    //得到select中，第一页的option
    var nextOption=list[0];
    //修改select的选中项
    nextOption.selected=true;
    //调用查询方法
    search();
}

//重置输入内容
function f1(){
	$("#entryName").val("");
	$("#data1").val("");
	$("#AParty").val("");
	$("#BParty").val("");
}
function f2(){
	search();
}


