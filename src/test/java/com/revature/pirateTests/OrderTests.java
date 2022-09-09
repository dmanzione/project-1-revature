package com.revature.pirateTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.dao.OrderDAO;
import com.revature.models.Order;
import com.revature.services.OrderService;

public class OrderTests {
	private static OrderDAO orderDAO;
	private static OrderService orderService;
	private static Order order;
	
	@BeforeAll
	public void initializeFields() {
		orderService = new OrderService(orderDAO = new OrderDAO());
		order = new Order("Captain Branch", 1);
	}
	@Test
	public void placeOrderTest() {
		
		orderService.placeOrder(order);
	}
}
