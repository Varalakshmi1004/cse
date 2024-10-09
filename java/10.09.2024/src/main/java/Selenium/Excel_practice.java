package Selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_practice {
	public static void main(String[] args) throws Exception
	{
		FileInputStream fin=new FileInputStream("C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws=wb.getSheet("Sheet2");
		Row row;
		row=ws.createRow(0);
		row.createCell(0).setCellValue("Vara");
		row.createCell(1).setCellValue("Siri");
		row.createCell(2).setCellValue("Valli");
		row=ws.createRow(1);
		row.createCell(0).setCellValue("100");
		row.createCell(1).setCellValue("200");
		row.createCell(2).setCellValue("300");
		FileOutputStream fout=new FileOutputStream("C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\Data.xlsx");
		wb.write(fout);
	}
}
