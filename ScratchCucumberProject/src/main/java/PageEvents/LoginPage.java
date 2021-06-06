package PageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginbutton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String userName) {
        driver.findElement(username).sendKeys(userName);
    }

    public void enterPassword(String passWord) {
        driver.findElement(password).sendKeys(passWord);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void loginbuttonclick() {
        driver.findElement(loginbutton).click();
    }


    public ProductPage doLogin(String usrName, String PasWord)
    {
        driver.findElement(username).sendKeys(usrName);
        driver.findElement(password).sendKeys(PasWord);
        driver.findElement(loginbutton).click();
        return new ProductPage(driver);
    }

}
