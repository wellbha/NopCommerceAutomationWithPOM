package pageobjectmodelexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserChoice extends Utils{
LoadProp loadProp = new LoadProp();

    public static final String USERNAME = "kanopatel";
    public static final String ACCESS_KEY = "3fe4a1bb-f3ba-4705-a9c3-d9bf5a3cc068";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public void browser(){
        try {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "71.0");

            caps.setCapability("name","SauceLabTestOnWin10Chrome71");
            caps.setCapability("extendedDebugging","true");

            driver = new RemoteWebDriver(new URL(URL), caps);
            }catch ( Exception e){
            e.printStackTrace();
            }
//            String browser=loadProp.getProperty("browser");
////            String browser=System.getProperty("browser");
//
//        if (browser.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver","src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
//            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
//            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//        } else if (browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe ");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("disable-infobars");
//            options.addArguments("--disable-extensions");
//            options.addArguments("--disable-browser-side-navigation");
//            options.addArguments("--incognito");
//            options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
//            driver = new ChromeDriver(options);
//            driver.manage().window().maximize();
//        } else if (browser.equalsIgnoreCase("ie")) {
//            System.setProperty("webdriver.ie.driver","src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
//            InternetExplorerOptions options = new InternetExplorerOptions();
//            options.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
//            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
//            driver = new InternetExplorerDriver(options);
//            driver.manage().window().maximize();
//        }else{
//            System.out.println("Browser name is empty or typed wrong :"+browser);
//        }
    }
}
