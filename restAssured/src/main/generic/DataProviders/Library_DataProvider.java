package DataProviders;

import org.testng.annotations.DataProvider;

public class Library_DataProvider 
{
	
	@DataProvider(name = "postMethod_DataProvider")
	public Object[][] postMethod_DataProvider()
	{
		
		return new Object[][]{{"03-09","3"},{"03-09","4"}};
	}
	
}
