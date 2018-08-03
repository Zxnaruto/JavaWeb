<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pers.zx.dao.EmployeeDao" %>
<%@ page import="pers.zx.entity.Employee" %>
<%@ page import="java.util.*" %>
<%@ page import="pers.zx.entity.EmployeeHttpServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
<style type="text/css">
.row1{
  background-color: red;
  
}
.row2{
  background-color: blue;
}
</style>
</head>
<body>
<table border="1px">
 <caption>雇员列表信息</caption>
 <tr>
 <th>ID</th>
  <th>姓名</th>
   <th>年龄</th>
    <th>薪水</th>
    <th>操作</th>
 </tr>
  <%
  /* EmployeeDao调用dao.finAll()方法，即调用代码，然后创建对象接受它
  在通过get,方法调用它。
  就是以java代码获得数据库的内容，显示在页面上
  */
    EmployeeDao dao =new EmployeeDao();
    List<Employee> emps=dao.findALL();
    request.getAttribute("emps");
    for(int i=0;i<emps.size();i++){
	 Employee emp= emps.get(i);
  %>
  <tr class="row<%=i%2+1%>">
  <td><%=emp.getEmp_id() %></td>
   <td> <%=emp.getEmp_name() %></td>
    <td><%=emp.getEmp_age() %></td>
     <td><%=emp.getEmp_salary() %></td>
     <!--这个id会被删除方法获取  -->
     <td><a href="delete.do?id=<%=emp.getEmp_id()%>" onclick="return confirm('是否确认删除<%=emp.getEmp_name()%>的信息？')">删除</a>
     &nbsp;
     <a href="load.do?id=<%=emp.getEmp_id()%>">修改</a>
     </td>
  </tr>
  <%} %>
 </table> 
 <!-- 页面跳转 -->
 <p>
 <input type="button" value="增加员工" onclick="location='add.jsp'"/><!-- 指定url -->
 </p>
<%--  <form action="list" method="post">
  <table border="1">
   <caption>雇员列表信息2</caption>
  <tr>
   <th>ID</th>
  <th>姓名</th>
   <th>年龄</th>
    <th>薪水</th>
  </tr>
  <c:forEach items="${list}" var="employee">
   <tr>
  <td>${employee.getEmp_id}</td>
     <td>${employee.getEmp_name}</td>
       <td>${employee.getEmp_age}</td>    
         <td>${employee.getEmp_salary}</td>
  </tr>
  </c:forEach>
  </table>
  </form> --%>
</body>
</html>