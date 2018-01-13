package com.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AliPayResult implements Serializable{
	private String code; 	
	private String msg; 	
	private String trade_no; 	 	//支付宝交易号 	2013112011001004330000121536
	private String out_trade_no; 	//商家订单号 	6823789339978248
	private String buyer_logon_id; 	// 买家支付宝账号 	159****5620
	private String trade_status; 	//交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款） 	TRADE_CLOSED
	private Double total_amount;	//交易的订单金额，单位为元，两位小数。该参数的值为支付时传入的total_amount 	88.88
	private String receipt_amount; 	//实收金额，单位为元，两位小数。该金额为本笔交易，商户账户能够实际收到的金额 	15.25
	private Double buyer_pay_amount; 	//买家实付金额，单位为元，两位小数。该金额代表该笔交易买家实际支付的金额，不包含商户折扣等金额 	8.88
	private Double point_amount ;	//积分支付的金额，单位为元，两位小数。该金额代表该笔交易中用户使用积分支付的金额，比如集分宝或者支付宝实时优惠等 	10
	private Double invoice_amount; 	//交易中用户支付的可开具发票的金额，单位为元，两位小数。该金额代表该笔交易中可以给用户开具发票的金额 	12.11
	private Date send_pay_date; 	//本次交易打款给卖家的时间 	2014-11-27 15:45:57
	private String store_id; 	//商户门店编号 	NJ_S_001
	private String terminal_id; 	//商户机具终端编号 	NJ_T_001 	
	private String store_name; 	//请求交易支付中的商户店铺的名称 	证大五道口店
	private String buyer_user_id; 	//买家在支付宝的用户id 	2088101117955611
	private String buyer_user_type; 	//买家用户类型。CORPORATE:企业用户；PRIVATE:个人用户。 
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}
	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}
	public String getTrade_status() {
		if(trade_status.equals("WAIT_BUYER_PAY")){
			return "交易创建，等待买家付款";
		}else if(trade_status.equals("TRADE_CLOSED")){
			return "未付款交易超时关闭，或支付完成后全额退款";
		}else if(trade_status.equals("TRADE_SUCCESS")){
			return "交易支付成功";
		}else if(trade_status.equals("TRADE_FINISHED")){
			return "交易结束，不可退款";
		}else {
			return null;
		}
		
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	public Double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	public String getReceipt_amount() {
		return receipt_amount;
	}
	public void setReceipt_amount(String receipt_amount) {
		this.receipt_amount = receipt_amount;
	}
	public Double getBuyer_pay_amount() {
		return buyer_pay_amount;
	}
	public void setBuyer_pay_amount(Double buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}
	public Double getPoint_amount() {
		return point_amount;
	}
	public void setPoint_amount(Double point_amount) {
		this.point_amount = point_amount;
	}
	public Double getInvoice_amount() {
		return invoice_amount;
	}
	public void setInvoice_amount(Double invoice_amount) {
		this.invoice_amount = invoice_amount;
	}
	public String getSend_pay_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		return sdf.format(send_pay_date);
	}
	public void setSend_pay_date(Date send_pay_date) throws ParseException {
		this.send_pay_date = send_pay_date;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getTerminal_id() {
		return terminal_id;
	}
	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getBuyer_user_id() {
		return buyer_user_id;
	}
	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}
	public String getBuyer_user_type() {
		if(buyer_user_type.equals("CORPORATE")){
			return "企业用户";
		}else if(buyer_user_type.equals("PRIVATE")){
			return "个人用户";
		}else {
			return null;
		}
	}
	public void setBuyer_user_type(String buyer_user_type) {
		this.buyer_user_type = buyer_user_type;
	}
	
	
}
