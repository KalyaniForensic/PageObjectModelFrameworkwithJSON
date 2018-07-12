package core.Framework.TestUtils;

public interface DefineConfig {

	public ReadConfig config = new ReadConfig();
	public String path=System.getProperty("user.dir");
	public ExcelRead reader= new ExcelRead(path+config.getExcelPath());
 	  	
}
