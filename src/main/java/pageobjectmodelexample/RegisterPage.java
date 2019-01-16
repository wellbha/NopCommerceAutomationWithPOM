package pageobjectmodelexample;

import org.openqa.selenium.By;

public class RegisterPage extends Utils{

    By register = By.linkText("Register");
    By email = By.id("Email");
    By register_Btn = By.id("register-button");
    By logoutBtn = By.linkText("Log out");
    LoadProp loadProp = new LoadProp();

    public void registration(){
        //click on register button
        clickElementBy(register);
        //select the male gender option
        clickElementBy(By.id("gender-male"));

        //enter "MyFirstName" in First name field
//        enterText(By.id("FirstName"),"MyFirstName");
        enterText(By.id("FirstName"),loadProp.getProperty("firstname"));
        //enter "MySurname" in Last name field
        enterText(By.id("LastName"),loadProp.getProperty("lastname"));
        //select the value "20" for Day field of Date of Birth
        selectByValue(By.name("DateOfBirthDay"),loadProp.getProperty("DOBDay"));
        //select the value "May" for the Month field of Date of Birth
        selectByIndex(By.name("DateOfBirthMonth"),5);
        //select the value "1950" for the year field of Date of Birth
        selectByValue(By.name("DateOfBirthYear"),loadProp.getProperty("DOBYear"));
        emailWithTimeStamp(email);
        //enter the value "My Company" in the company field
        enterText(By.id("Company"),loadProp.getProperty("CompanyName"));
        //tick the Newsletter check box
        selectBy(By.id("Newsletter"));
        //enter the value "mypass" in the Password field
        enterText(By.id("Password"),loadProp.getProperty("password"));
        //enter the value "mypass" in the Confirm Password field
        enterText(By.id("ConfirmPassword"),loadProp.getProperty("password"));
        //click on register button
        clickElementBy(register_Btn);
    }
    public void registrationConfirmation(){
        getActualText(By.xpath("//div[@class='result']"));
        //user should be able to see the message "Your registration completed" if successful
        validation(loadProp.getProperty("confirmRegistration"));
        //click on Log out button
        findElementBy(logoutBtn);
    }
    public void screenshotForFailTest(){
        //click on register button
        clickElementBy(register);
        //select the male gender option
        clickElementBy(By.id("gander-male"));
    }
}
