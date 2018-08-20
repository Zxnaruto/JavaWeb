<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${userList}" var="user" begin="${(pageNos-1)*3 }"
        end="${pageNos*3-1}">
        <center>
            <div>${user.username}</div>
        </center>
        <center>
            <div>${user.password}</div>
        </center>
    </c:forEach>
    <center>
<a href="PageServletTest?pageNos=1" >首页</a>
<c:choose>
<c:when test="${pageNos==1}">
<a href="PageServletTest?pageNos=${pageNos}">上一页</a>
</c:when>
<c:otherwise>
<a href="PageServletTest?pageNos=${pageNos-1}">上一页</a>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${pageNos==countPage}">
<a href="PageServletTest?pageNos=${countPage }">下一页</a>
</c:when>
<c:otherwise>
<a href="PageServletTest?pageNos=${pageNos+1 }">下一页</a>
</c:otherwise>
</c:choose>
<a href="PageServletTest?pageNos=${countPage }">末页</a>
</center>
<form action="PageServletTest">
<h4 align="center">共${countPage}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="go">
</h4>
</form>
</body>
</html>