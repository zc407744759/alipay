package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.domain.Order;
import com.utils.AlipayConfig;
import com.utils.JDBCUtils;

@WebServlet("/payBackServlet")
public class PayBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse rsp) throws ServletException, IOException {

		try {
			rsp.setContentType("text/html; charset=UTF-8");
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradeRefundRequest  alipayRequest = new AlipayTradeRefundRequest ();
//			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
//			Order order = queryRunner.query("select * from orders where id=?", new BeanHandler<Order>(Order.class),id);
			//商户订单号，商户网站订单系统中唯一订单号
			String out_trade_no = request.getParameter("id");
			//支付宝交易号
			String trade_no = request.getParameter("payId");
			//请二选一设置
			//请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
			String out_request_no = out_trade_no+trade_no;
			
			String refund_amount = "0.01";
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+"\"trade_no\":\""+ trade_no +"\","
					+"\"refund_amount\":\""+ refund_amount +"\","
					+"\"out_request_no\":\""+ out_request_no +"\"}");
			
			//请求
			String result = alipayClient.execute(alipayRequest).getBody();
			
			//输出
			rsp.getWriter().println("退款成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		doGet(req, rsp);
	}

}