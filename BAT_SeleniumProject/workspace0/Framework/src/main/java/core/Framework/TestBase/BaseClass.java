package core.Framework.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import core.Framework.PageLibrary.PageAction;
import core.Framework.TestUtils.CaptureScreenShots;
import core.Framework.TestUtils.Utility;


public class BaseClass extends Utility {

	public static Properties repository = new Properties();
	public static ExtentReports report;
	public static ExtentTest test;
	public File f;
	public FileInputStream FI;
	public static JSONParser pars= new JSONParser();
	public static JSONObject jsObject;
    public static Object obj;
	public static Select select;
	boolean object ;
	public static String ScreenshotPath;
	
	
	
	@BeforeSuite
	public void beforeSuite(ITestContext ctx){
		
		String testSuit = ctx.getCurrentXmlTest().getSuite().getName();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY HH-mm-ss");
		Date date = new Date();
		report = new ExtentReports(System.getProperty("user.dir") +"//Results//"+testSuit+" "+dateFormat.format(date)+"//Extent-Report.html", true);
		ScreenshotPath = System.getProperty("user.dir") + "//Results//"+testSuit+" "+dateFormat.format(date)+"//";		
		report.loadConfig(new File("C:\\BAT_SeleniumProject\\workspace0\\Framework\\extent-config.xml"));
		
	}
	
	
	@BeforeClass
	public void init(){
		loadProperitesFile();
		selectBrowser(repository.getProperty("Browser"));
		//implicitWait(05);
		driver.get(repository.getProperty("URL"));
		
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method Method){
		test = report.startTest(Method.getName());
	}
	
	
	public void loadProperitesFile()
	{
		try {
			f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\core\\Framework\\TestConfig\\Config.properties");   		
			FI= new FileInputStream(f);
			repository.load(FI);
					
			obj = pars.parse(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\core\\Framework\\PageLocators\\read.json" ));
			jsObject = (JSONObject)obj;
				
				}
				catch(FileNotFoundException e) {e.printStackTrace(); }
				catch(IOException e) { e.printStackTrace(); }
				catch(Exception e) {e.printStackTrace(); }						
}
		
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		report.endTest(test);
		
		if(result.getStatus()== ITestResult.FAILURE){
			
			String scrShotPath = CaptureScreenShots.captureScreenshot(driver, result.getName(), ScreenshotPath);
			test.log(LogStatus.FAIL, " due to " + result.getThrowable());
			test.log(LogStatus.INFO, "Test Case has Failed. Snapshot below: " + test.addScreenCapture(scrShotPath));
		}else if (result.getStatus() == ITestResult.SKIP)
			{
				test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			}
		}
		
	
	public static WebElement getLocator(String locator)throws Exception{
		String[] split = locator.split(":");
		String locatorType=split[0];
		String locatorValue=split[1];
		
		if(locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if(locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
		
	}
	
	public static List<WebElement> getLocators(String locator) throws Exception
	{
    
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
	
		if (locatorType.toLowerCase().equals("id") )
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	
	}
	
	
	public static void getAction(String action) throws Exception{
		
		WebElement e;
		String[] split = action.split(":");
		String actiontype = split[2];
		String actionvalue = split[3];
		if(actiontype.equalsIgnoreCase("click"))
		{
			if( getLocator(action).isEnabled())
			{e=explicitWaitForElement(getLocator(action), 10);
			 e.click();}
			}
		else if(actiontype.equalsIgnoreCase("sendKeys"))
			getLocator(action).sendKeys(actionvalue);
		else if(actiontype.equalsIgnoreCase("selectbytext"))
			selectDropDownByText(getLocator(action), actionvalue);
		else if(actiontype.equalsIgnoreCase("selectbyIndex"))
		    selectDropDownByIndex(getLocator(action), actionvalue);	
		else if( actiontype.equalsIgnoreCase("selectbyValue"))
			selectDropDownByValue(getLocator(action), actionvalue);
		else if(actiontype.equalsIgnoreCase("switchwindow"))
		     getWindowHandles();
		else if(actiontype.equalsIgnoreCase("checkboxlist"))
		//	selectCheckBox(action,actionvalue);
	//	else if(actiontype.equalsIgnoreCase("selectRadio"))
			radiobutton_Select(getLocator(action), actionvalue);
		
	}
	
	public static void switchToNewWindow() {
		Set<?> s = driver.getWindowHandles();
		Iterator<?> itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w2);
		}
	
	
	public static void switchToOldWindow() {
		Set<?> s = driver.getWindowHandles();
		Iterator<?> itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w1);
		}
	
	public static void switchToParentWindow() {
		driver.switchTo().defaultContent();
		}
	
	public static void getWindowHandles(){
		String MainWindow=driver.getWindowHandle();
		//to handle all new opened windows 
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1= s1.iterator();
		while(i1.hasNext()){
			String childwindow=i1.next();
			if(!MainWindow.equalsIgnoreCase(childwindow)){
				// switching to the child window
				
				driver.switchTo().window(childwindow);
		}
		}}
	
	
	public static void selectCheckBox(PageAction pa,String text) {
			 	
		  try {
		//	String name=e.getText();
			List<WebElement> list = Utility.getLocators(pa);
			for(WebElement single:list){
				 String singleuser= single.getText();
				 if(singleuser.equalsIgnoreCase(text))
				 single.click();
				
				 break;
				
			 }
		} catch (Exception e1) {
			e1.printStackTrace();
		
		}
	
	}
	
		
	
	/*
	public static void executeTest(String testName)
	
	{
		JSONObject jsonChildObject=(JSONObject) jsObject.get(testName);
		Object level = jsonChildObject.get(testName);	 
		Set keys = jsonChildObject.keySet();
		 Iterator a = keys.iterator();
		    while(a.hasNext()) {
		    	String key = (String)a.next();
		        // loop to get the dynamic key
		        String value = (String)jsonChildObject.get(key);
		        performAction(value);
		        System.out.print("key : "+key);
		        System.out.println(" value :"+value);
		    }
	}
	*/
	
	public static void selectDropDownByText(WebElement element,String text)
	{	
		select = new Select(element);
		select.selectByVisibleText(text);	
	}
	
	public static void selectDropDownByIndex(WebElement element ,String index)
	{
		select = new Select(element);
		select.selectByIndex(Integer.parseInt(index));
	}
	
    public static void selectDropDownByValue(WebElement element ,String value)
    {
		select = new Select(element);
		select.selectByIndex(Integer.parseInt(value));	
	}
    
    public static void scrollDown(int Start, int End)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(Start,End)", "");//0 and 250
    }
    
    public static void scrollUp(int Start, int End)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("scroll(Start, -End);");;//0 and -250
    }
    
	
	public static void performAction(String aName)
	{
	
		try {
			getAction(aName);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
    }
	
	public static void radiobutton_Select(WebElement element,String   Radio) {
		boolean checkstatus;
		checkstatus = element.isSelected();
		if (checkstatus == true) {
		System.out.println("RadioButton is already checked");
		} else {
			element.click();
		System.out.println("Selected the Radiobutton");
		}
		}
	
	
	public static WebElement explicitWaitForElement(WebElement element ,int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement e=wait.until(ExpectedConditions.visibilityOf(element));
		return e;	
	}
	
public static  WebElement getWebJsonElement(String keyname)
{
	try 
	{
		return getLocator((String) jsObject.get(keyname));
		
	} catch (Exception e) {
		
		e.printStackTrace();
		return null;
	}}
	

	public WebElement getWebElement(String KeyName) throws Exception
	{
		return getLocator(repository.getProperty(KeyName));
	}
	
	
	public List<WebElement> getWebElements(String locator) throws Exception
	{
		return getLocators(repository.getProperty(locator));
		
	}

	@AfterClass
	public void flushOut()
	{
		report.endTest(test);		
		report.flush();
		driver.close();
	}
	
}
