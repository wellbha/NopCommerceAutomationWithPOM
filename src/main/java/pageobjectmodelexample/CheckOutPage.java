package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static pageobjectmodelexample.Utils.*;

public class CheckOutPage extends Utils {
    public void checkOutDetails(){
        //registered user details will be autofilled
        //select the value "United Kingdom" in the country field
        select(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        //enter "Wembley" in the city field
        enterText(By.id("BillingNewAddress_City"),"Wembley");
        //enter the value "123 First Street" in Address 1 field
        enterText(By.id("BillingNewAddress_Address1"),"123 First Street");
        //enter the value "HA1 1NA" in the zip postal code field
        enterText(By.id("BillingNewAddress_ZipPostalCode"),"HA1 1NA");
        //enter the value "07866638787" in the phone number field
        enterText(By.id("BillingNewAddress_PhoneNumber"),"07866638787");
        //click on continue button
        clickElementBy(By.id("billing-buttons-container"));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping-method-buttons-container")));
        //accept default value and click on continue button
        clickElementBy(By.id("shipping-method-buttons-container"));
        //click on credit card radio button
        clickElementBy(By.id("paymentmethod_1"));
        //click on continue button
        clickElementBy(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        //enter the value "Ramesh Patel" in the card holder name field
        enterText(By.id("CardholderName"),"Ramesh Patel");
        //enter the value "4111 1111 1111 1111" in the card number field
        enterText(By.id("CardNumber"),"4111 1111 1111 1111");
        //select the value "02" in the expiry month field
        Select expiryMonth = new Select(driver.findElement(By.id("ExpireMonth")));
        expiryMonth.selectByValue("2");
        //select the value "2020" in the expiry year value
        Select expiryYear = new Select(driver.findElement(By.id("ExpireYear")));
        expiryYear.selectByValue("2020");
        //enter the value "737" in the card code field
        enterText(By.id("CardCode"),"737");
        //click on continue button
        clickElementBy(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        //click on confirm button
        clickElementBy(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
    }
    public void checkOutConfirmation(){
        //"Your order has been successfully processed!" message should be displayed
        getActualText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        validation("Your order has been successfully processed!");
    }
}
