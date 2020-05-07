package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven 
{

	public void test() throws IOException
	{
		
		
		FileInputStream fis = new FileInputStream("/Users/300069257/Desktop/REST ASSURED/restAssured/Excel/Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet;
		
		//workbook.getSheet(name)
		
		int nfs = workbook.getNumberOfSheets();
		
		for(int i=1;i<=nfs;i++)
		{
			
			if(workbook.getSheetName(i).equals("Sheet1"))
			{
				
				sheet = workbook.getSheetAt(i);
				
				
				Iterator<Row> rows  = sheet.iterator();
				Row firstRow = rows.next();
				
				
				Iterator<Cell> cells  = firstRow.cellIterator();
				
				while(cells.hasNext())
				{
					
					Cell cellValue = cells.next();
					if(cellValue.getStringCellValue().equals("TestCase"))
					{
						
					}
					
				}
				
				
				
				
				
			}
			
		}
		
		
		
		
		
	}
	
	
	
}
