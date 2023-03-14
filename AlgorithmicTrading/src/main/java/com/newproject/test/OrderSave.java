package com.newproject.test;

import java.io.IOException;
import java.sql.SQLException;

import com.newproject.test.dao.OrderService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/order_save")
public class OrderSave  extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderService service = new OrderService();
		
		
	    String action = request.getParameter("action");
	    if(action != null && !action.isEmpty()) {
	        if(action.equals("modify")) {
	           
	            int  orderId = Integer.parseInt( request.getParameter("order_id"));
	            
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            double price = Double.parseDouble( request.getParameter("price"));
	            
	              try {
					service.updateOrder(orderId, quantity, price);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	              request.setAttribute("orderId", orderId);
	              
	             RequestDispatcher rd = request.getRequestDispatcher("MsgForUpdate.jsp");
	             rd.forward(request, response);


	        } else if(action.equals("delete")) {
	        	
	        	 int  orderId = Integer.parseInt( request.getParameter("order_id"));
	        	
	        	try {
					service.deleteOrder(orderId);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	        	
	        	
	              
	             RequestDispatcher rd = request.getRequestDispatcher("MsgForDeleteOrder.jsp");
	             rd.forward(request, response);
	        	
	            }
	    }
	   
	   
	}

	

}
