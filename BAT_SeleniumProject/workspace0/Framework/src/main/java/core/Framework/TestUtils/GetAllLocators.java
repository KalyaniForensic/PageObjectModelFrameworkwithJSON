package core.Framework.TestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import core.Framework.TestBase.BaseClass;


	public class GetAllLocators extends BaseClass implements DefineConfig 
	{
		
		@Test(enabled=true)
		public void webLocators() throws IOException 
		
		{
		
		 	List<WebElement> el = driver.findElements(By.xpath("//*"));
		 	
			System.out.println(Integer.toString(el.size()));
			
			File file =new File(System.getProperty("user.dir")+"\\src\\main\\java\\core\\Framework\\TestData\\WebElementDetails.xlsx");
			
			    	
	    	//Create New workbook

			XSSFWorkbook workbook = new XSSFWorkbook();
			
			// Create a blank sheet
		    XSSFSheet sheet = workbook.createSheet("WebElementsDetails");
		    
		    FileOutputStream fout = new FileOutputStream(file);
			
			 for ( WebElement e : el ) 
			 { 	
				 int rownum=0;
				 
				 Row row = sheet.createRow(rownum);

		            row.createCell(0).setCellValue(e.getTagName());

		            row.createCell(1).setCellValue(e.getAttribute("id"));

		       		    
			    rownum++;
			
					workbook.write(fout);
					
			
				}
			    
		        System.out.println("Webelements written successfully on disk.");
			       
		        
		    }
		    
	        
	        
	        	
	        
		}
	
		
		
	
		
	
	

			
			
	

	
		