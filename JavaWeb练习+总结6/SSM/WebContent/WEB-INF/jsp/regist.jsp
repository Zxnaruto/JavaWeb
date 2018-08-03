<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
注册页面
    <form action="${pageContext.request.contextPath }/user/addUser" method="post">
         用户名：<input type="text" name="username"/><br/>
         密码：<input type="password" name="password"/><br/>
         确认密码：<input type="password"/><br/>
    邮箱：<input type="text" name="email"/> <br/>
    <input type="submit" value="注册"/> 
    <a href="${pageContext.request.contextPath }/toLogin">已经注册，转去登录</a>  
    </form>
</body>
</html>