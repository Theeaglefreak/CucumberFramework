package PageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private By ListofProducts = By.xpath("//div[@class='inventory_item_name']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;

    }

    public int numberofProducts() {
        return driver.findElements(ListofProducts).size();
    }

    public String titleofProductPage() {
        return driver.getTitle();
    }


    public List<String> getAccountlist() {
        ArrayList<String> productNames = new ArrayList<>();
        List<WebElement> listofProducts = driver.findElements(ListofProducts);
        for (WebElement e : listofProducts) {
            productNames.add(e.getText());

        }

        return productNames;
    }

}
