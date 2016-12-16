package com.niit.shoppingcart.dao.impl;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Repository
@Transactional

public class CategoryDAOImpl  implements CategoryDAO{
	@Autowired
	SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	

	public boolean save(Category category) {
		try {
			if(get(category.getId()) !=null)
{
	return false;
}
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
 
	public boolean update(Category category) {
			try {
				if(get(category.getId())==null)
				{
					return false;
				}
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public Category get(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class,id);
		
	}
	@Transactional//to open close commite the connection
	public List<Category>list()
	{
		String hql="from Category";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public boolean delete(Category category) {
		try {
			if(get(category.getId())==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

}
