<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
订单列表<br />
<table border="1px" id="tab">
<tr>
<td>序号</td>
<td>订单id名称</td>
<td>订单名称</td>
<td>订单简介 </td>
<td>订单总价</td>
<td>订单的状态</td>
<td>支付单号</td>
<td colspan='3'>操作</td>
</tr>
<c:forEach items="${list }" var="order">
<tr>
<td>${order.id }</td>
<td>${order.orderId }</td>
<td>${order.orderName }</td>
<td>${order.orderDes }</td>
<td>${order.totalPrice }</td>
<td>${order.type }</td>
<td>${order.payId }</td>
<td >
<%-- <a href='/alipay/paySerlet?id=${order.id }' >付款</a> --%>
<c:choose>
   <c:when test="${order.type==0 }"> 
         <a href='/alipay/paySerlet?id=${order.id }' >付款</a>   
   </c:when>
   <c:otherwise>
   <a href='/alipay/queryDetailServlet?id=${order.id }&payId=${order.payId }' >订单详情</a> 
   </c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
	</table>
</body>
</html>