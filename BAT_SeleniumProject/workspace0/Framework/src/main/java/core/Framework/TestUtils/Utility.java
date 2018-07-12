package core.Framework.TestUtils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import core.Framework.PageLibrary.PageAction;

public class Utility {

	public static WebDriver driver;
	
	public Logger log;
	
	/**
	 * this method initialize browser object
	 * 
	 * @param browser
	 * @return
	 */
	public static WebDriver selectBrowser(String browser)
	{
		
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 return driver;
			
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
			return driver;
		}else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		}else{
			Reporter.log("driver object doesnot found");
			return null;
		}
		
		
	}
	
	public void implicitWait(int timeinsec){
       
		Reporter.log("wait for page to load...");
		//driver.manage().timeouts().implicitlyWait(timeinsec, TimeUnit.SECONDS);
				
	}
	
	/**
	 * 
	 * @param element
	 * @param dropdownvalue
	 */
	public void selectDropDownValue(WebElement element,String dropdownvalue){
		Select select = new Select(element);
		Reporter.log("selecting"+dropdownvalue+"dropdown value");
		select.selectByVisibleText(dropdownvalue);
		
	}
	
	/**
	 * 
	 * @param timeToWaitInSeconds
	 */
	public void driverWait(int timeToWaitInSeconds){
		Reporter.log("waiting for"+timeToWaitInSeconds+"seconds");
		try {
			Thread.sleep(timeToWaitInSeconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static WebElement getLocator(PageAction pa){
		
		
		try {
			if(pa.elementAttributeType.toLowerCase().equals("id"))
				return driver.findElement(By.id(pa.elementAttributeValue));
			else if(pa.elementAttributeType.toLowerCase().equals("name"))
				return driver.findElement(By.name(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("classname"))
					|| (pa.elementAttributeType.toLowerCase().equals("class")))
				return driver.findElement(By.className(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("tagname"))
					|| (pa.elementAttributeType.toLowerCase().equals("tag")))
				return driver.findElement(By.className(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("linktext"))
					|| (pa.elementAttributeType.toLowerCase().equals("link")))
				return driver.findElement(By.linkText(pa.elementAttributeValue));
			else if (pa.elementAttributeType.toLowerCase().equals("partiallinktext"))
				return driver.findElement(By.partialLinkText(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("cssselector"))
					|| (pa.elementAttributeType.toLowerCase().equals("css")))
				return driver.findElement(By.cssSelector(pa.elementAttributeValue));
			else if (pa.elementAttributeType.toLowerCase().equals("xpath"))
				return driver.findElement(By.xpath(pa.elementAttributeValue));
			else
				throw new Exception("Unknown locator type '" + pa.elementAttributeType + "'");
		} catch (Exception es) {
			es.printStackTrace();
			return null;
		}
		
	}
	
	
	public static List<WebElement> getLocators(PageAction pa) 
	{     //PageAction pa=null;
    
		try {
			if (pa.elementAttributeType.toLowerCase().equals("id") )
				return driver.findElements(By.id(pa.elementAttributeValue));
			else if (pa.elementAttributeType.toLowerCase().equals("name"))
				return driver.findElements(By.name(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("classname"))
					|| (pa.elementAttributeType.toLowerCase().equals("class")))
				return driver.findElements(By.className(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("tagname"))
					|| (pa.elementAttributeType.toLowerCase().equals("tag")))
				return driver.findElements(By.className(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("linktext"))
					|| (pa.elementAttributeType.toLowerCase().equals("link")))
				return driver.findElements(By.linkText(pa.elementAttributeValue));
			else if (pa.elementAttributeType.toLowerCase().equals("partiallinktext"))
				return driver.findElements(By.partialLinkText(pa.elementAttributeValue));
			else if ((pa.elementAttributeType.toLowerCase().equals("cssselector"))
					|| (pa.elementAttributeType.toLowerCase().equals("css")))
				return driver.findElements(By.cssSelector(pa.elementAttributeValue));
			else if (pa.elementAttributeType.toLowerCase().equals("xpath"))
				return driver.findElements(By.xpath(pa.elementAttributeValue));
			else
				throw new Exception("Unknown locator type '" + pa.elementAttributeType + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
}
