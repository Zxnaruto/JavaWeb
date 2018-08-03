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
<title>Insert title here</title>
</head>
<body>
 
<%--  <% Employee s=new Employee();
	ArrayList<Employee> emps=new ArrayList<Employee>();
s=request.getAttribute("emp1"); %> --%>
  <form action="list1" method="post">
  <table border="1">
   <caption>雇员列表信息2</caption>
  <tr>
   <th>ID</th>
  <th>姓名</th>
   <th>年龄</th>
    <th>薪水</th>
  </tr>
      <%
  /* EmployeeDao调用dao.finAll()方法，即调用代码，然后创建对象接受它
  在通过get,方法调用它。
  就是以java代码获得数据库的内容，显示在页面上
  */
    EmployeeDao dao =new EmployeeDao();
    List<Employee> emps=dao.findALL();
    for(int i=0;i<emps.size();i++){
	 Employee emp= emps.get(i);
  %>
 <%} %>
  <c:forEach items="emp" var="list">
   <tr>

  <td>${list.getEmp_id()}</td>
      <td>${list.getEmp_name()}</td>
       <td>${list.getEmp_age()}</td>    
         <td>${list.getEmp_salary()}</td> 
  </tr>
  </c:forEach>
 
  
  </table>
  </form>
</body>
</html>