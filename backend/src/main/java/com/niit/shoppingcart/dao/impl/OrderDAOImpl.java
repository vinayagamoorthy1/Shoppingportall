package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;


@Repository("orderdao")
@Transactional
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SessionFactory sessionfactory;
	public OrderDAOImpl (SessionFactory sessionFactory){
		this.sessionfactory=sessionFactory;
	}

	public String save(Order order) {
		try {
			if(get(order.getId())!=null){
				return "Already exists";
			}
			sessionfactory.getCurrentSession().save(order);
			return"success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return"exception";
		}
	}

	public String update(Order order) {
		try {
			if(get(order.getId())==null){
				return"no such record exists";
			}
			sessionfactory.getCurrentSession().update(order);
			return"success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return"eception";
		}
	}

	public String delete(Order order) {
		try {
			if(get(order.getId())==null){
				return"no such record exists";
			}
			sessionfactory.getCurrentSession().delete(order);
			return"success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return"eception";
		}
	}

	public Order get(String id) {
 return (Order) sessionfactory.openSession().get(Order.class,id);
	}

	public List<Order> listall() {
String hql="from Order";
Query query=sessionfactory.getCurrentSession().createQuery(hql);
return query.list() ;
	}

}