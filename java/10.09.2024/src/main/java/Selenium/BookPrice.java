package Selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BookPrice {
 
    public static void main(String[] args) throws Exception 
    {
        String filePath = "C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\BookPrice.xlsx";
        FileInputStream fin = new FileInputStream(filePath);
        XSSFWorkbook wb = new XSSFWorkbook(fin);  // Open the workbook
        XSSFSheet ws = wb.getSheet("Sheet1");  // Get the desired sheet
        Row row;
        row=ws.createRow(0);
		row.createCell(0).setCellValue("BookPrice");
		row.createCell(1).setCellValue("Quantity");
		row.createCell(2).setCellValue("TotalPrice");
		row=ws.createRow(1);
		row.createCell(0).setCellValue(120);
		row.createCell(1).setCellValue(5);
		row=ws.createRow(2);
		row.createCell(0).setCellValue(180);
		row.createCell(1).setCellValue(10);
		row=ws.createRow(3);
		row.createCell(0).setCellValue(198);
		row.createCell(1).setCellValue(7);
		row=ws.createRow(4);
		row.createCell(0).setCellValue(172);
		row.createCell(1).setCellValue(5);
		
        for (int i = 1; i <= ws.getLastRowNum(); i++) {
            row = ws.getRow(i);
            if (row != null) {
                    double value1 = row.getCell(0).getNumericCellValue();
                    double value2 = row.getCell(1).getNumericCellValue();
                    double result = value1 * value2;
                    row.createCell(2).setCellValue(result);
            }
        }
        fin.close();
        FileOutputStream fout = new FileOutputStream(filePath);
        wb.write(fout);
        fout.close();
        wb.close();
        System.out.println("Multiplication completed and saved to the Excel file.");
    }
}
