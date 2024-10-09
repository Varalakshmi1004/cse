package Sauce;

public class HomePage extends Base
{

	Base base=new Base();
	static int validCredentialsRow=1;
	static int invalidCredentialsRow=1;
	public void driverSetUp()
	{
		base.driverSetUp();
	}
	public void openUrl()
	{
		driver.get("https://www.saucedemo.com/");
	}
	public void validCredentials()
	{
		
	}
}