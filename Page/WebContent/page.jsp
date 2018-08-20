<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分页</title>
</head>
<body>
<form action="PageServlet">
<center>
 <table>
        <tr>
            <th>NinjaId</th>
            <th>NinjaName</th>
            <th>NinjaAge</th>
            <th>NinjaSex</th>
            <th>NinjaLevel</th>
        </tr>
<c:forEach items="${NinjaList}" var="ninja" >
            <tr>
                <td>${ninja.ninjaId }</td>
                <td>${ninja.ninjaName }</td>
                <td>${ninja.ninjaAge}</td>
                <td>${ninja.ninjaSex}</td>
                <td>${ninja.ninjaLevel}</td>
            </tr>
       
    </c:forEach>
    
 </table>   
</center>
    <center>
<a href="PageServlet?pageNos=1" >首页</a>
<c:choose>
<c:when test="${pageNos==1}">
<a href="PageServlet?pageNos=${pageNos}">上一页</a>
</c:when>
<c:otherwise>
<a href="PageServlet?pageNos=${pageNos-1}">上一页</a>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${pageNos==countPage}">
<a href="PageServlet?pageNos=${countPage }">下一页</a>
</c:when>
<c:otherwise>
<a href="PageServlet?pageNos=${pageNos+1 }">下一页</a>
</c:otherwise>
</c:choose>
<a href="PageServlet?pageNos=${countPage }">末页</a>
</center>

<h4 align="center">共${countPage}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="go">
</h4>
</form>
</body>
</html>