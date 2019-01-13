package pageobjectmodelexample;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    By checkout = By.id("checkout");
    By terms = By.id("terms-of-service-warning-box");
    By registerBtn = By.id("register-button");
    By logout = By.linkText("Log out");
    By register = By.linkText("Register");
    By email = By.id("Email");
    By sendmail = By.name("send-email");

    public void openHomePage(){
        driver.get("https://demo.nopcommerce.com/");
    }

}
