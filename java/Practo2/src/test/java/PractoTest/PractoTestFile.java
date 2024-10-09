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
	
	//To set the report
	@BeforeClass
	public void setUp()
	{
		reportSetUp();
	}
	
	//To set up the driver and open URL everyTime Before the test method
	@BeforeMethod
	public void url() throws Exception
	{
		driverSetUp();
		openUrl();
	}
	
	//To validate the specialization is same as user selected or not
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
			System.out.println("Test 1 : Specialization is same as Excepted");
			test.log(Status.PASS, "Validate Specialization Test Passed");
		}
		else
		{
			test.log(Status.FAIL, "Validate Specialization Test Failed");
		}
		
	}
	
	//To validate the Booking Details is as same as user selected
	@Test(priority=2)
	public void validateBookingDetails() throws Exception
	{
		home.placeSelection();
		home.specializationSelection();
		test=report.createTest("Validate Booking Details");
		String doctorName=doctors.doctorSelection();
		String date=doctors.slotDateSelection();
		String time=doctors.slotTimeSelection();
		String doctorDD=details.doctorName();
		String slotDateDD=details.slotDate();
		String slotTimeDD=details.slotTime();
		System.out.println("\nAppointment Details");
		System.out.println("Doctor Name : "+doctorDD);
		System.out.println("Visiting Date :"+slotDateDD);
		System.out.println("Visiting Time :"+slotTimeDD);
		if(doctorDD.equals(doctorName)&& date.equals(slotDateDD)&& time.equals(slotTimeDD))
		{
			System.out.println("Test 2 : Booking Details shown is same as expected");
			test.log(Status.PASS, "Validate Booking Details Test Passed");
		}
		else
		{
			test.log(Status.FAIL, "Validate Booking Details Test Failed");
		}
	}
	
	
	//To validate the filter functionality
	@Test(priority=3)
	public void filterValidation() throws Exception
	{
		home.placeSelection();
		home.specializationSelection();
		test=report.createTest("Validate filter");
		boolean validation=doctors.allFilters();
		if(validation)
		{
			System.out.println("Test 3 : Consultation Fee is same as Expected");
			test.log(Status.PASS, "Validate filters Test Passed");
		}
		else
		{
			test.log(Status.FAIL, "Validate filters Test Failed");
		}
		Assert.assertTrue(validation);
	}
	
	//To close the browser after completion of every test method
	@AfterMethod
	public void driverQuit()
	{
		closeBrowser();
	}
	
	//To save the report after all the tests are completed
	@AfterClass
	public void report()
	{
		saveReport();
	}
}
