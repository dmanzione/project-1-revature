package com.revature.services;

import com.revature.dao.OrderDAO;
import com.revature.models.Order;

public class OrderService {
	OrderDAO orderDAO;

	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public boolean placeOrder(Order order) {
		return orderDAO.create(order);
		
		
	}
}
