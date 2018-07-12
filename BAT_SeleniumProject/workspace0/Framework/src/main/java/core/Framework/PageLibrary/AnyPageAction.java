package core.Framework.PageLibrary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import core.Framework.TestBase.BaseClass;
import core.Framework.TestBase.ReadJson;
import core.Framework.TestUtils.ActionMeta;
import core.Framework.TestUtils.BindJson;
import core.Framework.TestUtils.ExcelRead;
import core.Framework.TestUtils.IReadFile;
import core.Framework.TestUtils.Utility;

public class AnyPageAction extends BaseClass {

	
    List<WebElement> elements;
	List<PageAction> pageActions;
	IReadFile reader = null;
	
	/*public AnyPageAction(String configJson, IReadFile reader) 
	{
		pageActions = ReadJson.getPageActions(configJson, "Test");
		BindJson.SetActionValues(pageActions, reader);
				
	}*/
	
	

	public void executeTest(String configJson, IReadFile reader){
		
		//pageActions = ReadJson.getPageActions(configJson, "Test");
		pageActions = ReadJson.getPageActions(configJson, "TestKalyani");
		BindJson.SetActionValues(pageActions, reader);
		for (PageAction pa : pageActions) 
		{
			 WebElement e = null;
		    
			 e=	Utility.getLocator(pa); // get all locators from  utility
		    	   
			if(e != null) 
			{
				switch (pa.ActionMetaType())
				{
					case CHECKBOX :
						BaseClass.selectCheckBox(pa,pa.getValue());
						break;
					case RADIOBUTTON:
						break;
					case SELECTEXT:
						BaseClass.selectDropDownByText(e, pa.getValue());
						break;
					case LINK:
						break;
					case ENTER:
						e.sendKeys(pa.getValue());
						break;
					case CLICK:
						e.click();
						break;
					case NONE:
						break;
						
					default :
					
				}
			}}
				
	
	}}
	
	
