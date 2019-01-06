package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BasePage {

    //static WebDriverWait wait = new WebDriverWait(driver,20);

    static void clickElementBy(By by){
        driver.findElement(by).click();
    }
    static void findElementBy(By by){
        driver.findElement(by);
    }
    static void enterText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    static void selectBy(By by){
        driver.findElement(by).isSelected();
    }
    static void explicitWait1(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Computers")));
    }
    static void explicitWait2(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Computers")));
    }
    static void explicitWait3(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-productid='7']")));
    }

}
