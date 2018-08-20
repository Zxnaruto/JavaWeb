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
    <table>
        <tr>
            <th>NinjaId</th>
            <th>NinjaName</th>
            <th>NinjaAge</th>
            <th>NinjaSex</th>
            <th>NinjaLevel</th>
        </tr>
        <c:forEach items="${ninjas}" var="ninja" varStatus="userindex">
            <tr>
                <td>${ninja.ninjaId }</td>
                <td>${ninja.ninjaName }</td>
                <td>${ninja.ninjaAge}</td>
                <td>${ninja.ninjaSex}</td>
                <td>${ninja.ninjaLevel}</td>
            </tr>
        </c:forEach>
    </table>    

    <div>
        <a href="?curpage=1">首页</a>
        <c:forEach begin="${page.lpage}" end="${page.rpage}" var="pageNum">
            <a href="?curpage=${pageNum }">${pageNum }</a>
        </c:forEach>
        <a href="?curpage=${page.last }">尾页</a>
    </div>
    
</body>
</html>