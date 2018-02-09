package util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driver.DriverTasks;

public class utils {
    public DriverTasks drivertasks;
    public WebDriver driver;
	public utils(DriverTasks drivertasks)
	{
	this.drivertasks = drivertasks;
	this.driver = drivertasks.driver;
	}
	public int getRandomIntegerBetween(int min, int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	public String getTodaysDate()
	{
		return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

	}
	public void uploadFile(String path) throws InterruptedException
	{
		File file = new File(path);
		if(drivertasks.browser.equals("chrome"))
		{
		try {
			String uploadScriptPath = "E:\\ShivamTraining\\AutoIT\\AutoIt3\\Scripts\\uploadChrome.au3";
			BufferedWriter writer = new BufferedWriter(new FileWriter(uploadScriptPath));
            writer.write("WinActivate('Open')");
            writer.newLine();
            writer.write("Send('"+file.getAbsolutePath()+"')");
            writer.newLine();
            writer.write("Send('{ENTER}')");
            writer.close();

		} catch (IOException e) {
			System.out.println("Unable to write to upload script");
			e.printStackTrace();
		}
		String navigateScriptPath = "E:\\ShivamTraining\\AutoIT\\AutoIt3\\Scripts\\navigateToPath.exe" ;
		try {
			Runtime.getRuntime().exec(navigateScriptPath);
		} catch (IOException e) {
			System.out.println("Cannot execute navigate Script");
			e.printStackTrace();
		}
		Thread.sleep(7000);
		try {
			String uploadScriptPathExe = "E:\\ShivamTraining\\AutoIT\\AutoIt3\\Scripts\\uploadChrome.exe";
			Runtime.getRuntime().exec(uploadScriptPathExe);
		} catch (IOException e) {
			System.out.println("Cannot execute upload Script");
			e.printStackTrace();
		}
		}
	}
	
	public void uploadFileTest(String path, WebElement upload_button)
	{
		upload_button.sendKeys(path);
	}
	
	public List <String> getTextOf(Select dropdown)
	{
		List <WebElement> selected_options = dropdown.getAllSelectedOptions();
	    List <String> selected_options_text = new ArrayList();
	    for (WebElement selected:selected_options )
	    {
	    	selected_options_text.add(selected.getText());
	    }
	    return selected_options_text;	
	}
	
	public String getCurrentWindow()
	{
		return driver.getWindowHandle();
	}
	
	public String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	public void switchToNewWindow()
	{
		Set <String> handles = driver.getWindowHandles();
		List <String> window_handles = new ArrayList();
		window_handles.addAll(handles);
		String hndl = driver.getWindowHandle();
		for (String temp: handles) {
			if(!hndl.equals(temp))
			{
				driver.switchTo().window(temp);
			}
		}
		//driver.switchTo().window(window_handles.get(window_handles.size()-1));

	}
	
	public void switchToWindow(String window)
	{
		driver.switchTo().window(window);
	}
	
	
	public String getCurrentPageTitle()
	{
		return driver.getTitle();
	}
	
	public void closeWindow()
	{
		driver.close();
	}
}
