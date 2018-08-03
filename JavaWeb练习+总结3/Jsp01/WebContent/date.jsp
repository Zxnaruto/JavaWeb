<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <!-- 导包 -->
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>date</title>
</head>
<body>
<!-- 显示当前日期 -->
<%
  Date date=new Date();/* 获取时间 */
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");/* 设置时间格式 */
%>
当前系统时间：<%=sdf.format(date) %><!--表达式显示  -->

</body>
</html>