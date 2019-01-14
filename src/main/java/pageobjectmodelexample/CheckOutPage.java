package pageobjectmodelexample;

import org.openqa.selenium.By;

public class CheckOutPage extends Utils {

    LoadProp loadProp = new LoadProp();

    public void checkOutDetails(){
        //registered user details will be autofilled
        //select the value "United Kingdom" in the country field
        select(By.id("BillingNewAddress_CountryId"),loadProp.getProperty("country"));
        //enter "Wembley" in the city field
        enterText(By.id("BillingNewAddress_City"),loadProp.getProperty("cityname"));
        //enter the value "123 First Street" in Address 1 field
        enterText(By.id("BillingNewAddress_Address1"),loadProp.getProperty("addressline"));
        //enter the value "HA1 1NA" in the zip postal code field
        enterText(By.id("BillingNewAddress_ZipPostalCode"),loadProp.getProperty("postcode"));
        //enter the value "07866638787" in the phone number field
        enterText(By.id("BillingNewAddress_PhoneNumber"),loadProp.getProperty("phoneno"));
        //click on continue button
        clickElementBy(By.id("billing-buttons-container"));
        //accept default value and click on continue button
        clickElementBy(By.id("shipping-method-buttons-container"));
        //click on credit card radio button
        clickElementBy(By.id("paymentmethod_1"));
        //click on continue button
        clickElementBy(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        //enter the value "Ramesh Patel" in the card holder name field
        enterText(By.id("CardholderName"),loadProp.getProperty("cardholdername"));
        //enter the value "4111 1111 1111 1111" in the card number field
        enterText(By.id("CardNumber"),loadProp.getProperty("cardno"));
        //select the value "02" in the expiry month field
        selectByValue(By.id("ExpireMonth"),loadProp.getProperty("ExpMonth"));
        //select the value "2020" in the expiry year value
        selectByValue(By.id("ExpireYear"),loadProp.getProperty("ExpYear"));
        //enter the value "737" in the card code field
        enterText(By.id("CardCode"),loadProp.getProperty("cardCode"));
        //click on continue button
        clickElementBy(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        //click on confirm button
        clickElementBy(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
    }
    public void checkOutConfirmation(){
        //"Your order has been successfully processed!" message should be displayed
        getActualText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        validation(loadProp.getProperty("orderConfirmation"));
    }
}
