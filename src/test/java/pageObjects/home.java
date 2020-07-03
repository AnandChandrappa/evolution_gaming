package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;
import utilities.GenericUtility;
import org.junit.Assert;
import java.util.List;

import static utilities.GenericUtility.readConfigs;

public class home {
    GenericUtility genericUtility;
    WebDriver driver;
    String url;

    @FindBy(xpath = "//tbody//h2//a")
    private List<WebElement> sectionHeader;

    @FindBy(id = "today_cnt_sl")
    private WebElement allAdsList;

    public home()  {
        PageFactory.initElements(DriverFactory.getWebDriver(),this);
        genericUtility = new GenericUtility();
        this.driver = DriverFactory.getWebDriver();
        url = GenericUtility.readConfigs("applicationURL");
    }
    enum menuLinkNames{
        login,search,favorites,submit
    }

    public void navigateToCategory(String Section, String Category){
        try {
            String xPath = "//tbody//h2//*[contains(text(),'"+Section+"')]/ancestor::td//div[@class='main_category']//*[contains(text(),'"+Category+"')]";
            //xPath = xPath +" | " + xPath +"/ancestor::a";
            xPath = (GenericUtility.readConfigs("executionLang").equals("en")) ? xPath +"/ancestor::a": xPath ;
            Assert.assertTrue("The requested category not found in the page "+ Category,driver.findElement(By.xpath(xPath)).isDisplayed());
            DriverFactory.getWebDriver().findElement(By.xpath(xPath)).click();
            genericUtility.waitForPageLoad();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void verifyHomePage(){
        try {
            genericUtility.waitForPageLoad();
            Assert.assertTrue("Not in home page", sectionHeader.size() == 12);

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public void navigateHomePage(){
        try {
            driver.get(url);
            genericUtility.waitForPageLoad();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public void clickOnSubcategory(String subCat){
        try {
            String xPath = "//tbody//h4//*[contains(text(),'"+subCat+"')]";
            //xPath = xPath +" | " + xPath +"/ancestor::a";
            Assert.assertTrue("Adds filter list is not available",allAdsList.isDisplayed());
            driver.findElement(By.xpath(xPath)).click();
            genericUtility.waitForPageLoad();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void clickOnMenuLink(menuLinkNames menu){
        String menuName =  (menu.name()=="submit")? "new":menu.name();
        String xpath = "//b[@class='menu_main']//a[contains(@href,'"+menuName+"')]";
        Assert.assertTrue("Unable to locate Menu Link ",driver.findElement(By.xpath(xpath)).isDisplayed());
        driver.findElement(By.xpath(xpath)).click();
        genericUtility.waitForPageLoad();
    }
}
