package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Utils extends BasePage {
    static String actualResult;
    static Select value;

    // WebDriverWait wait = new WebDriverWait(driver,20);

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
    static void selectByText(By by,String data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByVisibleText(data);
    }
    static void selectByIndex(By by, Integer data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByIndex(data);
    }
    static void selectByValue(By by, String data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByValue(data);
    }
    static void getActualText(By by){
        actualResult = driver.findElement(by).getText();
    }
    static void validation(String expectedResult){
        Assert.assertEquals(actualResult,expectedResult);
    }
    static void select(By by,String data){
        Select value = new Select(driver.findElement(by));
        value.selectByVisibleText(data);
    }
}
