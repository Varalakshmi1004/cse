package PractoPages;

import org.openqa.selenium.By;

import BasePkg.Base;

public class DoctorDetailsPage extends Base {
    By date = By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[1]/span[2]"); //Appointment Dat
    By time = By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/span[2]");//Appointment Time
    By doctor = By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[3]/div/div[2]/div[1]"); //Doctor Name

    //To retrieve the Doctor Name
    public String doctorName() 
    {
        return driver.findElement(doctor).getText();
    }

    //To retrieve the Appointment slotTime
    public String slotTime() 
    {
        return driver.findElement(time).getText();
    }

    //To retrieve the Appointment Slot Date
    public String slotDate() 
    {
        return driver.findElement(date).getText();
    }
}

