package Selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleXL {
	public static void main(String[] args) throws Exception
	{
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("java",Keys.ENTER);
		Thread.sleep(500);
		List<WebElement> lst=driver.findElements(By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]"));
		System.out.println(lst.size());
		FileInputStream fin=new FileInputStream("C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\googleHeading2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fin);  // Open the workbook
        XSSFSheet ws = wb.getSheet("Sheet1");  // Get the desired sheet (change the sheet name if needed)
 
        // Write the search results into the existing Excel sheet
        for (int i = 0; i < lst.size(); i++) {
            WebElement w = lst.get(i);
            String title = w.getText();
            Row row = ws.createRow(i + 1);
            row.createCell(0).setCellValue(title);  // Write the title in the first column
        }
        fin.close();
        FileOutputStream fout = new FileOutputStream("C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\googleHeading2.xlsx");
        wb.write(fout);
        fout.close();
        wb.close();
        driver.quit();
        System.out.println("Search results appended to existing Excel file successfully.");
	}
}
