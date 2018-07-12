package core.Framework.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection.KeyVal;

public class ExcelRead  implements IReadFile{

	
	public XSSFWorkbook wb=null;
	public XSSFSheet sh=null;
	private final int KEYCOL =0;
	private final int VALUECOL=1;
	private HashMap<String, String> testData = new HashMap<>();
	
	public ExcelRead(String filename){
		
	try {
		   File file = new File(filename);
		   FileInputStream fis = new FileInputStream(file);
	       	  
		  try {
			  wb = new XSSFWorkbook(fis);
			  }  catch (Exception e) {
			System.out.println("unable to locate the file:"+e.getMessage());
		}		  
		  
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
 }

	public void ReadFile(ArrayList<String> sheets){
		for(String sheet : sheets){
			readFile(sheet);
		}
	}
	
	public void ReadWorkBook()
	{
		Iterator sh =wb.iterator();
		while(sh.hasNext()){
			XSSFSheet sheet = (XSSFSheet)sh.next();
			readFile(sheet.getSheetName());
		}
	}
	

	public void readFile(String sheetname){
		sh=wb.getSheet(sheetname);
          Iterator rows = sh.rowIterator();
            while (rows.hasNext()) 
            {
                XSSFRow row = (XSSFRow) rows.next();
                testData.put(row.getCell(KEYCOL).getStringCellValue().trim(),row.getCell(VALUECOL).getStringCellValue().trim());            
            }}
	
	
	
	@Override
	public  String getValue(String key) {
		if(testData.containsKey(key)){
		return testData.get(key).toString();
		}
		else
		{
		return "";	
		}
	}
	
	@Override
	public HashMap<String, String> getTestData() {
		// TODO Auto-generated method stub
		return testData;
	}
	
}
