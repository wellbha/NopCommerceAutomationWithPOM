package pageobjectmodelexample;


public class HomePage extends BasePage{

       public void openHomePage(){
            LoadProp loadProp = new LoadProp();
            driver.get(loadProp.getProperty("URL"));
    }

}
