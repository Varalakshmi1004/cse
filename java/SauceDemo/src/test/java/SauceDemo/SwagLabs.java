package SauceDemo;

import org.testng.Assert;
import BasePackage.Base;
import SauceDemo.Homepage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SwagLabs extends Base{
    Homepage home = new Homepage();
    Productspage product = new Productspage();
    Cartpage cart = new Cartpage();
    SoftAssert softassert=new SoftAssert();
    
    @BeforeClass
    public static void setUp()
    {
    	driverSetUp();
    	openUrl();
    }

    @Test(priority = 1)
    public void loginWithvalidCredentials() throws Exception{
        home.login("standard_user","secret_sauce");
        softassert.assertTrue((product.checkValidLogin()==true),"Failed");
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
    @Test(priority = 3)
    public void loginWithInValidCredentials() {
    	
    	home.login("standard_user","s_sauce");
    	Assert.assertTrue(!home.errorMsg().isEmpty(),"Invalid login Test Passed");
    }
    @AfterClass
    public void driverQuit()
    {
    	home.close_Browser();
    }
    
}

