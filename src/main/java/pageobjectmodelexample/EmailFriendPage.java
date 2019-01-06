package pageobjectmodelexample;

import org.openqa.selenium.By;
import org.testng.Assert;

import static pageobjectmodelexample.Utils.clickElementBy;
import static pageobjectmodelexample.Utils.enterText;

public class EmailFriendPage extends BasePage {
    public void emailFriendForRegisteredUser(){
        //enter the value "rakesh@patel.com" in Friend's Email field
        enterText(By.id("FriendEmail"),"rakesh@patel.com");
        //registered email address should be entered in Your email address field
        //Enter the value "Best one for you!!!! in the Personal message field
        enterText(By.id("PersonalMessage"),"Best one for you!!!");
        //click on send email button
        clickElementBy(By.name("send-email"));
    }
    public void emailToFriendConfimationForRegisterUser(){
        //registered user should be able to see the message "Your message has bee sent."
        String expectedResult = "Your message has been sent.";
        String actualResult = driver.findElement(By.xpath("//div[@class='page email-a-friend-page']/div[2]/div[contains(text(),'Your message has been sent.')]")).getText();
        Assert.assertEquals(expectedResult,actualResult,"Test case : Test Fail");
    }

    public void emailFriendForNonRegisterUser(){
        //enter the value "abc@abc.com" in Friend's Email field
        enterText(By.id("FriendEmail"),"abc@abc.com");
        //enter value "def@def.com" in Your Email Address field
        enterText(By.id("YourEmailAddress"),"def@def.com");
        //Enter the value "Best one for you!!!! in the Personal message field
        enterText(By.id("PersonalMessage"),"Best one for you!!!!");
        //click on send email button
        clickElementBy(By.name("send-email"));
    }
    public void emailToFriendConfirmationForNonRegisterUser(){
        //"Only registered customers can use email a friend feature" unsuccessful message should be display
        String expectedResult = "Only registered customers can use email a friend feature";
        String actualResult = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li")).getText();
        Assert.assertEquals(expectedResult,actualResult,"Test case : Test Fail");
    }


}
