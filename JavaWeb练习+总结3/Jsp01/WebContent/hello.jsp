<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hello.jsp</title>
</head>
<body>
<!-- 打印20行hello -->
<!-- 第一种方式：out.println out是内置对象，可以直接使用
       脚本方式：编写java代码 -->
<%
  for(int i=0;i<10;i++){
	  out.println("hello,jsp<br/>");
  }
%>
<!-- 第二种方式: <%="hello jsp" %> -->  
<!-- 表达式：方便在jsp中输出计算结果 -->
<%
  for(int i=0;i<10;i++){
%>
<%="hello,jsp<br/>" %>
<% }%>

</body>
</html>