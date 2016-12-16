package com.niit.shoppingcart.Applicationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.dao.impl.CategoryDAOImpl;
import com.niit.shoppingcart.dao.impl.ProductDAOImpl;
import com.niit.shoppingcart.dao.impl.SupplierDAOImpl;
import com.niit.shoppingcart.dao.impl.UserDAOImpl;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Configuration
@ComponentScan("com.niit.backend")
@EnableTransactionManagement
public class ApplicationContextconfig {
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		 datasource.setDriverClassName("org.h2.Driver");
		 datasource.setUsername("sa");
	    	datasource.setPassword("");
	    	return datasource;
	}
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	   @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClass(Category.class);
	    	sessionBuilder.addAnnotatedClass(Supplier.class);
	    	sessionBuilder.addAnnotatedClass(User.class);
	    	sessionBuilder.addAnnotatedClass(Product.class);
	    	return sessionBuilder.buildSessionFactory();
	    }
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
		@Autowired
		@Bean(name="categoryDAO")
		public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
		{
			return new CategoryDAOImpl(sessionFactory);
			
		}
		@Autowired
		@Bean(name="productDao")
		public ProductDAO getProductDao(SessionFactory sessionFactory)
		{
			return new ProductDAOImpl(sessionFactory);
			
		}@Autowired
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
		{
			return new SupplierDAOImpl(sessionFactory);
			
		}
		
		@Bean(name="userDao")
		public UserDAO getuserDao(SessionFactory sessionFactory)
		{
			return new UserDAOImpl(sessionFactory);
			
		}
}

