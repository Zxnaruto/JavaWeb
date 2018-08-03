
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%
	   Object obj=request.getAttribute("productCategoryVoList");//初始为null然后跳转
	  if(obj==null){
		  /*//连续跳跃，原本是由web.xml的welcome来跳转到index.jsp，由于在初次跳转到index.jsp的时候
		   Object obj=request.getAttribute("productCategoryVoList");必定为空，
		   所以他会执行下面的语句自动跳转到/Home?action=index，同时执行servlet获取数据再次
		   显示pre/index.jsp。
		   如果直接访问Home路径，则不会显示商品列表，会跳转到per/index.jsp.(这是因为servlet中会有return pre/index)
		   此时不会显示产品信息。
		   */
	    response.sendRedirect(request.getContextPath()+"/Home?action=index");
	  }
  %>
  

  </body>
</html>
