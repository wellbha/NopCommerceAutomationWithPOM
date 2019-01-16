package pageobjectmodelexample;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class Utils extends BasePage {
    static String actualResult;
    static Select value;
    static String timestamp;

    // WebDriverWait wait = new WebDriverWait(driver,20);

    //clicking element
    static void clickElementBy(By by){
        driver.findElement(by).click();
    }

    //find the element
    static void findElementBy(By by){
        driver.findElement(by);
    }

    //enter the text in input field
    static void enterText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    //select the element
    static void selectBy(By by){
        driver.findElement(by).isSelected();
    }

    //select by text name from dropdown
    static void selectByText(By by,String data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByVisibleText(data);
    }

    //select by index value from dropdown
    static void selectByIndex(By by, Integer data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByIndex(data);
    }

    //select by value from dropdown
    static void selectByValue(By by, String data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByValue(data);
    }

    //get the text value from the element
    public static String getActualText(By by){
        return actualResult = driver.findElement(by).getText();
    }

    //assert with expected and actual result
    static void validation(String expectedResult){
        Assert.assertEquals(actualResult,expectedResult);
    }

    //select by visible text
    static void select(By by,String data){
        Select value = new Select(driver.findElement(by));
        value.selectByVisibleText(data);
    }

    //wait for visibility of element with given time
    static void explicitWaitForVisibility(By by, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //wait for locator to be clickable for given time in seconds
    public static void waitForLocatorToBeClickable(By by, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //wait for WebElement to be clickable fo given time in seconds
    static void waitForWebElementToBeClickable(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //wiat for element to be invisible
    static void elementToBeInvisible(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //get attribute of element
    public static String getAttributeOfElement(WebElement element, String attr){
        String value = element.getAttribute(attr);
        return value;
    }

    //check if the alert is present
    public boolean isAlertPresent() {
        boolean present = false;
        try {
            // Check the presence of alert
            Alert alert = driver.switchTo().alert();
            // Alert present; set the flag
            present = true;
            // if present consume the alert
            alert.accept();
        } catch (NoAlertPresentException ex) {
            // Alert not present
            ex.printStackTrace();
        }
        return present;
    }

    // get css property of element
    public String getCssPropOfElement(WebElement element, String css){
        String value = element.getCssValue(css);
        return value;
    }

    //scroll to element and click
    public void scrollTillElementFoundAndClick(By by,WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        driver.findElement(by).click();
    }

    //scroll to view element
    public void scrollToElement(By by,WebElement element, int seconds){
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(by);
            Thread.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //get selected value from dropdown
    public String getSelectedValueOfDropdown(By by){
        Select select = new Select(driver.findElement(by));
        WebElement option = select.getFirstSelectedOption();
        String item = option.getText();
        return item;
    }

    //hardcoded email with time stamp
    static void emailWithTimeStamp(By by){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        driver.findElement(by).sendKeys("Bhavin+"+timeStamp+"@home.com");
    }

    //timestamp or date in to string conversation
    public static String timeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("DD.MM.YY.HH.MM.SS");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

    //clear text from inbox/area
    public void clearField(By by){
        driver.findElement(by).clear();
    }

    //clear and enter text in input field
    public void clearAndEnter(By by, String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //checking WebElement present in DOM
    public boolean isElementPresent(By by){
        try{
            driver.findElement(by).isEnabled();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    //checking WebElement is displayed in DOM
    public boolean isElementDisplayed(By by){
        try{
            driver.findElement(by).isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    //Try to click element three times if not available in first go
    public boolean retryForElement(By by) {
        boolean result = false;
        int attempt = 0;
        while (attempt<3){
            try {
                Thread.sleep(10);
                driver.findElement(by).click();
                result = true;
                break;
            }catch (Exception e){}
            attempt++;
        }
        return result;
    }

    //take screenshot of browser
    public void takeScreenShotOfBrowser(String destination_folder) throws IOException {
        File source_folder = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destination_folder = new File ("Destination folder path");
        FileUtils.copyFile(source_folder, new File(destination_folder));
    }

    //take screenshot of current display (full)
    public void takeScreenShotOfCurrentDisplayFull(String destination_folder) throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
//        File destination_folder = new File("Destination folder path");
        ImageIO.write(screenshot.getImage(),"JPG", new File(destination_folder));
    }

    //convert date to string
    public String dateToString(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("ddmmyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }




}
