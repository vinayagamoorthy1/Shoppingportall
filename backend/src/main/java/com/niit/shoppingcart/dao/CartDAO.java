package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;



public interface CartDAO {
public boolean save (Cart cart);
public boolean update (Cart cart);
public boolean delete (Cart cart);
public Cart get(String id);
public List<Cart> listofrows();

}
