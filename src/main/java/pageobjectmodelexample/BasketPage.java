package pageobjectmodelexample;

import org.openqa.selenium.By;

public class BasketPage extends Utils {
    By checkout = By.id("checkout");
    By terms = By.id("terms-of-service-warning-box");
    LoadProp loadProp = new LoadProp();

   public void checkOutTermsConditions(){
        //click on the CHECKOUT button
        clickElementBy(checkout);
    }
    public void termsConditionConfirmation(){
        getActualText(terms);
        validation(loadProp.getProperty("T&CAcceptance"));
    }
}
