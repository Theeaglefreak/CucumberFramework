package Stepdefinations;

import DriverFactoryManager.DriverFactory;
import PageEvents.LoginPage;
import PageEvents.ProductPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ProductSteps {

    private LoginPage login = new LoginPage(DriverFactory.getDriver());
    private ProductPage productPage;

    @Given("User has already logged in to the page")
    public void user_has_already_logged_in_to_the_page(DataTable dataTable) {
        List<Map<String, String>> credlist = dataTable.asMaps();
        String userName = credlist.get(0).get("username");
        String passWord = credlist.get(0).get("Password");
        DriverFactory.getDriver().get("https://www.saucedemo.com");
        productPage = login.doLogin(userName, passWord);
    }

    @Given("User is on Product page")
    public void user_is_on_product_page() {
        String productpagetitle = productPage.titleofProductPage();
        System.out.println("the product page title is" + productpagetitle);
    }

    @Then("User get the product names")
    public void user_get_the_product_names(DataTable ProductlistTable) {

        List<String> Expectedtablelist = ProductlistTable.asList();
        System.out.println(Expectedtablelist);
        List<String> Actualtablelist = productPage.getAccountlist();
        System.out.println(Actualtablelist);
        Assert.assertTrue(Expectedtablelist.containsAll(Actualtablelist));

    }

    @Then("the product section count should be {int}")
    public void the_product_section_count_should_be(Integer int1) {
        Assert.assertTrue(productPage.numberofProducts() == int1);

    }


}
