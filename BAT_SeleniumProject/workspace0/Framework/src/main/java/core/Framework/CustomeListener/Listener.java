package core.Framework.CustomeListener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import core.Framework.TestUtils.Utility;

public class Listener extends Utility implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
	
		log.info("test case has finished and test details are:"+arg0);
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	log.info("test case hase failed and test case details areL"+arg0);	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		if(!result.isSuccess()){
			String UserDirectory=System.getProperty("user.dir");
			String CustomLocation="\\src\\main\\java\\Results";
			String FailureImageFileName=UserDirectory+CustomLocation+result.getMethod().getMethodName()+".png";
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File(FailureImageFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		log.info("Test case has skipped and test case details are:"+arg0);
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		log.info("test case has started and test case details are:"+arg0);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		log.info("Test case has successfully executed and test detials are:"+arg0);
		
	}

}
