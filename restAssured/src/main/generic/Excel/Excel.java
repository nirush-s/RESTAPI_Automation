package Excel;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{

	public static String getCellValue(String location,String sheetName,int rowNum,int cellNum)
	{
		Workbook workbook = null;
		Sheet sheet = null;
		String value = null;
		
		try 
		{
			
			File file = new File(location);
			workbook = WorkbookFactory.create(file);
			
		}
		catch(Exception e)
		{
			System.out.println("Excel not found");
		}
		
		try 
		{
			
			sheet = workbook.getSheet(sheetName);
			
		}
		catch(Exception e)
		{
			System.out.println("Sheet not found");
		}
		
		
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);

		
		try 
		{
			
			value = cell.getStringCellValue();
			
		}
		catch(Exception e)
		{
			try
			{
				value = String.valueOf((int)cell.getNumericCellValue());
			}
			

			catch(Exception e1)
			{
				value = "";
			}
		}
		
		
		
		return value;
		
	}
	
	public static int getRowCount(String location,String sheetName)
	{
		Workbook workbook = null;
		Sheet sheet = null;
		int rowCount;
		
		try
		{
			File file = new File(location);
			workbook = WorkbookFactory.create(file);
		}
		catch(Exception e)
		{
			System.out.println("Excel not found");
		}
		
		try
		{
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("Sheet not found");
		}
		
		rowCount = sheet.getPhysicalNumberOfRows();
		
		return rowCount;
		
	}
	
	public static int getCellCount(String location,String sheetName,int rowNum)
	{
		
		
		Workbook workbook = null;
		Sheet sheet = null;
		int cellCount;
		
		try
		{
			File file = new File(location);
			workbook = WorkbookFactory.create(file);
		}
		catch(Exception e)
		{
			System.out.println("Excel not found");
		}
		
		try
		{
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("Sheet not found");
		}
		
		Row row = sheet.getRow(rowNum);
		cellCount = row.getLastCellNum();
		
		System.out.println(row.getLastCellNum());
		System.out.println();
		
		return cellCount;
		
	}
	
	public static int getNumberofSheets(String location)
	{
		
		Workbook workbook = null;
		int sheetCount;
		
		try
		{
			File file = new File(location);
			workbook = WorkbookFactory.create(file);
		}
		catch(Exception e)
		{
			System.out.println("Excel not found");
		}

			sheetCount = workbook.getNumberOfSheets();
			return sheetCount;
	
	}
	
	public static String getSheetName(String location,int i)
	{
		Workbook workbook = null;
		String sheetName;
		
		try
		{
			File file = new File(location);
			workbook = WorkbookFactory.create(file);
		}
		catch(Exception e)
		{
			System.out.println("Excel not found");
		}
		
		sheetName = workbook.getSheetName(i);
		System.out.println(sheetName);
		return sheetName;
	}
}
