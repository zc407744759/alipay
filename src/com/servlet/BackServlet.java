package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.utils.AlipayConfig;

@WebServlet("/BackServlet")
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse rsp) throws ServletException, IOException {

		try {
			rsp.setContentType("text/html; charset=UTF-8");
			/*AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
			String out_trade_no = request.getParameter("id");
			String trade_no = request.getParameter("payId");;
			String out_request_no = trade_no+out_trade_no;
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+"\"trade_no\":\""+ trade_no +"\","
					+"\"out_request_no\":\""+ out_request_no +"\"}");
		
			String result = alipayClient.execute(alipayRequest).getBody();
			String refundAmount = alipayClient.execute(alipayRequest).getRefundAmount();
			System.out.println(result);*/
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
			
			//商户订单号，商户网站订单系统中唯一订单号
			String out_trade_no = request.getParameter("id");
			//支付宝交易号
			String trade_no = request.getParameter("payId");
			//请二选一设置
			//请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
			String out_request_no = out_trade_no+trade_no;
			
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+"\"trade_no\":\""+ trade_no +"\","
					+"\"out_request_no\":\""+ out_request_no +"\"}");
			
			//请求
			String result = alipayClient.execute(alipayRequest).getBody();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		doGet(req, rsp);
	}

}