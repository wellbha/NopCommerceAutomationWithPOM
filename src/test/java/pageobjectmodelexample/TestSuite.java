package pageobjectmodelexample;

import org.testng.annotations.Test;

public class TestSuite extends BaseTests {

    RegisterPage register = new RegisterPage();
    HomePage homePage = new HomePage();
    ProductPage product = new ProductPage();
    EmailFriendPage emailFriend = new EmailFriendPage();
    BasketPage basket = new BasketPage();
    CheckOutPage checkout = new CheckOutPage();


    @Test(priority = 1)
    public void userShouldBeAbleToRegisterSuccessfully(){
        homePage.openHomePage();
        register.registration();
        register.registrationConfirmation();
    }
    @Test(priority = 2)
    public void registeredUserShouldBeAbleToSendEmailWithProductSuccessfully(){
        homePage.openHomePage();
        register.registration();
        explicitWait1();
        product.clickOnProduct();
        emailFriend.emailFriendForRegisteredUser();
        emailFriend.emailToFriendConfimationForRegisterUser();
    }
    @Test(priority = 3)
    public void unRegisteredUserShouldNotBeAbleToSendEmail(){
        homePage.openHomePage();
        product.clickOnProduct();
        emailFriend.emailFriendForNonRegisterUser();
        emailFriend.emailToFriendConfirmationForNonRegisterUser();
    }
    @Test(priority = 4)
    public void userNeedToAcceptTermsAndConditionBeforeCheckOut(){
        homePage.openHomePage();
        register.registration();
        explicitWait2();
        product.clickOnProduct1();
        basket.checkOutTermsConditions();
        basket.termsConditionConfirmation();
    }
    @Test(priority = 5)
    public void registeredUserShouldBeAbleToBuyAnySingleProductSuccessfully(){
        homePage.openHomePage();
        register.registration();
        explicitWait1();
        product.clickOnProduct2();
        checkout.checkOutDetails();
        checkout.checkOutConfirmation();
    }
    @Test(priority = 6)
    public void userShouldBeAbleToSortByPriceHighToLow(){
        homePage.openHomePage();
        product.clickOnProduct3();
        explicitWait3();
        product.sortProductConfirmation();
    }


}
