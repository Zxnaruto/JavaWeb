<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table>
       <tr>
          <th>商品编号</th>
          <th>商品名称</th>
          <th>商品价格</th>
          <th>操作</th>
       </tr>
       <c:forEach items="${plist}" var="p">
       <tr>
          <th>${p.pid }</th>
          <th>${p.pname }</th>
          <th>${p.price }</th>
          <th>
             <a href="${pageContext.request.contextPath }/product/findProductById/${p.pid}">修改</a>
          </th>
       </tr>
       </c:forEach>
    </table>
</body>
</html>