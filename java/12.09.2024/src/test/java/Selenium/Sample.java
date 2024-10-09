package Selenium;

import org.testng.annotations.*;

public class Sample {
	
		@BeforeMethod
		public void goToHomePage()
		{
			System.out.println("code to go to home page");
		}
		@Test(priority=2)
		public void login()
		{
			System.out.println("code to login");
		}
		@Test(priority=1)
		public void register()
		{
			System.out.println("code to register");
		}
}
