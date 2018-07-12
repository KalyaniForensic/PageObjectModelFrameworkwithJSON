package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop {

	
	
	@Test
	public void dragDrop(){
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://html5demos.com/drag/");
		
		WebElement from =driver.findElement(By.id("two"));
		
		WebElement to = driver.findElement(By.id("bin"));
		
		
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
	}
}
