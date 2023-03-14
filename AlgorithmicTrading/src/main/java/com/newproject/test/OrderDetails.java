package com.newproject.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.newproject.test.dao.OrderService;
import com.newproject.test.model.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Orderlist")
public class OrderDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		OrderService service = new OrderService();
	
    	try {
			List<Order> orderlist = service.getOrder();
			request.setAttribute("orderlist", orderlist);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ShowOrder.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
