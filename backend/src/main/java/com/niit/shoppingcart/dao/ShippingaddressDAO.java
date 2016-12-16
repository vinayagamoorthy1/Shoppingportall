package com.niit.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;


import com.niit.shoppingcart.model.Shippingaddress;

public interface ShippingaddressDAO extends Serializable{
	public boolean saveshipaddrs(Shippingaddress address);
	public boolean Updateshipaddrs(Shippingaddress address);
	public boolean deleteshipaddrs(Shippingaddress address);
	public Shippingaddress get(String id);
	public List<Shippingaddress> listofAddresses();
public String getshippingaddressid();
}