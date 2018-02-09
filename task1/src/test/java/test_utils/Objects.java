package test_utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import driver.DriverTasks;
import driver.PageElements;
import util.utils;

public class Objects {
	
	public static DriverTasks drivertasks;
	public static PageElements pageelements;
	public static utils utilities;
	public String test;
	
	
	@Parameters({ "browser" })
	@BeforeTest
	public void initializeObjects(String browser)
	{		
	   drivertasks = new DriverTasks();	
	   drivertasks.loadDriver(browser);
	   utilities = new utils(drivertasks);
	   pageelements = new PageElements(drivertasks,utilities);
	}	  
}
