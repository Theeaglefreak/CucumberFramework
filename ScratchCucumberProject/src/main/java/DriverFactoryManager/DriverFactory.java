package DriverFactoryManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

    /**
     * This methode is used to initialize the thread local driver on the basis of input browser option provided
     *
     * @param browserName
     * @return
     */

    public  WebDriver setDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tldriver.set(new FirefoxDriver());
        } else {
            System.out.println("Enter a valid browser name " + browserName);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static  synchronized WebDriver getDriver() {

        return tldriver.get();
    }


}
