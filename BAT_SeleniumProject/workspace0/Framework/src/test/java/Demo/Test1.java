package Demo;

import org.testng.annotations.Test;

public class Test1 {

	
	@Test(dependsOnMethods= {"testCase2"})
	public void testCase1(){
		
		System.out.println("test case 1");
	}
	
	@Test()
	public void testCase2(){
		System.out.println("test case 2");
		
	}
}
