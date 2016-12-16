package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Order;



public interface OrderDAO {
	public String save(Order order);
	public String update(Order order);
	public String delete(Order order);
    public Order get(String id);
    public List<Order> listall();

}