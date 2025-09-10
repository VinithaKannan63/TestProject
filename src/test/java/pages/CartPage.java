package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By productDetails = By.id("product-details");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyProductDetails() {
        // Logic to verify product details in the cart
        return driver.findElement(productDetails).isDisplayed();
    }

    public boolean verifyProductDetails(String productName) {
        // Logic to verify specific product details in the cart
        return driver.findElement(By.xpath("//div[text()='" + productName + "']")).isDisplayed();
    }

    public boolean isOutOfStockProductAdded() {
        // Logic to check if out-of-stock product is added to the cart
        return driver.findElements(productDetails).isEmpty();
    }
}
