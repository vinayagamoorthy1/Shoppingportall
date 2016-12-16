package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {
public boolean save(User user);
	
	public boolean update(User user);
	
	public User get(String id);
	
	
	public boolean delete(User user);
	public List<User> userValidation(String id, String password);
	public List<User> adminValidation(String id, String password);
}



