package SauceDemo;

import java.io.FileInputStream;
import BasePackage.Base;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Swag_Labs extends Base{
    Homepage home = new Homepage();
    Productspage product = new Productspage();
    Cartpage cart = new Cartpage();
    SoftAssert softassert=new SoftAssert();
    static FileInputStream file;
    static XSSFWorkbook wb;
    XSSFSheet ws;
    Row row;
    static int validRowCount=1;
    static int invalidRowCount=1;
    
    @BeforeClass
    public static void setUp() throws Exception
    {
    	driverSetUp();
    	file=new FileInputStream("C:\\Users\\VaralakshmiB\\Desktop\\excelPractice\\SauceData.xlsx");
    	wb=new XSSFWorkbook(file);
    }

    @Test(priority = 1,invocationCount=6)
    public void loginWithvalidCredentials() throws Exception{
    	openUrl();
    	ws=wb.getSheet("Sheet1");
    	row=ws.getRow(validRowCount);
        home.login(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
        softassert.assertTrue((product.checkValidLogin()==true),"Failed");
        validRowCount++;
        //product.logout();
    }

    @Test(priority=2)
    public void product_in_cart() throws Exception
    {
    	//home.login("standard_user","secret_sauce");
    	product.addProduct();
    	product.goToCart();
    	cart.removeProduct();
    	cart.checkCart();
    	Assert.assertEquals(cart.actualCartProducts,cart.expectedCartProducts,"Cart products count is not as same as expected");
    	product.logout();
    }
    @Test(priority = 3,invocationCount=2)
    public void loginWithInValidCredentials() {
    	openUrl();
    	ws=wb.getSheet("Sheet2");
    	row=ws.getRow(invalidRowCount);
        home.login(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
    	Assert.assertTrue(!home.errorMsg().isEmpty(),"Invalid login Test Passed");
    	invalidRowCount++;
    }
    @AfterClass
    public void driverQuit()
    {
    	home.close_Browser();
    }
    
}


