package Selenium;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_read {
	public static void main(String[] args) throws Exception
	{
		FileInputStream fin=new FileInputStream("C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws= wb.getSheet("Sheet2");
		Row row;
		for(int r=0;r<=ws.getLastRowNum();r++)
		{
			row=ws.getRow(r);
			for(int c=0;c<row.getLastCellNum();c++)
			{
				System.out.println(row.getCell(c).getStringCellValue());
			}
		}
	}
}
