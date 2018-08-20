/*function check(){
	var loginname=${"#name"}.val();
	var password=${"#password"}.val();
	$.ajax({
		url:contextPath+"/Login",
		method:"post",
		data:{
			loginname:name,
			password:password,
			action:"check"
		},
		success:function(jsonStr){
			var result=eval("("+jsonStr+")");
			if(result.status==1){
				window.location.href="loginsuccess.jsp";
			}else{
				showMessage(result.message);
			}
		}
	
	})
}*/
/*function check(){
    var name=$("#name").val();//通过id获取数据
    var password=$("#password").val();
    $.ajax({
        url:contextPath+"/Login",
        method:"post",
        data:{name:name,password:password,action:'check'},
        success:function(jsonStr){
           alert("成功");
           window.location.href=contextPath+"/pre/loginsuccess.jsp";
        },
        error:function(data){
        	alert("失败");
        },
    });
}*/


//登录的方法
function login(){
    var name=$("#name").val();//通过id获取数据
    var password=$("#password").val();
    var verificate=$("#verificate").val();//获取所输入的验证码
    $.ajax({
        url:contextPath+"/Login",
        method:"post",
        data:{action:"check",name:name,password:password,verificate:verificate},
        success:function(jsonStr){
        	 var result = eval("("+jsonStr+")");
            if(result.status==1){
            	alert(result.data);
                window.location.href=contextPath+"/pre/loginsuccess.jsp";
            }else{
            	alert(result.message);
            }
        }
    })
}
/*function changeImg(){
    //var img = document.getElementById("img"); 
    //var img=$("#img").val();
    //img.src = "${ctx}/Login?action=verification?id="+Math.random();
    $.ajax({
        url:contextPath+"/VerSerlvet?id="+Math.random(),
        method:"get",
        data:{action:"service"},
  
    })
}*/ 

/*function changeImg(){
    var img = document.getElementById("img"); 
    //var img=$("#img").val();
    img.src = "${ctx}/VerSerlvet?id="+Math.random();
} 
*/