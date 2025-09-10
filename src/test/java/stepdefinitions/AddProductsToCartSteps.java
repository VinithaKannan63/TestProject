package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
pages.ProductPage;
pages.CartPage;
import utils.DriverManager;

public class AddProductsToCartSteps {

    private ProductPage productPage = new ProductPage(DriverManager.getDriver());
    private CartPage cartPage = new CartPage(DriverManager.getDriver());

    @Given("the shopper is on the product page")
    public void theShopperIsOnTheProductPage() {
        productPage.navigateToProductPage();
    }

    @When("the shopper clicks {string} for a product")
    public void theShopperClicksAddToCartForAProduct(String button) {
        productPage.clickAddToCartButton();
    }

    @Then("a confirmation alert should be displayed with the message {string}")
    public void aConfirmationAlertShouldBeDisplayedWithTheMessage(String expectedMessage) {
        String actualMessage = productPage.getConfirmationAlertMessage();
        Assert.assertEquals("Confirmation alert message mismatch", expectedMessage, actualMessage);
    }

    @When("navigates to the cart page")
    public void navigatesToTheCartPage() {
        productPage.navigateToCartPage();
    }

    @Then("the cart should display the product with the correct name, price, and quantity")
    public void theCartShouldDisplayTheProductWithTheCorrectDetails() {
        Assert.assertTrue("Product details are incorrect in the cart", cartPage.verifyProductDetails());
    }

    @When("the shopper clicks {string} for Product A")
    public void theShopperClicksAddToCartForProductA(String button) {
        productPage.addSpecificProductToCart("Product A");
    }

    @When("the shopper clicks {string} for Product B")
    public void theShopperClicksAddToCartForProductB(String button) {
        productPage.addSpecificProductToCart("Product B");
    }

    @Then("the cart should display both Product A and Product B with their correct names, prices, and quantities")
    public void theCartShouldDisplayBothProductsWithCorrectDetails() {
        Assert.assertTrue("Product A details are incorrect in the cart", cartPage.verifyProductDetails("Product A"));
        Assert.assertTrue("Product B details are incorrect in the cart", cartPage.verifyProductDetails("Product B"));
    }

    @Given("a product is marked as {string}")
    public void aProductIsMarkedAsOutOfStock(String status) {
        productPage.markProductAsOutOfStock();
    }

    @When("the shopper clicks {string} for the out-of-stock product")
    public void theShopperClicksAddToCartForTheOutOfStockProduct(String button) {
        productPage.clickAddToCartButtonForOutOfStockProduct();
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = productPage.getErrorMessage();
        Assert.assertEquals("Error message mismatch", expectedErrorMessage, actualErrorMessage);
    }

    @Then("the product should not be added to the cart")
    public void theProductShouldNotBeAddedToTheCart() {
        Assert.assertFalse("Out-of-stock product was added to the cart", cartPage.isOutOfStockProductAdded());
    }
}
