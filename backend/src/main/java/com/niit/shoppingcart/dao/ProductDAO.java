package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

public interface ProductDAO {
public boolean save(Product product);
	
	public boolean update(Product product);
	
	public Product get(String id);
	
	
	public boolean delete(Product product);

	public List<Product> list();
}


