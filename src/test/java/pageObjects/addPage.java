package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericUtility;
import utilities.DriverFactory;
import org.junit.Assert;


public class addPage {
    GenericUtility genericUtility;
    WebDriver driver;

    addPage(){
        PageFactory.initElements(DriverFactory.getWebDriver(),this);
        genericUtility = new GenericUtility();
        this.driver = DriverFactory.getWebDriver();
    }

    @FindBy(id = "a_fav")
    private WebElement favLink;

    @FindBy(id = "msg_div_preload")
    private WebElement addImage;

    @FindBy(id = "alert_ok")
    private WebElement alert_ok;

    public void verifyAdd(String add){
        try {
            String xPath = "//div[@id='msg_div_msg']//*[contains(text(),'"+add+"')]";
            Assert.assertTrue("Unable to locate advertisement: ",addImage.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void addToFavourites() {
        try {
            Assert.assertTrue("Unable to click on Favourite link", favLink.isDisplayed());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", favLink);
            genericUtility.waitForPageLoad();
            favLink.click();
            genericUtility.waitForPageLoad();
            //driver.switchTo().alert().accept();
            alert_ok.click();
            genericUtility.waitForPageLoad();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
