<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<script type="text/javascript">
  var contextPath = "${ctx}";
</script>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/shop.js"></script>
<script type="text/javascript">
window.onload=function(){
	var trs = $("#goods tr"); // 获取tbody下的所有行，id选择器
	var sum = 0;
	for (var i = 0; i < trs.length; i++) {
		var td = trs.eq(i).children().eq(4);// 获取每一行第5列的值
		var m = td.text();
		sum += parseFloat(m);
	}
	$("#total").text(sum);//得到计算结果，并显示在td中
}
</script>
<style type="text/css">
h1 {
	text-align: center;
}

table {
	margin: 0 auto;
	width: 60%;
	border: 2px solid #aaa;
	border-collapse: collapse;
}

table th, table td {
	border: 2px solid #aaa;
	padding: 5px;
}
</style>
</head>
<body>
<h1>动漫手办</h1>
	<table>
		<tr>
		    <th>Id</th>
			<th>商品</th>
			<th>单价</th>
			<th>品质</th>
			<th>库存</th>
			<th>好评率</th>
			<th>操作</th>
		</tr>
		<tr>
		    <td>1</td>
			<td>漩涡鸣人</td>
			<td>800</td>
			<td>高级</td>
			<td>893</td>
			<td>98%</td>
			<td align="center"><input type="button" value="加入购物车"
				onclick="add_shoppingcart(this);" /></td>
		</tr>
		<tr>
		    <td>2</td>
			<td>宇智波佐助</td>
			<td>800</td>
			<td>高级</td>
			<td>9028</td>
			<td>96%</td>
			<td align="center"><input type="button" value="加入购物车"
				onclick="add_shoppingcart(this);" /></td>
		</tr>
		<tr>
		  <td>3</td>
			<td>黑崎一护</td>
			<td>600</td>
			<td>中级</td>
			<td>672</td>
			<td>99%</td>
			<td align="center"><input type="button" value="加入购物车"
				onclick="add_shoppingcart(this);" /></td>
		</tr>
		<tr>
		  <td>4</td>
			<td>加藤惠</td>
			<td>1000</td>
			<td>高级</td>
			<td>8937</td>
			<td>95%</td>
			<td align="center"><input type="button" value="加入购物车"
				onclick="add_shoppingcart(this);" /></td>
		</tr>
		<tr>
		  <td>5</td>
			<td>黑猫</td>
			<td>700</td>
			<td>中级</td>
			<td>482</td>
			<td>100%</td>
			<td align="center"><input type="button" value="加入购物车"
				onclick="add_shoppingcart(this);" /></td>
		</tr>
	</table>
	<h1>购物车</h1>
	<table>
		<thead>
			<tr>
			    <th>Id</th>
				<th>商品</th>
				<th>单价(元)</th>
				<th>数量</th>
				<th>金额(元)</th>
				<th>删除</th>

      	</tr>
		</thead>
		<tbody id="goods">
		 <c:forEach items="${list}" var="good" >
		 <tr>
			    <td>${good.g_id }</td>
			    <td>${good.g_name }</td>
			    <td>${good.g_charge }</td>
			     <td align="center">
			     <input type="button" value="-" onclick="change(this, -1);"/> 
				<input type="text" size="3" readonly value=${good.g_num} /> 
				<input type="button" value="+" onclick="change(this, 1);"/> 
				</td>
			    <td>${good.g_num*good.g_charge }</td>
			    <td align="center"><input type="button" value="x" onclick="del(this);"/></td>
			    </tr>
			    </c:forEach>
		</tbody>
		<tfoot>
			<tr>
			   
			  
				<td colspan="4" align="right">总计</td>
				<td id="total"></td>
				<td></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>