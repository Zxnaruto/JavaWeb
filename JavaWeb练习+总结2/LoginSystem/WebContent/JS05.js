function pd(){
	var password_obj=document.getElementById("psd");//获取对象
	var admin_obj=document.getElementById("admin");
    var a_result_obj=document.getElementById("a_result");
    var p_result_obj=document.getElementById("p_result");
   
    var Password=password_obj.value;//获取值
    var Admin=admin_obj.value;
    
    //获取长度
    var p_len=Password.length;
    var a_len=Admin.length;
    
    if(Admin!=null){
    	a_result_obj.innerHTML="";
    }
    if(Password!=null){
    	p_result_obj.innerHTML="";
    }
    
    if(Admin==""&&Password==""){
    	p_result_obj.innerHTML="用户名和密码不能为空！！！"
    }else if(Admin==""){
    	a_result_obj.innerHTML="用户名不能为空！！！";
    }else if(Password==""){
    	p_result_obj.innerHTML="密码不可以为空！！！";
    }else if((a_len<3||a_len>20)&&(p_len<6||p_len>20)){
       p_result_obj.innerHTML="密码和用户名长度不对，用户名(3-20)密码(6-20)";
    }else if(a_len<3||a_len>20){
    	a_result_obj.innerHTML="用户名长度必须为3-20位之间任意字符！！！";
    }else if(p_len<6||p_len>20){
    	p_result_obj.innerHTML="密码长度必须为6-20位之间任意字符";
    }else{
    	p_result_obj.innerHTML="登陆成功！！！";
    }
	
	
}
