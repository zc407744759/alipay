package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.domain.Order;
import com.utils.JDBCUtils;

@WebServlet("/findAll")
public class FindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		try {
			rsp.setContentType("text/html; charset=UTF-8");
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			List<Order> list = queryRunner.query("select * from orders", new BeanListHandler<Order>(Order.class));
			req.getSession().setAttribute("list", list);
			rsp.sendRedirect("/alipay/list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		doGet(req, rsp);
	}

}
