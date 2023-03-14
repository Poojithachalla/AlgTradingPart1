package com.newproject.test;

import java.io.IOException;
import java.sql.SQLException;

import com.newproject.test.dao.OrderService;
import com.newproject.test.model.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ModifyOrder")
public class ModifyOrderServlet  extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		
		int order_id =Integer.parseInt(request.getParameter("order_id"));
		
		OrderService service = new OrderService();
		try {
			Order order = service.fetchOrder(order_id);
			request.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("/ModifyOrder.jsp");
			rd.forward(request, respose);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
