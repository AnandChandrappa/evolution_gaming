package pageObjects;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;
import utilities.GenericUtility;


public class searchPage {
    GenericUtility genericUtility;
    searchPage(){
        PageFactory.initElements(DriverFactory.getWebDriver(),this);
        genericUtility = new GenericUtility();
    }
}
