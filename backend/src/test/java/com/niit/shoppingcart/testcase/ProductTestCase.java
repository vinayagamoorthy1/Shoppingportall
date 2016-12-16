package com.niit.shoppingcart.testcase;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;


public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired 
	static  Product product;
	@Autowired
	static ProductDAO productDAO;
	@BeforeClass
	public  static void init()
	{
		context =new AnnotationConfigApplicationContext();
   		context.scan("com.niit.backend");
	    context.refresh();
	    
	    productDAO=(ProductDAO) context.getBean("productDao");
	    product=(Product) context.getBean("product");
	}
	//@Test
	/*public void createProductTestCase()
	{
		product.setId("56");
		product.setName("laptops Category");
		product.setPrice("101");
		product.setCategory_id("101");
		product.setSupplier_id("880");

		  Boolean status= productDAO.save(product);
		 Assert.assertEquals("createProductTestCase",true,status );
		}
	//@Test
	public void updateProductTestCase()
	{
		product.setId("55");
		product.setName("laptop Category");
		product.setPrice("100");
		product.setCategory_id("101");
		product.setSupplier_id("200");

		  Boolean status= productDAO.update(product);
		 Assert.assertEquals("createProductTestCase",true,status );
		}
	
	//@Test
	public void getproductTestCase()
	{
		
    Assert.assertEquals("getproductTestCase",null,productDAO.get("10"));

	}
	//@Test
	public void deleteproductTestCase()
	{
		product.setId("88");
		
	  Boolean status= productDAO.delete(product);
	 Assert.assertEquals("deleteeproductTestCase",true,status );
	}
	@Test
	public void getlist(){
		Assert.assertEquals("get test",2,productDAO.list().size());
	}

}
*/
}