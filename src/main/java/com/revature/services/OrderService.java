package com.revature.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.dao.OrderDAO;
import com.revature.models.Order;
import com.revature.utils.CaptainsLogger.LogLevel;

public class OrderService {
	OrderDAO orderDAO;

	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public boolean placeOrder(Order order) {
		return orderDAO.create(order);
		
		
	}

	public List<Order> getPirateOrders(int pirateID) {
	
		List<Order> pirateOrders =  new ArrayList<Order>();
		
		List<Order> allOrders = orderDAO.readAll();

		if(allOrders == null || allOrders.isEmpty()) {
			
			return null;
		}else {
			for(Order order : orderDAO.readAll()) {
				if(order.getPirateID()>0)
				{
					if(order.getPirateID()==pirateID)
					pirateOrders.add(order);
					
				}
					
			}
		}
		return pirateOrders;
		
				
				
	
		
		
	}
}
