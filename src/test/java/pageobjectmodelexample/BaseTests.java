package pageobjectmodelexample;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BaseTests extends Utils {
    @BeforeMethod //run before every method
    public void openingBrowser() {
        //initializing the chrome driver and passing the url
        //pre conditions
        System.setProperty("webdriver.chrome.driver", "src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod //run after every method
    public void closingBrowser(ITestResult result) {
                    driver.quit();
        }
    }
