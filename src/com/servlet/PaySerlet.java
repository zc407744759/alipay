
package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.domain.Order;
import com.utils.AlipayConfig;
import com.utils.JDBCUtils;

@WebServlet("/paySerlet")
public class PaySerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		try {
			
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
			alipayRequest.setReturnUrl(AlipayConfig.return_url);
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
			
			Integer id = Integer.parseInt(req.getParameter("id"));
			rsp.setContentType("text/html; charset=UTF-8");
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			Order order = queryRunner.query("select * from orders where id=?", new BeanHandler<Order>(Order.class),id);
			
			//商户订单号，商户网站订单系统中唯一订单号，必填
			String out_trade_no = order.getOrderId();
			//付款金额，必填
			String total_amount =String.valueOf(order.getTotalPrice());
			//订单名称，必填
			String subject = order.getOrderName();
			//商品描述，可空
			String body = order.getOrderDes();
			
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+ "\"total_amount\":\""+ total_amount +"\"," 
					+ "\"subject\":\""+ subject +"\"," 
					+ "\"body\":\""+ body +"\"," 
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			
			//请求
			String result = alipayClient.pageExecute(alipayRequest).getBody();
			
			//输出
			rsp.getWriter().println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		doGet(req, rsp);
	}

}