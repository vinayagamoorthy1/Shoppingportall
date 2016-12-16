package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Billingaddress;

public interface BillingaddressDAO {
	public boolean savebilladdrs(Billingaddress address);
	public boolean Updatebilladdrs(Billingaddress address);
	public boolean deletebilladdrs(Billingaddress address);
	public Billingaddress get(String id);
	public List<Billingaddress> listofAddresses();

}