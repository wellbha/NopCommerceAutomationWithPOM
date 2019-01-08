package pageobjectmodelexample;

import org.openqa.selenium.By;

public class RegisterPage extends Utils{
        String timeStamp;
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
        selectByValue(By.name("DateOfBirthDay"),"20");
        //select the value "May" for the Month field of Date of Birth
        selectByIndex(By.name("DateOfBirthMonth"),5);
        //select the value "1950" for the year field of Date of Birth
        selectByValue(By.name("DateOfBirthYear"),"1950");
        emailWithTimeStamp(By.id("Email"));
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
        getActualText(By.xpath("//div[@class='result']"));
        //user should be able to see the message "Your registration completed" if successful
        validation("Your registration completed");
        //click on Log out button
        findElementBy(By.linkText("Log out"));
    }
}
