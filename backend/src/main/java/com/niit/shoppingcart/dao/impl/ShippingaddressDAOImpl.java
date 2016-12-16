package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ShippingaddressDAO;
import com.niit.shoppingcart.model.Shippingaddress;
@Repository("shipaddrsdao")
@Transactional
public class ShippingaddressDAOImpl implements ShippingaddressDAO{
	@Autowired
	SessionFactory factory;
	public ShippingaddressDAOImpl(SessionFactory factory){
		this.factory=factory;
	}

	public boolean saveshipaddrs(Shippingaddress address) {
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

	public boolean Updateshipaddrs(Shippingaddress address) {
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

	public boolean deleteshipaddrs(Shippingaddress address) {
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

	public Shippingaddress get(String id) {
		return (Shippingaddress) factory.openSession().get(Shippingaddress.class,id);

	}

	public List<Shippingaddress> listofAddresses() {
		String hql="from ShippingAddress";
		Query query=factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public String getshippingaddressid() {
		String hql="select max(id) from ShippingAddress";
		Query query=factory.getCurrentSession().createQuery(hql);
	String a=query.uniqueResult().toString();
	return a;
	}
	}