package com.newproject.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newproject.test.model.Order;

public class OrderService {

  private OrderDAO orderDAO = new OrderDAO();

  @SuppressWarnings("resource")
public void addOrder(Order order) {
	  order.setOrder_status("Pending");
    Connection connection = null;
    PreparedStatement statement = null;
    int priority_queue ;
    try {
      orderDAO.loadDriver(orderDAO.dbDriver);
      connection = orderDAO.getConnection();
      statement = connection.prepareStatement("SELECT max(priority_queue) FROM Orders");
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        priority_queue = rs.getInt(1);
        

        if (priority_queue == 0) {
          priority_queue = 1;
          order.setPriority_queue(priority_queue);
        } else {
          priority_queue++;
          order.setPriority_queue(priority_queue++);
        }
        
      }
   
      statement = connection.prepareStatement("INSERT INTO orders (company_Id, side, quantity, price,priority_queue,order_status) VALUES (?, ?, ?, ?, ?, ?)");
     
      statement.setString(1, order.getCompany_Id());
      statement.setString(2, order.getSide());
      statement.setInt(3, order.getQuantity());
      statement.setDouble(4, order.getPrice());
      statement.setInt(5, order.getPriority_queue());
      statement.setString(6, order.getOrder_status());
      int rowsInserted = statement.executeUpdate();

      if (rowsInserted > 0) {
        System.out.println("Order added successfully.");
      } else {
        System.out.println("Error adding order.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  public List<Order> getOrder() throws SQLException{
	  List<Order> orders = new ArrayList<Order>();
	  Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String sql = "SELECT * FROM Orders WHERE order_status <> 'Deleted' ORDER BY company_Id, price, side";
	  
	    try {
	    orderDAO.loadDriver(orderDAO.dbDriver);
	     connection = orderDAO.getConnection();
	     PreparedStatement statement2 = connection.prepareStatement(sql);
	     
	      resultSet = statement2.executeQuery();	
	     
	     while(resultSet.next()) {
	    	int order_id = resultSet.getInt("order_id");
	    	String company_Id = resultSet.getString("company_Id");
	    	String side = resultSet.getString("side");
	    	int quantity = resultSet.getInt("quantity");
	    	double price = resultSet.getDouble("price");
	    	String order_status = resultSet.getString("order_status");
	    	 Order order = new Order();
	    	 order.setOrder_id(order_id);
	    	 order.setCompany_Id(company_Id);
	    	 order.setSide(side);
	    	 order.setQuantity(quantity);
	    	 order.setPrice(price);
	    	 order.setOrder_status(order_status);
	    	 orders.add(order);
	     }
	    }
	    finally {
	    	
			if (resultSet != null) {
	    	      resultSet.close();
	    	    }
	    	    if (statement != null) {
	    	      statement.close();
	    	    }
	    	    if (connection != null) {
	    	      connection.close();
	    	    }
	    	
	    
	    }
	    
	    return orders;
	    }
  
  public Order fetchOrder(int order_id )throws SQLException {
	  
	  Order order = new Order();
	  Connection connection = null;
	    PreparedStatement statement2 = null;
	    ResultSet resultSet = null;
	    String sql = "select order_id, company_Id, side, quantity, price, order_status from orders where order_id=" + order_id;
	    try {
		    orderDAO.loadDriver(orderDAO.dbDriver);
		     connection = orderDAO.getConnection();
		    statement2 = connection.prepareStatement(sql);
		     
		      resultSet = statement2.executeQuery();	
		      if(resultSet.next()) {
		    	  int order_Id = resultSet.getInt("order_id");
			    	String company_Id = resultSet.getString("company_Id");
			    	String side = resultSet.getString("side");
			    	int quantity = resultSet.getInt("quantity");
			    	double price = resultSet.getDouble("price");
			    	String order_status = resultSet.getString("order_status");
			    	  order = new Order();
			    	 order.setOrder_id(order_Id);
			    	 order.setCompany_Id(company_Id);
			    	 order.setSide(side);
			    	 order.setQuantity(quantity);
			    	 order.setPrice(price);
			    	 order.setOrder_status(order_status);
		    	  
		    	  
		      }
		     
	    }
	    finally {
	    	
	    	if (resultSet != null) {
	    	      resultSet.close();
	    	    }
	    	    if (statement2 != null) {
	    	      statement2.close();
	    	    }
	    	    if (connection != null) {
	    	      connection.close();
	    	    }
	    	
	    	
	    	
	    }
	  return order;
	  
	  
	  
  }
  
  public void deleteOrder(int order_id) throws SQLException {
	  
	  Connection connection = null;
	    PreparedStatement statement3 = null;
	    int rowdeletd = 0;
	    String sql = "update orders set order_status='Deleted' where order_id=" + order_id;
;
	    try {
		    orderDAO.loadDriver(orderDAO.dbDriver);
		     connection = orderDAO.getConnection();
		      statement3 = connection.prepareStatement(sql);
		       rowdeletd = statement3.executeUpdate(sql);
		      if (rowdeletd > 0) {
		          System.out.println(" row deletd successfully.");
		        } else {
		          System.out.println("Error order delete.");
		        }
		      
	  
	    }
	    finally {
	    	
	    	
	    	    if (statement3 != null) {
	    	    	statement3.close();
	    	    }
	    	    if (connection != null) {
	    	      connection.close();
	    	    }
	    	
	    	
	    }
	  
	  
  }
  
  public void updateOrder(int order_id , int quantity , double price  ) throws SQLException{
	  
	  Connection connection = null;
	    PreparedStatement statement4 = null;
	    int updateorder = 0;
	    String sql = "update orders set quantity=?,price=? where order_id=?";
;
	    try {
		    orderDAO.loadDriver(orderDAO.dbDriver);
		     connection = orderDAO.getConnection();
		      statement4 = connection.prepareStatement(sql);
		      statement4.setInt(1, quantity);
		      statement4.setDouble(2, price);
		      statement4.setInt(3, order_id);
		       updateorder = statement4.executeUpdate();
		      
         if(updateorder > 0) {
        	 
        	 System.out.println("Order updated");
         }	
         else {
        	 
        	 System.out.println("Order not updated");
         }	      
		      
		      
	    }
	    finally {
	    	
	    	 if (statement4 != null) {
	    	    	statement4.close();
	    	    }
	    	    if (connection != null) {
	    	      connection.close();
	    	    }
	    	
	    	
	    }
	  
  }
 
  
}

