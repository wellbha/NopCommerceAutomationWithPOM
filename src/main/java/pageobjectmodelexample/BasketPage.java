package pageobjectmodelexample;

import org.openqa.selenium.By;

public class BasketPage extends Utils {
   By checkout = By.id("checkout");
   By terms = By.id("terms-of-service-warning-box");

   public void checkOutTermsConditions(){
        //click on the CHECKOUT button
        clickElementBy(checkout);
    }
    public void termsConditionConfirmation(){
        getActualText(terms);
        validation("Please accept the terms of service before the next step.");
    }
}
