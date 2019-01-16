package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.testng.Assert;


public class ProductPage extends Utils{
    public void clickOnProduct(){
        explicitWaitForVisibility(By.linkText("Computers"),20);
        //click on Computers
        clickElementBy(By.linkText("Computers"));
        //click on Notebooks
        clickElementBy(By.linkText("Notebooks"));
        //click on the first product in the list
        clickElementBy(By.xpath("//div[@data-productid='4']/div[@class='picture']"));
        //click on the Email a Friend button
        clickElementBy(By.xpath("//input[@value='Email a friend']"));
    }
    public void clickOnProduct1(){
        explicitWaitForVisibility(By.linkText("Computers"),20);
        clickElementBy(By.linkText("Computers"));
        //click on Notebooks
        clickElementBy(By.linkText("Notebooks"));
        //click on the first product in the list
        clickElementBy(By.xpath("//div[@data-productid='4']/div[@class='picture']"));
        //click on ADD TO CART button
        clickElementBy(By.id("add-to-cart-button-4"));
        //click on shopping cart on the notification bar
        clickElementBy(By.xpath("//div[@id='bar-notification']/p/a"));

    }
    public void clickOnProduct2(){
        explicitWaitForVisibility(By.linkText("Computers"),20);
        clickElementBy(By.linkText("Computers"));
        //click on Notebooks
        clickElementBy(By.linkText("Notebooks"));
        //click on the first product in the list
        clickElementBy(By.xpath("//div[@data-productid='4']/div[@class='picture']"));
        //click on ADD TO CART button
        clickElementBy(By.id("add-to-cart-button-4"));
        //click on shopping cart on the notification bar
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bar-notification']/p/a")));
        clickElementBy(By.xpath("//div[@id='bar-notification']/p/a"));
        //select the T&C check box
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice")));
        clickElementBy(By.id("termsofservice"));
        //click on CHECK OUT button
        clickElementBy(By.id("checkout"));
    }
    public void clickOnProduct3(){
        //click on Computers
        clickElementBy(By.linkText("Computers"));
        //click on Notebooks
        clickElementBy(By.linkText("Notebooks"));
        //select the value "Price: High to Low" from sort by field
        select(By.id("products-orderby"),"Price: High to Low");
    }
    public void sortProductConfirmation(){
        explicitWaitForVisibility(By.xpath("//div[@data-productid='7']"),20);
        //verify the products loaded on the page high to low in price by checking first price and last price
        String firstProductPrice = driver.findElement(By.xpath("//div[@data-productid='4']/div[2]/div[3]/div/span")).getText();
        String lastProductPrice = driver.findElement(By.xpath("//div[@data-productid='7']/div[2]/div[3]/div/span")).getText();
        String firstPrice = firstProductPrice.substring(1).replace(",","");
        String lastPrice = lastProductPrice.substring(1).replace(",","");
        Assert.assertTrue(Float.parseFloat(firstPrice)>Float.parseFloat(lastPrice),"Test case:Prices Loaded Incorrectly");

    }

}
