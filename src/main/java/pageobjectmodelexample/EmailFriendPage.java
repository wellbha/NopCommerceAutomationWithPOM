package pageobjectmodelexample;

import org.openqa.selenium.By;


public class EmailFriendPage extends Utils {

    By sendmail = By.name("send-email");
    LoadProp loadProp = new LoadProp();

    public void emailFriendForRegisteredUser(){
        //enter the value "rakesh@patel.com" in Friend's Email field
        enterText(By.id("FriendEmail"),loadProp.getProperty("friendEmail1"));
        //registered email address should be entered in Your email address field
        //Enter the value "Best one for you!!!! in the Personal message field
        enterText(By.id("PersonalMessage"),loadProp.getProperty("msgToFriend"));
        //click on send email button
        clickElementBy(sendmail);
    }
    public void emailToFriendConfirmationForRegisterUser(){
        //registered user should be able to see the message "Your message has bee sent."
        getActualText(By.xpath("//div[@class='page email-a-friend-page']/div[2]/div[contains(text(),'Your message has been sent.')]"));
        validation(loadProp.getProperty("friendmsgconfirm"));
    }

    public void emailFriendForNonRegisterUser(){
        //enter the value "abc@abc.com" in Friend's Email field
        enterText(By.id("FriendEmail"),"abc@abc.com");
        //enter value "def@def.com" in Your Email Address field
        enterText(By.id("YourEmailAddress"),"def@def.com");
        //Enter the value "Best one for you!!!! in the Personal message field
        enterText(By.id("PersonalMessage"),loadProp.getProperty("msgToFriend"));
        //click on send email button
        clickElementBy(sendmail);
    }
    public void emailToFriendConfirmationForNonRegisterUser(){
        //"Only registered customers can use email a friend feature" unsuccessful message should be display
        getActualText(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
        validation(loadProp.getProperty("friendmsgdecline"));
    }


}
