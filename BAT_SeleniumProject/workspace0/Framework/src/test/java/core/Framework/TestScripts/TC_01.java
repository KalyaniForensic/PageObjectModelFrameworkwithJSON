package core.Framework.TestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.Framework.PageLibrary.AnyPageAction;
import core.Framework.TestBase.BaseClass;
import core.Framework.TestUtils.DefineConfig;
import core.Framework.TestUtils.IReadFile;


public class TC_01 extends BaseClass implements DefineConfig
{

	AnyPageAction action ;
	
	@Test(enabled=true)
	public void LoginTCValidUser() throws Exception
	{    
		 reader.readFile("LoginData");
		 action = new AnyPageAction();
		 action.executeTest("LoginActionsValidUser",(IReadFile)reader);
		 Thread.sleep(3000);
		 
		 String ValidUser =driver.findElement(By.xpath("//div[3]/h4")).getText();
		 Assert.assertEquals(ValidUser,reader.getValue("username") ,"Test case Pass");
		 driver.findElement(By.xpath("//input[@value='Log out']")).click();
		 String Logout =driver.findElement(By.xpath("//div[3]/h3")).getText();
		 Assert.assertEquals(Logout,"Login" ,"Test case Pass");
		 
	}
	
	@Test(enabled=true)
	public void LoginTCInValidUser() throws Exception
	{    
		 reader.readFile("LoginData");
		 action = new AnyPageAction();
		 action.executeTest("LoginActionsInValidUser",(IReadFile)reader);
		 Thread.sleep(3000);
	/*reader.readFile("Sheet2");
	     action.executeTest("ITsCheckinForm",(IReadFile) reader);
		 
		 Alert alt=driver.switchTo().alert();
		 
		 String InvalidUser=alt.getText();
		 
		 Assert.assertEquals(InvalidUser, "User or Password is not valid","Test case Pass");
		 
		 alt.accept();*/
		 
		 String InvalidUser =driver.findElement(By.xpath("//*[@id='login-form']/div[2]/span/b")).getText();
		 Assert.assertEquals(InvalidUser, "Enter your Email address and password correct","Test case Pass");
		 
		 
	}

		
	}

