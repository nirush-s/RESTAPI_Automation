package Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import Excel.DataProviderClass;
import libraryTest.BookDetails;

public class TestScenario 
{

	@Test(dataProvider = "DataProvider",dataProviderClass = DataProviderClass.class)
	public void testScenario(Map<String,String> map)
	{
		BookDetails bookdetails = new BookDetails();
		bookdetails.postMethod(map);
	}
	
	
}
