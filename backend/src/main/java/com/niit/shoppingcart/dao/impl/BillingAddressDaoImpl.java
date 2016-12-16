package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.BillingaddressDAO;
import com.niit.shoppingcart.model.Billingaddress;


@Repository("billaddrsdao")
@Transactional
public class BillingAddressDaoImpl implements  BillingaddressDAO{
@Autowired
SessionFactory factory;
public BillingAddressDaoImpl(SessionFactory factory){
	this.factory=factory;
}
	
	public boolean savebilladdrs(Billingaddress address) {
		try {
			if(get(address.getId())!=null){
				return false;
			}
			factory.getCurrentSession().save(address);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Updatebilladdrs(Billingaddress address) {
		
try {
	if(get(address.getId())==null){
		return false;
	}	factory.getCurrentSession().update(address);
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;
}
	}

	public boolean deletebilladdrs(Billingaddress address) {
		try {
			if(get(address.getId())==null){
				return false;
			}
			factory.getCurrentSession().delete(address);
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Billingaddress get(String id) {
		return (Billingaddress) factory.openSession().get(Billingaddress.class,id);
	}

	public List<Billingaddress> listofAddresses() {
		String hql="from Billingaddress";
		Query query=factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}