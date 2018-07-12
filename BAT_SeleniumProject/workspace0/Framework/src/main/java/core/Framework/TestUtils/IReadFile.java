package core.Framework.TestUtils;

import java.io.File;
import java.util.HashMap;

public interface IReadFile {
	
	File file=null;
	
	HashMap<String, String> getTestData();
	
	String  getValue(String key);
	
}

 
	
