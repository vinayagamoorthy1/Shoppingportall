package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Repository
@Transactional
public class UserDAOImpl  implements  UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean save(User user) {
		try {
			user.setRole("role_user");
			sessionFactory.getCurrentSession().save(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public User get(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
	}
	
	@Transactional
	public List<User>list()
	{
		String hql="from Product";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

		}
	
	
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<User> userValidation(String id, String password) {
		String hql="from User where name='"+id+"'"+"and password ='"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
		public List<User> adminValidation(String id, String password) {
			String hql2="from User where name='"+id+"'"+"and password ='"+password+"'"+"and role='role_admin'";
			Query query1=sessionFactory.getCurrentSession().createQuery(hql2);
			 return query1.list();

		}

		

	
	}

	
	
	

	


