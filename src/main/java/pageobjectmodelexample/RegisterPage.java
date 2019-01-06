package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.*;

public class RegisterPage extends Utils{
    public void registration(){
        //click on register button
        clickElementBy(By.linkText("Register"));
        //select the male gender option
        clickElementBy(By.id("gender-male"));
        //enter "MyFirstName" in First name field
        enterText(By.id("FirstName"),"MyFirstName");
        //enter "MySurname" in Last name field
        enterText(By.id("LastName"),"MySurname");
        //select the value "20" for Day field of Date of Birth
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByValue("20");
        //select the value "May" for the Month field of Date of Birth
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByIndex(5);
        //select the value "1950" for the year field of Date of Birth
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("1950");
        DateFormat dateFormat = new SimpleDateFormat("DDMMYYYHHMMSS");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        //enter the value "Bhavin@home.com" in email field
        driver.findElement(By.id("Email")).sendKeys("Bhavin+"+date1+"@home.com");
        //enter the value "My Company" in the company field
        enterText(By.id("Company"),"My Company");
        //tick the Newsletter check box
        selectBy(By.id("Newsletter"));
        //enter the value "mypass" in the Password field
        enterText(By.id("Password"),"mypass");
        //enter the value "mypass" in the Confirm Password field
        enterText(By.id("ConfirmPassword"),"mypass");
        //click on register button
        clickElementBy(By.id("register-button"));
    }
    public void registrationConfirmation(){
        String actualResult = driver.findElement(By.xpath("//div[@class='result']")).getText();
        //user should be able to see the message "Your registration completed" if successful
        String expectedResult = "Your registration completed";
        Assert.assertEquals(expectedResult,actualResult,"Test Fail");
        //click on Log out button
        findElementBy(By.linkText("Log out"));
    }
}
