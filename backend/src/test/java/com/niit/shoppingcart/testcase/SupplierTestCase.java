package com.niit.shoppingcart.testcase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired 
	static  Supplier supplier;
	@Autowired
	static SupplierDAO supplierDAO;
	@BeforeClass
	public  static void init()
	{
		context =new AnnotationConfigApplicationContext();
   		context.scan("com.niit.backend");
	    context.refresh();
	    
	    supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	    supplier=(Supplier) context.getBean("supplier");
	}
	/*@Test
	public void createSupplierTestCase()
	{
		supplier.setId(100);
		supplier.setDescription("computer Category");
		supplier.setName("compcategory");
		supplier.setAddress("primary");
		supplier.setPhoneno(880);

	  Boolean status= supplierDAO.save(supplier);
	 Assert.assertEquals("createSupplierTestCase",true,status );
	}
	@Test
	public void updateSupplierTestCase()
	{
		supplier.setId(11);
		supplier.setDescription("computer Category");
		supplier.setName("model category	");
		supplier.setAddress("malasiya");
		supplier.setPhoneno(99099);

	  Boolean status= supplierDAO.update(supplier);
	Assert.assertEquals("updateSupplierTestCase",true,status );
	}
	@Test
	public void getSupplierTestCase()
	{
		
	 Assert.assertEquals("getSupplierTestCase",null,supplierDAO.get(10));

	}
	@Test
	public void deleteSupplierTestCase()
	{
		supplier.setId(88);
		
	  Boolean status= supplierDAO.delete(supplier);
	 Assert.assertEquals("deleteeSupplierTestCase",true,status );
	}*/
	
	

}
