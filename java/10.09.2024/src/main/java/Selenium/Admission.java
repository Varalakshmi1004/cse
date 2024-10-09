package Selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Admission {
	
	public static void main(String args[]) throws Exception
	{
		
		FileInputStream fin=new FileInputStream("C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row row;
		row=ws.createRow(0);
		row.createCell(0).setCellValue("Varalakshmi");
		row.createCell(1).setCellValue("9398230309");
		row.createCell(2).setCellValue("varalakshmibudidi@gmail.com");
		row.createCell(3).setCellValue("Animation");
		row.createCell(4).setCellValue("Telangana");
		row.createCell(5).setCellValue("SECUNDERABAD - AS RAO NAGAR");
		row=ws.createRow(1);
		row.createCell(0).setCellValue("Varalakshmi");
		row.createCell(1).setCellValue("939823");
		row.createCell(2).setCellValue("v@gmail.com");
		row.createCell(3).setCellValue("Animation");
		row.createCell(4).setCellValue("Bihar");
		row.createCell(5).setCellValue("PATNA - KANKARBAGH");
		row=ws.createRow(2);
		row.createCell(0).setCellValue("Varalakshmi");
		row.createCell(1).setCellValue("");
		row.createCell(2).setCellValue("");
		row.createCell(3).setCellValue("Animation");
		row.createCell(4).setCellValue("Bihar");
		row.createCell(5).setCellValue("PATNA - KANKARBAGH");
		FileOutputStream fout=new FileOutputStream("C:\\\\Users\\\\VaralakshmiB\\\\Desktop\\\\excelPractice\\\\Data.xlsx");
		wb.write(fout);
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
			driver.get("https://www.arena-multimedia.com/in/en/admissions-corner/admission-enquiry");
				driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-7.name > input")).sendKeys(row.getCell(0).getStringCellValue());
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-8 > input")).sendKeys(row.getCell(1).getStringCellValue());
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-9 > input")).sendKeys(row.getCell(2).getStringCellValue());
				Thread.sleep(3000);
				WebElement course=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/form/p/span[4]/select"));
				Select dropdown=new Select(course);
				dropdown.selectByVisibleText(row.getCell(3).getStringCellValue());
				Thread.sleep(8000);
				WebElement state=driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-11 > select"));
				Select dropdownstate=new Select(state);
				dropdownstate.selectByVisibleText(row.getCell(4).getStringCellValue());
				Thread.sleep(8000);
				WebElement city=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/form/p/span[6]/select"));
				Select dropdowncity=new Select(city);
				dropdowncity.selectByVisibleText(row.getCell(5).getStringCellValue());
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#common_form > div > button")).click();
				Thread.sleep(3000);
		}
		fin.close();
		fout.close();
		wb.close();
		
	}
}
