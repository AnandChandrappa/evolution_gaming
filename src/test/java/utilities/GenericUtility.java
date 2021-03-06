package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class GenericUtility {
    private WebDriver driver;
    private static int pageTimeout = Integer.parseInt(readConfigs("pageTimeout"));
    private static int elementTimeout = Integer.parseInt(readConfigs("explicitTimeout"));

    public GenericUtility(){
        driver = DriverFactory.getWebDriver();
    }

    public static String readConfigs(String property) {
        String propValue=null;
        try {
            Properties props = new Properties();
            File fs = new File(new File("src"), "/test/resources/Config.properties");
            FileInputStream fis = new FileInputStream(fs.getAbsoluteFile());
            props.load(fis);
            propValue = props.getProperty(property);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propValue;
    }

    public void waitForPageLoad(){
        try{
            Thread.sleep(4000);
            WebDriverWait wait = new WebDriverWait(driver, pageTimeout);
           wait.until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }catch (Exception e){
            e.printStackTrace();
            //throw e;
        }
    }

    public void waitFortextToBePresentInElement (WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, elementTimeout);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean switchToNewWindow(String windowTitle){
        boolean switchWin = false;
        try {
            String winHandle;
            Set<String> handles = driver.getWindowHandles();
            int a = handles.size();
            Iterator it = handles.iterator();
            while (it.hasNext()) {
                winHandle = (String) it.next();
                driver.switchTo().window(winHandle);
                if (driver.getTitle().toLowerCase().contains(windowTitle.toLowerCase())) {
                    switchWin = true;
                    break;
                }
                waitForPageLoad();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return switchWin;
    }

    public void closeAllWindows(){
        try {
            String winHandle;
            Set<String> handles = driver.getWindowHandles();
            int a = handles.size();
            Iterator it = handles.iterator();
            while (it.hasNext()) {
                winHandle = (String) it.next();
                driver.switchTo().window(winHandle);
                driver.close();
                Thread.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeAnWindow(String windowName){
        try {
            String winHandle;
            Set<String> handles = driver.getWindowHandles();
            int a = handles.size();
            Iterator it = handles.iterator();
            while (it.hasNext()) {
                winHandle = (String) it.next();
                driver.switchTo().window(winHandle);
                if (driver.getTitle().contains(windowName)) {
                    driver.close();
                    Thread.sleep(2000);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

