<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript">
	/* {"alipay_trade_query_response":
	{"code":"10000",
	"msg":"Success",
	"buyer_logon_id":"eps***@sandbox.com",
	"buyer_pay_amount":"0.00",
	"buyer_user_id":"2088102175312783",
	"buyer_user_type":"PRIVATE",
	"invoice_amount":"0.00",
	"out_trade_no":"123144554",
	"point_amount":"0.00",
	"receipt_amount":"0.00",
	"send_pay_date":"2018-01-13 13:56:54",
	"total_amount":"0.01",
	"trade_no":"2018011321001004780200653004",
	"trade_status":"TRADE_SUCCESS"
	},
"sign":} */
	</script>
<body>
<c:choose>
	<c:when test="${aliPayResult.code==10000 }">
				订单详情<br />
			<table border="1px" id="tab">
			<tr>
			<td>买家支付宝id</td><!-- buyer_user_id -->
			<td>买家级别</td><!-- buyer_user_type  CORPORATE:企业用户；PRIVATE:个人用户。  -->
			<td>订单编号</td><!-- out_trade_no -->
			<td>支付账号</td><!-- buyer_logon_id -->
			<td>实际支付金额</td><!-- total_amount -->
			<td>支付时间 </td><!-- send_pay_date -->
			<td>支付单号</td><!-- trade_no -->
			<td>订单的状态</td><!-- trade_status WAIT_BUYER_PAY（交易创建，等待买家付款）、
											  TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、
											  TRADE_SUCCESS（交易支付成功）、
											  TRADE_FINISHED（交易结束，不可退款 -->
			<td colspan='3'>操作</td>
			</tr>
			<tr>
				<td>${aliPayResult.buyer_user_id }</td>
				<td>${aliPayResult.buyer_user_type }</td>
				<td>${aliPayResult.out_trade_no }</td>
				<td>${aliPayResult.buyer_logon_id }</td>
				<td>${aliPayResult.total_amount }</td>
				<td>${aliPayResult.send_pay_date }</td>
				<td>${aliPayResult.trade_no }</td>
				<td>${aliPayResult.trade_status }</td>
				<td><a href='/alipay/payBackServlet?id=${aliPayResult.out_trade_no }&payId=${aliPayResult.trade_no }' >申请退款</a> </td>
			</tr>
				</table>
	</c:when>
	<c:when test="${aliPayResult.code==40004 }">
	查询失败请重新查询<a>${aliPayResult.msg }</a>
	</c:when>
	<c:when test="${aliPayResult.code==40006 }">
	权限不足，请登录正确的账户<a>${aliPayResult.msg }</a>
	</c:when>
	<c:otherwise>
	<a>${aliPayResult.msg }</a>
	</c:otherwise>
</c:choose>

</body>
</html>