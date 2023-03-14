package com.newproject.test.model;

public class Order {
	
	private Integer order_id;
	private String company_Id;
	private String side;
	private int quantity;
	private double price;
	private Integer priority_queue;
	private String order_status;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getCompany_Id() {
		return company_Id;
	}

	public void setCompany_Id(String company_Id) {
		this.company_Id = company_Id;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPriority_queue() {
		return priority_queue;
	}

	public void setPriority_queue(int priority_queue) {
		this.priority_queue = priority_queue;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", company_Id=" + company_Id + ", side=" + side + ", quantity="
				+ quantity + ", price=" + price + ", priority_queue=" + priority_queue + ", order_status="
				+ order_status + "]";
	}


}
