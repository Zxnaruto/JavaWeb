<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pers.zx.entity.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
<%
Employee emp=(Employee)request.getAttribute("emp");
%>
<form action="update.do?id=<%=emp.getEmp_id()%>">
<table border="1">
				<tr>
				<td>编号</td>				
				<td><input type="text" name="id" value="<%=emp.getEmp_id()%>"/></td>
				</tr>
				<tr>
				<td>姓名</td>				
				<td><input type="text" name="name" value="<%=emp.getEmp_name()%>"/></td>
				</tr>
				<tr>
				<td>年龄</td>				
				<td><input type="text" name="age" value="<%=emp.getEmp_age()%>"/></td>
				</tr>
				<tr>
				<td>薪水</td>				
				<td><input type="text" name="salary" value="<%=emp.getEmp_salary()%>"/></td>
				</tr>
				
				</table>
				<input type="button" value="修改"/>
</form>
</body>
</html>