package Stepdefinations;

import DriverFactoryManager.DriverFactory;
import PageEvents.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private  LoginPage loginpageobject= new LoginPage(DriverFactory.getDriver());

    @Given("User is on log in page")
    public void user_is_on_log_in_page() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("User enters log in id {string}")
    public void user_enters_log_in_id(String Username) {
        loginpageobject.enterUsername(Username);

    }

    @When("User enters password {string}")
    public void user_enters_password(String Password) {
        loginpageobject.enterPassword(Password);
    }

    @When("User clicks on log in button")
    public void user_clicks_on_log_in_button() {
        loginpageobject.loginbuttonclick();
    }

    @Then("User gets the title of the Home page")
    public void user_gets_the_title_of_the_Home_page() {
        String Homepagetitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(Homepagetitle, "Swag Labs");
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String pagetitle) {
        String Loginpagetitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(Loginpagetitle, pagetitle);
    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {

    }

}
