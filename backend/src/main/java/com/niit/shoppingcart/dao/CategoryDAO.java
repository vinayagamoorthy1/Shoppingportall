package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {
	//CRUD OPERATIONS
	public boolean save(Category category);
	
	public boolean update(Category category);
	
	public Category get(String id);
	
	
	public boolean delete(Category category);

	public List<Category>list();
	
	
}
