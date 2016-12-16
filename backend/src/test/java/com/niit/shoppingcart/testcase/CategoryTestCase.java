package com.niit.shoppingcart.testcase;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired 
	static Category category;
	@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public  static void init()
	{
		context =new AnnotationConfigApplicationContext();
   		context.scan("com.niit.backend");
	    context.refresh();
	    
	    categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	    category=(Category) context.getBean("category");
	}
	
//strat writing junit test case 
	//for update,delete.and all.
/*
@Test
public void createCategoryTestCase()
{
	category.setId("CAT_37");
	category.setDescription("elect Category");
	category.setName("mobe category");

  Boolean status= categoryDAO.save(category);
 Assert.assertEquals("createCategoryTestCase",true,status );
}

@Test
public void updateCategoryTestCase()
{
	category.setId("CAT_31");
	category.setDescription("mobile Category");
	category.setName("modell category");

  Boolean status= categoryDAO.update(category);
 Assert.assertEquals("updateCategoryTestCase",true,status );
}
@Test
public void getCategoryTestCase()
{
	
 Assert.assertEquals("getCategoryTestCase",null,categoryDAO.get("CAT_76"));

}

@Test
public void deleteCategoryTestCase()
{
	category.setId("CAT_07");


  Boolean status= categoryDAO.delete(category);
 Assert.assertEquals("deleteeCategoryTestCase",true,status );
}*/
}
