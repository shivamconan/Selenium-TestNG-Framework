package driver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverTasks {
	
	public  WebDriver driver;
	public String browser;
	
	public WebDriver loadDriver(String browser)
	{
		browser = browser.trim();
		this.browser = browser;
		System.out.println(String.format("The browser type is %s", browser));
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\ShivamTraining\\Drivers\\chromedriver.exe" );
			this.driver = new ChromeDriver();
			this.driver.manage().window().maximize() ;
			return driver;
		}
		else if(browser.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "E:\\ShivamTraining\\Drivers\\geckodriver.exe" );
			driver =  new FirefoxDriver();
			driver.manage().window().maximize() ;
			return driver;
		}
		
		else
		{
			System.setProperty("webdriver.gecko.driver", "E:\\ShivamTraining\\Drivers\\geckodriver.exe" );
			driver =  new FirefoxDriver();
			driver.manage().window().maximize() ;
			return driver;
		}		
	}
	
	public void loadURL(String URL)
	{
		driver.get(URL);
	}
	
	public void hoverOn(WebElement element)
	{
		this.getActionsObject().moveToElement(element).build().perform();
	}
	
	public void clickOn(WebElement element)
	{
		this.getActionsObject().moveToElement(element).click().build().perform();		
	}
	
	public void doubleClickOn(WebElement element)
	{
		this.getActionsObject().doubleClick(element).perform();
	}
	
	public void typeTextIn(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	
	public String getTextOf(WebElement element)
	{
		return element.getText();
	}
	
	public Actions getActionsObject()
	{
		Actions action = new Actions(driver);
		return action;
	}
	
	public WebDriverWait getWaitsObject(int seconds)
	{
		return new WebDriverWait(driver, seconds);

	}
	public WebElement waitForElement(WebElement element)
	{
		return this.getWaitsObject(10).until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public Alert waitForAlert()
	{
		return this.getWaitsObject(10).until(ExpectedConditions.alertIsPresent());

	}
	
	public String getAttributeOf(WebElement element, String tag)
	{
		return element.getAttribute(tag);
	}
	
	public void acceptAlert() throws InterruptedException
	{
		waitForAlert().accept();
		/* Alternate way to wait for alert to appear
		int i=0;
		   while(i++<5)
		   {
		        try
		        {
		    		driver.switchTo().alert().accept();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		          continue;
		        }
		   }*/
		
	}
	
	public boolean isButtonEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	public void navigateBack()
	{
		driver.navigate().back();
	}
	public void close()
	{
		driver.close();
	}
	
}
