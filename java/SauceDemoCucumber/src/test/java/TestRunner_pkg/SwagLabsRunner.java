package TestRunner_pkg;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import Base_pkg.Base;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/Features/1_login.feature","src/test/java/Features/2_cart.feature"},
		glue="StepDefinition",
		tags="@login or @cart"
		)
 
public class SwagLabsRunner extends Base{
	@BeforeClass
	public static void setUp()
	{
		reportSetUp();
		driverSetUp();
	}
}
 