
function register() {
    //获取相关字段的值
    var loginName = $("input[name='loginName']").val();
    var userName = $("input[name='userName']").val();
    var password = $("input[name='password']").val();
    var confirmPassword = $("input[name='confirmPassword']").val();
    var email = $("input[name='email']").val();
    var mobile = $("input[name='mobile']").val();
    var identityCode = $("input[name='identityCode']").val();
    var address = $("input[name='address']").val();
    var sex = $("input[name='sex']:checked").val();
    //判断密码是否一致
    if(loginName==null || loginName==""){
        showMessage("用户名不能为空.");
        return;
    }

    if(loginName.length<2 || loginName>10){
        showMessage("登录名不能小于两个字符或者大于十个字符.");
        return;
    }

    if(userName==null || userName==""){
        showMessage("真实姓名不能为空.");
        return;
    }

    if(userName.length<2 || userName>10){
        showMessage("真实姓名不能小于两个字符或者大于十个字符.");
        return;
    }

    if (password != confirmPassword) {
        showMessage("两次输入的密码不一致.");
        return;
    }
    //判断密码是否为空
    if (password =="") {
        showMessage("密码不能为空");
        return;
    }
    //验证邮箱格式
    if(email!=null && email!="" && !checkMail(email)){
    	showMessage("邮箱格式不正确");
        return;
    }
    //验证邮箱格式
    if(mobile!=null && mobile!="" && !checkMobile(mobile)){
    	showMessage("手机格式不正确");
        return;
    }
     //验证邮箱格式
    if(identityCode!=null && identityCode!="" && !checkIdentityCode(identityCode)){
    	showMessage("身份证号格式不正确");
        return;
    }
    //执行异步 AJAX 请求
    //AJAX 是一种与服务器交换数据的技术，可以在不重新载入整个页面的情况下更新网页的一部分。
    $.ajax({
        url: contextPath + "/Register",
        method: "post",
        data: {//待发送 Key/value 参数。键值对
           /* action: "login",*/
            loginName: loginName,
            userName: userName,
            password: password,
            sex: sex,
            email: email,
            mobile: mobile,
            action: 'saveUserToDatabase',
            identityCode: identityCode,
            address: address
        },
        success: function (jsonStr) {//请求成功时执行该函数内容，jsonStr即为服务器返回的json对象
            var result = eval("(" + jsonStr + ")");//eval() 函数可计算某个字符串,RegisterServlet中返回的字符串
            if (result.status == 1) {//结果有值
                showMessage(result.message);//显示注册成功
                window.location.href = contextPath + "/Login?action=toLogin";//在当前页面打开登陆页面
            } else {
                showMessage(result.message);//显示注册失败
            }
        }
    })
}


function checkMail(mail) {
  var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if (filter.test(mail)) 
	  return true;
  else {
	 return false;}
}

function checkMobile(phone) {
  var filter  = /^\d{5,11}$/;
  if (filter.test(phone)) 
	  return true;
  else {
	 return false;
  }
}

function checkIdentityCode(identityCode) {
	  var filter  = /^\w{18}$/;
	  if (filter.test(identityCode)) 
		  return true;
	  else {
		 return false;
	  }
}
