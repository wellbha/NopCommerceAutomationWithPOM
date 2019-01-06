package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.testng.Assert;

import static pageobjectmodelexample.Utils.clickElementBy;

public class BasketPage extends BasePage {
    public void checkOutTermsConditions(){
        //click on the CHECKOUT button
        clickElementBy(By.id("checkout"));
    }
    public void termsConditionConfirmation(){
        String expectedResult = "Please accept the terms of service before the next step.";
        String actualResult = driver.findElement(By.id("terms-of-service-warning-box")).getText();
        Assert.assertEquals(expectedResult,actualResult,"Test case : Test Fail");
    }
}
