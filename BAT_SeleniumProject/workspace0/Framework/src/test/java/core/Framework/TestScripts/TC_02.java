package core.Framework.TestScripts;

import core.Framework.PageLibrary.AnyPageAction;
import core.Framework.TestBase.BaseClass;
import core.Framework.TestUtils.DefineConfig;
import core.Framework.TestUtils.IReadFile;

public class TC_02 extends BaseClass implements DefineConfig{
	
	AnyPageAction action;
	
	public void Registration() throws Throwable {
		reader.readFile("RegistrationDetails");
		 action = new AnyPageAction();
		 action.executeTest("Registration",(IReadFile)reader);
		 Thread.sleep(3000);
	}
	

}
