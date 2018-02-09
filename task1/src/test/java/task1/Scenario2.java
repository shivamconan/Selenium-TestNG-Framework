package task1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import driver.DriverTasks;
import driver.PageElements;
import util.utils;
import test_utils.Objects;

public class Scenario2 extends Objects {
	
  @Test
  public void test2() throws InterruptedException {
	  drivertasks.loadURL("http://toolsqa.com/");
	  Reporter.log("Website loaded");
	  drivertasks.hoverOn(pageelements.getDemoSitesMenu());
	  drivertasks.clickOn(pageelements.getAutomationPracticeSwitchWindowsSubMenu());
	  Thread.sleep(4000); 
	  Reporter.log("Practice Automation Form Page Loaded");
	  String style1 = drivertasks.getAttributeOf(pageelements.getFirstChangeColorButton(),"style");
	  Reporter.log(String.format("The first 'Change Color' button's %s", style1));
	  String style2 = drivertasks.getAttributeOf(pageelements.getSecondChangeColorButton(),"style");
	  Reporter.log(String.format("The second 'Change Color' button's %s", style2));
	  String parentWindow = utilities.getCurrentWindow();
	  drivertasks.clickOn(pageelements.getNewBrowserWindowButton());
	  utilities.switchToNewWindow();
	  Reporter.log("Clicked on New Window button and switched to it");
	  String currentURL = utilities.getCurrentURL();
	  Assert.assertEquals("http://toolsqa.com/", currentURL);
	  Reporter.log(String.format("URL of page in new window verified to be ",currentURL));
	  String currentPageTitle = utilities.getCurrentPageTitle();
	  Assert.assertEquals("QA Automation Tools Tutorial", currentPageTitle);
	  Reporter.log(String.format("Title of page new window verified to be ",currentPageTitle));
	  //OPtionally close the new window -
	  // utilities.closeWindow();
	  utilities.switchToWindow(parentWindow);
	  Reporter.log("Switched back to parent window");
	  drivertasks.clickOn(pageelements.getNewMessageWindowButton());
	  utilities.switchToNewWindow();
	  drivertasks.driver.manage().window().maximize();
	  Reporter.log("Clicked on New Message Window button and switched to it");
	  System.out.println(utilities.getCurrentPageTitle());
	  Thread.sleep(2000);
	  String message_window_text = pageelements.getMessageWindowText();
	  System.out.print("Window Tex: "+message_window_text);
	  utilities.switchToWindow(parentWindow);
	  Reporter.log("Switched back to parent window");
	  drivertasks.clickOn(pageelements.getNewBrowserTabButton());
	  utilities.switchToNewWindow(); 
	  Reporter.log("Clicked on New Browser Tab button and switched to it");
	  currentURL = utilities.getCurrentURL();
	  Assert.assertEquals("http://toolsqa.com/", currentURL);
	  Reporter.log(String.format("URL of page in new tab verified to be ",currentURL));
	  currentPageTitle = utilities.getCurrentPageTitle();
	  Assert.assertEquals("QA Automation Tools Tutorial", currentPageTitle);
	  Reporter.log(String.format("Title of page new tab verified to be ",currentPageTitle));
	  utilities.switchToWindow(parentWindow);
	  Reporter.log("Switched back to parent tab");
	  String attribute = drivertasks.getAttributeOf(pageelements.getRandomIDElement(),"id");
	  Reporter.log(String.format("The ID of random element is  ",attribute));
	  drivertasks.clickOn(pageelements.getAlertButton());
	  Reporter.log("Clicked on alert button");
	  drivertasks.acceptAlert();
	  Reporter.log("alert accepted");
	  drivertasks.clickOn(pageelements.getTimingAlertButton());
	  Reporter.log("Clicked on timing alert button");
	  drivertasks.acceptAlert();
	  Reporter.log("timing alert accepted");
	  style1 = drivertasks.getAttributeOf(pageelements.getFirstChangeColorButton(),"style");
	  Reporter.log(String.format("The first 'Change Color' button's %s", style1));
	  drivertasks.doubleClickOn(pageelements.getSecondChangeColorButton());
	  Reporter.log("Double clicked on second 'Change Color' button");
	  style2 = drivertasks.getAttributeOf(pageelements.getSecondChangeColorButton(),"style");
	  Reporter.log(String.format("The second 'Change Color' button's %s", style2));
	  boolean isButtonEnabled = drivertasks.isButtonEnabled(pageelements.getDisabledButton());
	  Assert.assertEquals(true, isButtonEnabled);
	  Reporter.log("The button is verified to be enabled");

  }
}
