package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;
import utilities.GenericUtility;
import org.junit.Assert;

import java.util.List;


public class resultPage {
    GenericUtility genericUtility;
    WebDriver driver;


    resultPage(){
        PageFactory.initElements(DriverFactory.getWebDriver(),this);
        genericUtility = new GenericUtility();
        this.driver = DriverFactory.getWebDriver();
    }

    @FindBy(id = "today_cnt_sl")
    private WebElement allAdsList;

    @FindBy(xpath = "//tbody//input[@type='checkbox']")
    private List<WebElement> addsCheckbox;

    @FindBy(id = "a_fav_sel")
    private WebElement addSelFav;

    @FindBy(id = "alert_ok")
    private WebElement alert_ok;

    public void clickOnAdvertisement(String advertise){
        try{
            genericUtility.waitForPageLoad();
            Assert.assertTrue("Not in Advertisement result page cannot click on advertisement: "+advertise, allAdsList.isDisplayed());
            String xPath = "//tbody//*[contains(text(),'"+advertise+"')]";
            //xPath = xPath +" | " + xPath +"/ancestor::a";
            xPath = (GenericUtility.readConfigs("executionLang").equals("en")) ? xPath +"/ancestor::a": xPath ;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
            genericUtility.waitForPageLoad();
            driver.findElement(By.xpath(xPath)).click();
            genericUtility.waitForPageLoad();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void verifyResultPage(){
        try {
            Assert.assertTrue("Not in Advertisement result page",allAdsList.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void selectRandomAds(int count){
        try {
            Assert.assertTrue("Advertisement search page is not available",addsCheckbox.size()>0);
            for (int i = 0; i < count; i++) {
                addsCheckbox.get(i).click();
                Thread.sleep(1000);
            }

        }catch (Exception e){
            e.printStackTrace();
            //throw e;
        }
    }

    public void addSelectedToMemo(){
        try {
            Assert.assertTrue("Add Selected to Favourites link not displayed",addSelFav.isDisplayed());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addSelFav);
            addSelFav.click();
            genericUtility.waitForPageLoad();
            alert_ok.click();
            genericUtility.waitForPageLoad();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allAdsList);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

}
