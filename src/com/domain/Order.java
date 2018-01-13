package com.domain;

import java.io.Serializable;

public class Order implements Serializable{
	
//	第一，订单ID   主键，自增
	private Integer id;
//	第二，订单号    char 20
	private String orderId;
//	第三，订单名称  字符串
	private String orderName;
//	第四，订单简介  字符串
	private String orderDes;
//	第五，订单总价  
	private Double  totalPrice;
//	第六，订单的状态【付款、未付款】  tinyint   0,1 如果支付宝处理完成之后，我在代码当中，把订单状态改为1.
	private Integer type;
	
//	第七  支付宝支付单号
	private String payId;
//	第八  支付宝退款id
	private String payBackId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderDes() {
		return orderDes;
	}
	public void setOrderDes(String orderDes) {
		this.orderDes = orderDes;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getPayBackId() {
		return payBackId;
	}
	public void setPayBackId(String payBackId) {
		this.payBackId = payBackId;
	}
	
	
	

}
