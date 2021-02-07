package org.lll;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Notes extends Sample {
	@BeforeClass
	public static void empid() {
	  getDriver();
	  lauchUrl(" https://www.facebook.com/");
	}
	@Before
	public void empname() {
     Date d=new Date();
    System.out.println(d);
	}
   @Test
   public void emph() {
	   WebElement username = driver.findElement(By.id("email"));
	 enterText(username, "bhgf");
	 String attribute = username.getAttribute("value");
	 Assert.assertEquals("bhgf", attribute);

   }
   @Test
   public void ph() {


	 WebElement findElement = driver.findElement(By.id("pass"));
	 enterText(findElement,"984981819");
	 String attribute2 = findElement.getAttribute("value");
	 Assert.assertEquals("984981819", attribute2);

   }
   @Ignore
   @Test
   public void add() {


	 WebElement findElement2 = driver.findElement(By.name("login"));
	 btnclick(findElement2);
   }
   
	   
	@After
	public void empadd() {
		Date c=new Date();
		System.out.println(c);

	}
	@AfterClass
	public static void empgroup() {
		
		System.out.println("done");
      
	}

}
   
