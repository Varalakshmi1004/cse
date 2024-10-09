package PractoTest;

import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import BasePkg.Base;
import PractoPages.HomePage;
import PractoPages.DoctorDetailsPage;
import PractoPages.DoctorsPage;
public class PractoTestFile extends Base{

	HomePage home=new HomePage();
	DoctorsPage doctors=new DoctorsPage();
	DoctorDetailsPage details=new DoctorDetailsPage();
	@BeforeClass
	public void setUp()
	{
		reportSetUp();
	}
	@BeforeMethod
	public void url() throws Exception
	{
		driverSetUp();
		openUrl();
	}
	@Test(priority=1)
	public void validateSpecialization() throws Exception
	{
		home.placeSelection();
		home.specializationSelection();
		boolean validation=doctors.specialization();
		Assert.assertTrue(validation);
		test=report.createTest("Validate Specialization");
		if(validation)
		{
			test.log(Status.PASS, "Validate Specialization Test Passed");
		}
		else
		{
			test.log(Status.FAIL, "Validate Specialization Test Failed");
		}
		
	}
	
	@Test(priority=2)
	public void validateBookingDetails() throws Exception
	{
		home.placeSelection();
		home.specializationSelection();
		String doctor=doctors.doctorSelection();
		String date=doctors.slotDateSelection();
		String time=doctors.slotTimeSelection();
		String doctorDD=details.doctorName();
		String slotDateDD=details.slotDate();
		String slotTimeDD=details.slotTime();
		System.out.println(doctorDD);
		System.out.println(slotDateDD);
		System.out.println(slotTimeDD);
		test=report.createTest("Validate Booking Details");
		if(doctorDD.equals(doctor)&& date.equals(slotDateDD)&& time.equals(slotTimeDD))
		{
			System.out.println("Books Details shown is same as expected");
			test.log(Status.PASS, "Validate Booking Details Test Passed");
		}
		else
		{
			test.log(Status.FAIL, "Validate Booking Details Test Failed");
		}
	}
	@Test(priority=3)
	public void filterValidation() throws Exception
	{
		home.placeSelection();
		home.specializationSelection();
		test=report.createTest("Validate filter");
		boolean validation=doctors.allFilters();
		if(validation)
		{
			test.log(Status.PASS, "Validate filters Test Passed");
		}
		else
		{
			test.log(Status.FAIL, "Validate filters Test Failed");
		}
		Assert.assertTrue(validation);
	}
	
	@AfterMethod
	public void driverQuit()
	{
		closeBrowser();
	}
	@AfterClass
	public void report()
	{
		saveReport();
	}
}
