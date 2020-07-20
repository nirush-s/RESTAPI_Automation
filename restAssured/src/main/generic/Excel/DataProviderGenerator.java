package Excel;



import java.util.HashMap;
import java.util.Map;

public class DataProviderGenerator
{

	public Object[][] objectGenerator(String excelName)
	{
		
		String excelLocation = "/home/user/Desktop/RestAssuredFramework/RESTAPI_Automation/restAssured/TestData/"+excelName+"";
		String sheetName = Excel.getSheetName(excelLocation, 0);
		int rowCount = Excel.getRowCount(excelLocation,sheetName);
		int numberOfSheets = Excel.getNumberofSheets(excelLocation);
		
		Object[][] data = new Object[rowCount-2][1];

		
		for(int i=2;i<rowCount;i++)
		{

			
			Map<Object, Object> map = new HashMap<Object, Object>();  
			
			//System.out.println("Map created");
			
			for(int j=0;j<numberOfSheets;j++)
			{

				
				String sheetName_1 = Excel.getSheetName(excelLocation,j);
				int cellCount = Excel.getCellCount(excelLocation,sheetName_1,i);

				
				for(int k=0;k<cellCount;k++)
				{
					map.put(Excel.getCellValue(excelLocation,sheetName_1,1,k), Excel.getCellValue(excelLocation,sheetName_1,i,k));
				}				
				
			}		
			
			data[i-2][0] = map;
			
		}
		
		
		
		return data;
		
		
		
	}
	
	
}
