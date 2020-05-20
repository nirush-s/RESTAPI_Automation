package Excel;

import org.testng.annotations.DataProvider;

public class DataProviderClass extends DataProviderGenerator
{

	@DataProvider(name = "DataProvider")
	public Object[][] dataProviderClass()
	{
		
		String excelName = "Post_Data_ExcelModel";

		Object[][] data = objectGenerator(excelName);
		return data;
		//Test
		
	}
	
}
