package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.UICommonUtils;

public class ProductPage {

    private WebDriver driver;

    private By addToCartButton = By.id("add-to-cart");
    private By confirmationAlert = By.id("confirmation-alert");
    private By cartPageLink = By.id("cart-page-link");
    private By outOfStockLabel = By.id("out-of-stock");
    private By errorMessage = By.id("error-message");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToProductPage() {
        driver.get("https://example.com/product-page");
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public String getConfirmationAlertMessage() {
        return driver.findElement(confirmationAlert).getText();
    }

    public void navigateToCartPage() {
        driver.findElement(cartPageLink).click();
    }

    public void addSpecificProductToCart(String productName) {
        WebElement product = driver.findElement(By.xpath("//div[text()='" + productName + "']/following-sibling::button"));
        product.click();
    }

    public void markProductAsOutOfStock() {
        driver.findElement(outOfStockLabel).isDisplayed();
    }

    public void clickAddToCartButtonForOutOfStockProduct() {
        driver.findElement(addToCartButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
