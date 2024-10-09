package Selenium;


import java.util.List;
import java.io.FileInputStream;
import java.lang.Thread;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class TestNG_Sauce {
		
		EdgeDriver driver;
		@FindBy(name="user-name") WebElement name;
		@FindBy(css="#password") WebElement password;
		@FindBy(css="#login-button") WebElement login;
		@FindBy(css="#add-to-cart-sauce-labs-backpack") WebElement product1;
		@FindBy(css="#add-to-cart-sauce-labs-bolt-t-shirt") WebElement product2;
		@FindBy(css="#add-to-cart-sauce-labs-onesie") WebElement product3;
		@FindBy(css="#shopping_cart_container > a") WebElement cartIcon;
		@FindBy(css="inventory_item_name") List<WebElement> cartProducts;
		@FindBy(css="#shopping_cart_container > a > span") WebElement cartSize;
		@FindBy(css="#react-burger-menu-btn") WebElement menu;
		@FindBy(css="#logout_sidebar_link") WebElement logout;
		XSSFWorkbook wb;
		FileInputStream fin;
		XSSFSheet ws;
		String filepath="C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\SauceData.xlsx";
		public static int i=1;
		
		@BeforeClass
		public void setUp()
		{
			driver=new EdgeDriver();
			PageFactory.initElements(driver,this);
			driver.manage().window().maximize();
		}
		@BeforeMethod
		public void openUrl()
		{
			driver.get("https://www.saucedemo.com/");
		}
		@Test(invocationCount = 9)
		public void login() throws Exception
		{
			fin=new FileInputStream(filepath);
			wb=new XSSFWorkbook(fin);
			ws=wb.getSheet("Sheet1");
			Row row;
			row=ws.getRow(i);
			i++;
			String username=row.getCell(0).getStringCellValue();
			String pass=row.getCell(1).getStringCellValue();
			name.sendKeys(username);
			Thread.sleep(2000);
			password.sendKeys(pass);
			Thread.sleep(2000);
			login.click();
			name.clear();
			password.clear();
			Thread.sleep(2000);
		}
		/*
		public void add_cart() throws InterruptedException
		{
			product1.click();
			Thread.sleep(2000);
			product2.click();
			Thread.sleep(2000);
			product3.click();
			Thread.sleep(2000);
			cartIcon.click();
			Thread.sleep(3000);
			System.out.println(cartSize.getText());
			if(cartProducts.size()==Integer.parseInt(cartSize.getText()))
			{
				System.out.println("Comparison status: same");
				for(WebElement w:cartProducts)
				{
					System.out.println(w.getText());
				}
			}
		}
		*/
		@AfterMethod
		public void logout() throws InterruptedException
		{
			menu.click();
			Thread.sleep(2000);
			logout.click();
			Thread.sleep(2000);
		}
		
		
}
