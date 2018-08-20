<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>VerificationTest</title>
 <script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");  
        img.src = "${ctx}/VerificationServlet?id="+Math.random();
    } 
</script>
</head>
<body>
<table>
<!-- 验证码 -->
<tr>
   <td nowrap width="437"></td>
    <td>
        <img id="img" src="${ctx}/VerificationServlet" />
        <a href='#' onclick="javascript:changeImg()" style="color:black;"><label style="color:black;">看不清？</label></a>
        <input type="text">
    </td>
 </tr>
</table>
</body>
</html>