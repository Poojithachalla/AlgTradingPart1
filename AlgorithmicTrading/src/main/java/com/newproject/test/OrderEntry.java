package com.newproject.test;

import java.io.IOException;
import java.io.PrintWriter;

import com.newproject.test.dao.OrderService;
import com.newproject.test.model.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderEntry extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  OrderService  service = new OrderService();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String company_Id = request.getParameter("company_Id");
		String side = request.getParameter("side");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double price = Double.parseDouble(request.getParameter("price"));
		out.println(company_Id + "   " + side + "   " + quantity + "   " + price);

		Order order = new Order();
		order.setCompany_Id(company_Id);
		order.setSide(side);
		order.setQuantity(quantity);
		order.setPrice(price);
		service.addOrder(order);
	

		RequestDispatcher rd = request.getRequestDispatcher("OrderCreated.jsp");
             rd.forward(request, response);
	}

}
