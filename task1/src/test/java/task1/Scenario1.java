package task1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import driver.PageElements;
import util.utils;
import driver.DriverTasks;
import test_utils.Objects;

public class Scenario1 extends Objects {
	
  @Test
  public void test1() throws InterruptedException, IOException {
	  //try passing objects using DataProvider
	  
	  System.out.println(drivertasks);
	  drivertasks.loadURL("http://toolsqa.com/");
	  Reporter.log("Website loaded");
	  drivertasks.hoverOn(pageelements.getDemoSitesMenu());
	  drivertasks.clickOn(pageelements.getAutomationPracticeFormSubMenu());
	  Thread.sleep(5000);
      System.out.println(drivertasks.driver.getCurrentUrl());
	  Reporter.log("Practice Automation Form Page Loaded");
      String link_text = drivertasks.getTextOf(pageelements.getPartialLink());
      Assert.assertEquals("Partial Link Test", link_text);
	  Reporter.log("Partial Link Text verified");
      String form_title = drivertasks.getTextOf(pageelements.getFormTitle());
      Assert.assertEquals("Practice Automation Form", form_title);
	  Reporter.log("Page Heading verified");
	  drivertasks.clickOn(pageelements.getLinkTest());
      drivertasks.navigateBack();
      drivertasks.typeTextIn(pageelements.getFirstNameBox(),"Shivam");
      drivertasks.typeTextIn(pageelements.getLastNameBox(),"Mishra");
	  Reporter.log("Entered first and last name");
	  WebElement SexRadio = pageelements.getSexRadio();
      drivertasks.clickOn(SexRadio);
	  Reporter.log("Sex Radio Randomly Selected :" +SexRadio.getText());
      drivertasks.typeTextIn(pageelements.getDateButton(), utilities.getTodaysDate());
	  Reporter.log("Entered Todays Date");
	  WebElement YearsRadio = pageelements.getYearsRadio();
      drivertasks.clickOn(YearsRadio);
	  Reporter.log("Years Radio Randomly Selected :" +YearsRadio.getText());
	  WebElement ProfessionRadio = pageelements.getProfessionRadio();
      drivertasks.clickOn(ProfessionRadio);
	  Reporter.log("Profession Radio Randomly Selected :" +ProfessionRadio.getText());
      //Below code will upload File using AutoIT
	  //drivertasks.clickOn(pageelements.getUploadPhotoButton());
      //utilities.uploadFile("C:/Users/User/Downloads/test.jpg");
      utilities.uploadFileTest("C:/Users/User/Downloads/test.jpg",pageelements.getUploadPhotoButton());
	  Reporter.log("File uploaded");
      drivertasks.clickOn(pageelements.getDownloadLinkButton());
	  Reporter.log("File downloaded");
	  WebElement ToolRadio = pageelements.getToolRadio();
      drivertasks.clickOn(ToolRadio);
	  Reporter.log("Tool Radio Randomly Selected :" +ToolRadio.getText());
      List <String> selected_continents_text = pageelements.selectRandomContinent();
      for(String selected_continent_text : selected_continents_text)
      {
    	  Reporter.log(" Continent Randomly Selected :" +selected_continent_text);

      }
      List <String> selected_commands_text =  pageelements.selectRandomCommands();
      for(String selected_command_text : selected_commands_text)
      {
    	  Reporter.log(" Command Randomly Selected :" +selected_command_text);

      }
      drivertasks.clickOn(pageelements.getSubmitButton());
	  Reporter.log("Submit Button Clicked");


  }
  
  //@Parameters({ "browser" })
  @BeforeMethod
  public void beforeMethod() {
	  //drivertasks.loadDriver(browser);
	  Reporter.log("Browser opened");
	  
  }
 
  
  @AfterTest
  public void afterMethod() {
	 // drivertasks.close();
  }

}
