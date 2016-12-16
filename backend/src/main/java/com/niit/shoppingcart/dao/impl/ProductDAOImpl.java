package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;
@Repository
@Transactional
public class ProductDAOImpl implements  ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Product get(String id) {return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
	
}
@Transactional//to open close commite the connection
public List<Product>list()
{
	String hql="from Product";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();

	}
	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
