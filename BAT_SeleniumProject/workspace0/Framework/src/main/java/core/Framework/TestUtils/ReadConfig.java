package core.Framework.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig    {

	
      Properties prop = new Properties();
	
	public ReadConfig( ){
		
		try {
			String Path= System.getProperty("user.dir");
			
			File  f= new File(Path+"\\src\\main\\java\\core\\Framework\\TestConfig\\Config.properties");
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	
	
	
	public String getExcelPath(){
		return prop.getProperty("ExcelPath");
				
	}
	
	
	
	
}
