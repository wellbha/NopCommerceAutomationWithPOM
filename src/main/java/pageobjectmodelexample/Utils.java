package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    static String actualResult;
    static Select value;
    static String timestamp;

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
    static void explicitWaitForVisibility(By by){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    static void emailWithTimeStamp(By by){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        driver.findElement(by).sendKeys("Bhavin+"+timeStamp+"@home.com");
    }
    static String timeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyyyhhmmss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }
}
