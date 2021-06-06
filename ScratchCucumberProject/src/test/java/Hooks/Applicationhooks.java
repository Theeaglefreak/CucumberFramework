package Hooks;

import DriverFactoryManager.DriverFactory;
import Utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Applicationhooks {
    private DriverFactory driverfactory;
    private WebDriver driver;
    private ConfigReader config;
    private Properties prop;

    @Before(order = 0)
    public void beforeeMethode() {
        config = new ConfigReader();
        prop = config.init_prop();


    }

    @Before(order = 1)
    public void beforeeMethode1() {
        String browserName = prop.getProperty("browser");
        driverfactory = new DriverFactory();
        driver = driverfactory.setDriver(browserName);


    }


    @After(order = 0)
    public void afterMethode() {
        driver.quit();
    }

    @After(order = 1)
    public void afterMethode1(Scenario scenariostatus) {

        if (scenariostatus.isFailed()) {
            String scenarrioName = scenariostatus.getName().replaceAll(" ", "_");
            byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenariostatus.attach(sourcepath, "image/png", scenarrioName);

        }


    }


}
