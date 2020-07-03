package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver initWebDriver(String executionLang) {
        WebDriver driver=null;
        try {
            String browser = GenericUtility.readConfigs("browser");
            String URL = GenericUtility.readConfigs("applicationURL");
            String pageTimeout = GenericUtility.readConfigs("pageTimeout");
            String elementTimeout = GenericUtility.readConfigs("explicitTimeout");

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    Map<String, Object> prefs = new HashMap<String, Object>();
                    Map<String, Object> langs = new HashMap<String, Object>();
                    langs.put("lv", executionLang);
                    prefs.put("translate", "{'enabled' : true}");
                    prefs.put("translate_whitelists", langs);
                    options.setExperimentalOption("prefs", prefs);

                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
            }

            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pageTimeout), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(elementTimeout), TimeUnit.SECONDS);
            driver.get(URL);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return driver;
    }

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        if(DriverFactory.getWebDriver()== null)
            webDriver.set(driver);
    }

    public static void tearDownDrivers(){
        try {
            if (DriverFactory.getWebDriver() != null) {
                DriverFactory.getWebDriver().quit();
                DriverFactory.webDriver.remove();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


}
