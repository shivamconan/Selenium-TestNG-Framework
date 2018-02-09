package driver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.utils;
import org.openqa.selenium.support.ui.Select;

public class PageElements {
	
	
	public WebDriver driver;
	public DriverTasks drivertasks;
	public utils utilities;
	public Actions action;

	  public PageElements(DriverTasks drivertasks,utils utilities)
	{
	   this.drivertasks = drivertasks;
	   this.driver = drivertasks.driver;
	   this.utilities = utilities;
	   Actions action = drivertasks.getActionsObject();
	   this.action = action;

	}
	  
	public WebElement getDemoSitesMenu()
	{
		return drivertasks.waitForElement(this.driver.findElement(By.linkText("DEMO SITES")));
	}
	
	public void hoverOn(WebElement element)
	{
		action.moveToElement(element);

	}
	public WebElement getAutomationPracticeFormSubMenu()
	{
		//action.moveToElement(driver.findElement(By.xpath("//ul[@class='sub-nav hover-style-click-bg level-arrows-on']")));
		return drivertasks.waitForElement(driver.findElement(By.xpath("//span[contains(text(),'Automation Practice Form')]")));
	}
	
	public WebElement getAutomationPracticeSwitchWindowsSubMenu()
	{
		return drivertasks.waitForElement(driver.findElement(By.xpath("//span[contains(text(),'Automation Practice Switch Windows')]")));

	}
	public  WebElement getFormTitle()
	{
		System.out.print(driver.getCurrentUrl());
		return drivertasks.waitForElement(driver.findElement(By.xpath("(//h1)[2]")));
	}
	
	public WebElement getLinkTest()
	{
		return drivertasks.waitForElement(driver.findElement(By.linkText("Link Test")));

	}
	
	public  WebElement getPartialLink()
	{
		return drivertasks.waitForElement(driver.findElement(By.linkText("Partial Link Test")));

	}
	
	public  WebElement getFirstNameBox()
	{
		return drivertasks.waitForElement(driver.findElement(By.name("firstname")));

	}
	
	public  WebElement getLastNameBox()
	{
		return drivertasks.waitForElement(driver.findElement(By.name("lastname")));

	}
	
	public  WebElement getSexRadio()
	{
		List <WebElement> radios = driver.findElements(By.name("sex"));
		int random = utilities.getRandomIntegerBetween(0, 1);
		return drivertasks.waitForElement(radios.get(random));

	}
	
	public  WebElement getYearsRadio()
	{
		List <WebElement> radios = driver.findElements(By.name("exp"));
		int random = utilities.getRandomIntegerBetween(0, 6);
		return drivertasks.waitForElement(radios.get(random));

	}
	
	public  WebElement getDateButton()
	{
		return drivertasks.waitForElement(driver.findElement(By.id("datepicker")));

	}
	
	public  WebElement getProfessionRadio()
	{
		List <WebElement> radios = driver.findElements(By.name("profession"));
		int random = utilities.getRandomIntegerBetween(0, 1);
		return drivertasks.waitForElement(radios.get(random));

	}
	
	public  WebElement getUploadPhotoButton()
	{
		WebElement button =  drivertasks.waitForElement(driver.findElement(By.id("photo")));
		button.sendKeys("C:/Users/User/Downloads/test.jpg");
		return button;
	}
	
	public  WebElement getDownloadLinkButton()
	{
		return drivertasks.waitForElement(driver.findElement(By.linkText("Test File to Download")));
	}
	
	public  WebElement getToolRadio()
	{
		List <WebElement> radios = driver.findElements(By.name("tool"));
		int random = utilities.getRandomIntegerBetween(0, 2);
		return drivertasks.waitForElement(radios.get(random));
	}
	
	public List <String> selectRandomContinent()
	{
		Select dropdown = new Select(driver.findElement(By.id("continents")));
		int random = utilities.getRandomIntegerBetween(0, 6);
		dropdown.selectByIndex(random);
		return utilities.getTextOf(dropdown);
	}
	
	public List <String> selectRandomCommands()
	{
		Select dropdown = new Select(driver.findElement(By.id("selenium_commands")));
		int random1 = utilities.getRandomIntegerBetween(0, 4);
		int random2 = utilities.getRandomIntegerBetween(0, 4);
		while (random1==random2)
		{
			random2 = utilities.getRandomIntegerBetween(0, 4);

		}
		dropdown.selectByIndex(random1);
		dropdown.selectByIndex(random2);
		return utilities.getTextOf(dropdown);

	}
	
	public WebElement getSubmitButton()
	{
		return drivertasks.waitForElement(driver.findElement(By.id("submit")));

	}
	
public WebElement getNewBrowserWindowButton()
{
	return drivertasks.waitForElement(driver.findElement(By.xpath("//button[contains(text(),'New Browser Window')]")));

}

public WebElement getNewMessageWindowButton()
{
	return drivertasks.waitForElement(driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]")));

}

public String getMessageWindowText()
{
	return driver.findElement(By.tagName("body")).getText();
	//return drivertasks.waitForElement(driver.findElement(By.xpath("//body"))).getText();

}

public WebElement getNewBrowserTabButton()
{
	return drivertasks.waitForElement(driver.findElement(By.xpath("//button[contains(text(),'New Browser Tab')]")));

}

public WebElement getRandomIDElement()
{
	return drivertasks.waitForElement(driver.findElement(By.xpath("//p[contains(text(),'I will have random ID')]")));

}

public WebElement getAlertButton()
{
	return drivertasks.waitForElement(driver.findElement(By.id("alert")));

}

public WebElement getTimingAlertButton()
{
	return drivertasks.waitForElement(driver.findElement(By.id("timingAlert")));

}

public WebElement getFirstChangeColorButton()
{
	return drivertasks.waitForElement(driver.findElement(By.id("colorVar")));

}

public WebElement getSecondChangeColorButton()
{
	return drivertasks.waitForElement(driver.findElement(By.id("doubleClick")));

}

public WebElement getDisabledButton()
{
	return drivertasks.waitForElement(driver.findElement(By.id("disabledElement")));

}
}
