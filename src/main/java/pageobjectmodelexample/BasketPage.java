package pageobjectmodelexample;

import org.openqa.selenium.By;

public class BasketPage extends Utils {
    public void checkOutTermsConditions(){
        //click on the CHECKOUT button
        clickElementBy(By.id("checkout"));
    }
    public void termsConditionConfirmation(){
        getActualText(By.id("terms-of-service-warning-box"));
        validation("Please accept the terms of service before the next step.");
    }
}
