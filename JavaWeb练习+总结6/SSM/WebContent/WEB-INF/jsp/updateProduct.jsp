<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    修改商品
    <form action="${pageContext.request.contextPath }/product/updateProduct" method="post">
         商品编号：<input type="text" name="pid" value="${p.pid }"/><br/>
         商品名称：<input type="text" name="pname" value="${p.pname }"/><br/>
         商品价格：<input type="text" name="price" value="${p.price }"/><br/>
    <input type="submit" value="提交"/> 
    </form>
</body>
</html>