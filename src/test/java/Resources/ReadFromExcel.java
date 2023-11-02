package Resources;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	
	public String[][] getDataFromExcel() throws IOException
	{
		String a[][] = new String[3][3];
		FileInputStream fis=new FileInputStream("src/test/java/Resources/LoginCredentials.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		Iterator<Row> rows=sheet.rowIterator();
		
		int i=0,j=0;
		
		rows.next();
			
			while(rows.hasNext()) {
			Row row=rows.next();
			Iterator<Cell> cells =row.cellIterator();
			while(cells.hasNext())
			{
				a[i][j++]=cells.next().getStringCellValue();
				
			
				}
				
				i++;j=0;
			}
			
	
			
			
		return a;
		
	}

}
