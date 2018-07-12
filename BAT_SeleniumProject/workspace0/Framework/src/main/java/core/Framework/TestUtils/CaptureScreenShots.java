package core.Framework.TestUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShots {

	public static File source;
	
	public static String captureScreenshot(WebDriver driver, String screenShotName, String screenShotPath)
	{

		String finalPath = null;

		System.out.println("Dynamic directory is created for Screenshots.");

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			source = ts.getScreenshotAs(OutputType.FILE);
			finalPath = screenShotPath + screenShotName + ".png";
			File destination = new File(finalPath);
			FileUtils.copyFile(source, destination);
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

		return finalPath;

	}
}
