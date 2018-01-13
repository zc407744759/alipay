package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.domain.AliPayResult;
import com.utils.AlipayConfig;

@WebServlet("/queryDetailServlet")
public class QueryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse rsp) throws ServletException, IOException {

		try {
			rsp.setContentType("text/html; charset=UTF-8");
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
			
			//商户订单号，商户网站订单系统中唯一订单号
			String out_trade_no = request.getParameter("id");
			//支付宝交易号
			String trade_no = request.getParameter("payId");
			//请二选一设置
			
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","+"\"trade_no\":\""+ trade_no +"\"}");
			
			//请求
			String result = alipayClient.execute(alipayRequest).getBody();
				/*	查询订单详情的返回信息
					{"alipay_trade_query_response":
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
					"sign":}*/
//			解析json数据
			JSONObject parseObject = JSONObject.parseObject(result).getJSONObject("alipay_trade_query_response");
			
			AliPayResult aliPayResult = parseObject.toJavaObject(AliPayResult.class);
			//输出
			/*System.out.println(result);*/
			request.getSession().setAttribute("aliPayResult", aliPayResult);
			rsp.sendRedirect("/alipay/detail.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		doGet(req, rsp);
	}

}