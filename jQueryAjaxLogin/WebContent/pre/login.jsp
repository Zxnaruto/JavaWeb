<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<script type="text/javascript">
var contextPath="${ctx}";
</script>
<script type="text/javascript" src="${ctx}/common/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="${ctx}/js/login.js"></script>
 <script type="text/javascript">
function changeImg(){
    var img = document.getElementById("img"); 
    //var img=$("#img").val();
    img.src = "${ctx}/VerSerlvet?id="+Math.random();
} 
</script> 
</head>
<body>
<form>

登录名：
<input type="text" name="name" id="name" value=""/><br/>
密码：
<input type="password" name="password" id="password" value=""/><br/>
验证码：
<input type="text" name="verificate" id="verificate" value=""/> 
<img id="img" src="${ctx}/VerSerlvet" />
 <!-- <input type="button" value="看不清？" onclick="changeImg();"> -->
  <a href='#' onclick="javascript:changeImg();">看不清？</a>
<br/>
<input type="button" value="登陆" onclick="login();" >
</form>
</body>
</html>