package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;
import utilities.GenericUtility;

import java.util.List;

public class memoPage {
    GenericUtility genericUtility;
    WebDriver driver;

    memoPage(){
        PageFactory.initElements(DriverFactory.getWebDriver(),this);
        genericUtility = new GenericUtility();
        this.driver = DriverFactory.getWebDriver();
    }
    @FindBy(xpath = "//a[@title='Memo']")
    private WebElement headerMemoLink;

    @FindBy(id = "del_selected_a")
    private WebElement deleteSelectedAdd;

    @FindBy(xpath = "//div[@class='filter_second_line_dv']//a")
    private List<WebElement> filterSecondLineLinks;

    @FindBy(xpath = "//tbody//input[@type='checkbox']")
    private List<WebElement> addsCheckbox;

    public void navigateToMemo(){
        try {
            Assert.assertTrue("Unable to locate Memo link in header", headerMemoLink.isDisplayed());
            headerMemoLink.click();
            genericUtility.waitForPageLoad();
            Assert.assertTrue("Unable to navigate to Memo page", filterSecondLineLinks.size() > 0);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void verifyAddsCount(Integer addsCount){
        try {
            Assert.assertTrue("Unable to navigate to Memo page", filterSecondLineLinks.size() > 0);
            Assert.assertTrue("Number of Adds displayed in Favourite page do not match expected: expected " + addsCount + "Actual " + addsCheckbox.size(), addsCheckbox.size() == addsCount);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void verifyAdd(String add){
        try {
            Assert.assertTrue("Unable to navigate to Memo page", filterSecondLineLinks.size() > 0);
            String xPath = "//tbody//*[contains(text(),'"+add+"')]";
            //xPath = xPath +" | " + xPath +"/ancestor::a";
            xPath = (GenericUtility.readConfigs("executionLang").equals("en")) ? xPath +"/ancestor::a": xPath ;
            Assert.assertTrue("Adds filter list is not available",driver.findElement(By.xpath(xPath)).isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void removeAddFromMemo(){
        try {
            Assert.assertTrue("Need to be in Memo page to remove adds", filterSecondLineLinks.size() > 0);
            Integer addsCount = addsCheckbox.size();
            if (addsCheckbox.size()>0){
                addsCheckbox.get(0).click();
                genericUtility.waitForPageLoad();
                Assert.assertTrue("Delete selected add link is not displayed", deleteSelectedAdd.isDisplayed());
                deleteSelectedAdd.click();
                genericUtility.waitForPageLoad();
                Assert.assertTrue("Adds count is mismatch", addsCheckbox.size() == addsCount-1);
                genericUtility.waitForPageLoad();
            }else Assert.assertTrue("No adds in Memo page",false);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
