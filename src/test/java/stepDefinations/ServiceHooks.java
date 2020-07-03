package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;
import utilities.GenericUtility;

public class ServiceHooks extends DriverFactory {

    @Before ("@EvolutionGaming")
    public void setup() {
        WebDriver driver = initWebDriver(GenericUtility.readConfigs("executionLang"));
        if (driver!=null) {
            setWebDriver(driver);
        }else {
            throw new RuntimeException("Unable to produce the driver");
        }
    }

    @After("@EvolutionGaming")
    public void tearDown() {
        tearDownDrivers();
    }


    @Before ("@Latvia_EvolutionGaming")
    public void setup2() {
        WebDriver driver = initWebDriver(GenericUtility.readConfigs("executionLang"));
        if (driver!=null) {
            setWebDriver(driver);
        }else {
            throw new RuntimeException("Unable to produce the driver");
        }
    }

    @After("@Latvia_EvolutionGaming")
    public void tearDown2() {
        tearDownDrivers();
    }

}
