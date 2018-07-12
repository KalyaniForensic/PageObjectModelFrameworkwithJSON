package core.Framework.TestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
	
import org.openqa.selenium.JavascriptExecutor;

public class GetLocator2 {

	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/insurance/v1/register.php");
		
	 	List<WebElement> el = driver.findElements(By.xpath("//*"));
	 	
		System.out.println(Integer.toString(el.size()));
		
		File file =new File(System.getProperty("user.dir")+"\\src\\main\\java\\core\\Framework\\TestData\\WebElementDetails.xlsx");
		
		    	
    	//Create New workbook

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create a blank sheet
	    XSSFSheet sheet = workbook.createSheet("WebElementsDetails");
	    
	    FileOutputStream fout = new FileOutputStream(file);
	    
		 int rownum=0;
		    Row row = sheet.createRow(rownum);
		 	row.createCell(0).setCellValue("Records");
            row.createCell(1).setCellValue("TagName");
            row.createCell(2).setCellValue("id");
            row.createCell(3).setCellValue("type");
            row.createCell(4).setCellValue("name");
            row.createCell(5).setCellValue("AbsoluteXPath");
            
            rownum++;
		
		 for ( WebElement e : el ) 
	
		 { 
			 String tn=e.getTagName();
			 String id= e.getAttribute("id");
			 String type=e.getAttribute("type");
			 String name =e.getAttribute("name");
			 String links=e.getAttribute("href");
			 
		 
			 if(e.getTagName().contains("input")){
				 
				 Row row2 = sheet.createRow(rownum++);
			 
			    row2.createCell(0).setCellValue(rownum-1);
	            row2.createCell(1).setCellValue(tn);
	            row2.createCell(2).setCellValue(id);
	            row2.createCell(3).setCellValue(type);
	            row2.createCell(4).setCellValue(name);
	            row2.createCell(5).setCellValue(getAbsoluteXPath(e, driver));
	           	
			 } 	
			 
			 if(e.getTagName().contains("a")) 
	           {
				 Row row3 = sheet.createRow(rownum++);
	           row3.createCell(6).setCellValue(links);
	            }
		 }
	
		  
		   workbook.write(fout);
	
	        System.out.println("Webelements written successfully on disk");   
	        driver.close();
	        
	    }
	
	public static String getAbsoluteXPath(WebElement element,WebDriver driver)
	{
		
	    return (String) ((JavascriptExecutor) driver).executeScript(
	            "function absoluteXPath(element) {"+
	                    "var comp, comps = [];"+
	                    "var parent = null;"+
	                    "var xpath = '';"+
	                    "var getPos = function(element) {"+
	                    "var position = 1, curNode;"+
	                    "if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
	                    "return null;"+
	                    "}"+
	                    "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
	                    "if (curNode.nodeName == element.nodeName) {"+
	                    "++position;"+
	                    "}"+
	                    "}"+
	                    "return position;"+
	                    "};"+

	                    "if (element instanceof Document) {"+
	                    "return '/';"+
	                    "}"+

	                    "for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
	                    "comp = comps[comps.length] = {};"+
	                    "switch (element.nodeType) {"+
	                    "case Node.TEXT_NODE:"+
	                    "comp.name = 'text()';"+
	                    "break;"+
	                    "case Node.ATTRIBUTE_NODE:"+
	                    "comp.name = '@' + element.nodeName;"+
	                    "break;"+
	                    "case Node.PROCESSING_INSTRUCTION_NODE:"+
	                    "comp.name = 'processing-instruction()';"+
	                    "break;"+
	                    "case Node.COMMENT_NODE:"+
	                    "comp.name = 'comment()';"+
	                    "break;"+
	                    "case Node.ELEMENT_NODE:"+
	                    "comp.name = element.nodeName;"+
	                    "break;"+
	                    "}"+
	                    "comp.position = getPos(element);"+
	                    "}"+

	                    "for (var i = comps.length - 1; i >= 0; i--) {"+
	                    "comp = comps[i];"+
	                    "xpath += '/' + comp.name.toLowerCase();"+
	                    "if (comp.position !== null) {"+
	                    "xpath += '[' + comp.position + ']';"+
	                    "}"+
	                    "}"+

	                    "return xpath;"+

	                    "} return absoluteXPath(arguments[0]);", element);
	
	   
	}}


