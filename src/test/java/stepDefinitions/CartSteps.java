package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.ProductPage;

public class CartSteps extends BaseClass {

    CartPage cartPage;

    ProductPage productPage;

    ProductDetailsPage productDetailsPage;

    @Given("User opens cart page")
    public void user_opens_cart_page() {

        cartPage = new CartPage(driver);

        cartPage.clickCart();
    }

    @Then("Cart page should display")
    public void cart_page_should_display() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @Given("User adds product with quantity {string}")
    public void user_adds_product_with_quantity(String quantity) {

        productPage = new ProductPage(driver);

        productPage.clickProducts();

        productPage.clickFirstViewProduct();

        productDetailsPage = new ProductDetailsPage(driver);

        productDetailsPage.updateQuantity(quantity);

        productDetailsPage.clickAddToCart();

        productDetailsPage.clickViewCart();

        cartPage = new CartPage(driver);
    }

    @Then("Product quantity should be {string}")
    public void product_quantity_should_be(String expectedQuantity) {
        Assert.assertEquals(cartPage.getProductQuantity(), Integer.parseInt(expectedQuantity));
    }

    @When("User removes product")
    public void user_removes_product() {
        cartPage.removeProduct();
    }

    @Then("Cart should update successfully")
    public void cart_should_update_successfully() {
        Assert.assertTrue(cartPage.isCartUpdated());
    }

    @Then("Total amount should be correct")
    public void total_amount_should_be_correct() {
        Assert.assertTrue(cartPage.isTotalAmountCorrect());
    }
}