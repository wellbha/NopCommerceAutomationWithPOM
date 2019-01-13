package pageobjectmodelexample;

import org.openqa.selenium.By;


public class EmailFriendPage extends Utils {
    HomePage locObj = new HomePage();

    public void emailFriendForRegisteredUser(){
        //enter the value "rakesh@patel.com" in Friend's Email field
        enterText(By.id("FriendEmail"),"rakesh@patel.com");
        //registered email address should be entered in Your email address field
        //Enter the value "Best one for you!!!! in the Personal message field
        enterText(By.id("PersonalMessage"),"Best one for you!!!");
        //click on send email button
        clickElementBy(locObj.sendmail);
    }
    public void emailToFriendConfirmationForRegisterUser(){
        //registered user should be able to see the message "Your message has bee sent."
        getActualText(By.xpath("//div[@class='page email-a-friend-page']/div[2]/div[contains(text(),'Your message has been sent.')]"));
        validation("Your message has been sent.");
    }

    public void emailFriendForNonRegisterUser(){
        //enter the value "abc@abc.com" in Friend's Email field
        enterText(By.id("FriendEmail"),"abc@abc.com");
        //enter value "def@def.com" in Your Email Address field
        enterText(By.id("YourEmailAddress"),"def@def.com");
        //Enter the value "Best one for you!!!! in the Personal message field
        enterText(By.id("PersonalMessage"),"Best one for you!!!!");
        //click on send email button
        clickElementBy(locObj.sendmail);
    }
    public void emailToFriendConfirmationForNonRegisterUser(){
        //"Only registered customers can use email a friend feature" unsuccessful message should be display
        getActualText(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
        validation("Only registered customers can use email a friend feature");
    }


}
