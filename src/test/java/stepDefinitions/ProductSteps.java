package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.ProductPage;

public class ProductSteps extends BaseClass {

    ProductPage productPage;

    @Given("User opens products page")
    public void user_opens_products_page() {

        productPage = new ProductPage(driver);

        productPage.clickProducts();
    }

    @When("User searches product keyword")
    public void user_searches_product_keyword() {

        productPage.searchProduct("dress");

        productPage.clickSearch();
    }

    @Then("Product should display")
    public void product_should_display() {
        Assert.assertTrue(productPage.isSearchedProductDisplayed());
    }

    @When("User adds product into cart")
    public void user_adds_product_into_cart() {
        productPage.addToCart();
    }

    @Then("Product should add successfully")
    public void product_should_add_successfully() {
        productPage.clickViewCart();
    }

    @When("User opens first product details")
    public void user_opens_first_product_details() {
        productPage.clickFirstViewProduct();
    }

    @Then("Product details should display")
    public void product_details_should_display() {
        Assert.assertTrue(productPage.isProductInformationDisplayed());
    }

    @When("User filters products by category")
    public void user_filters_products_by_category() {
        productPage.selectWomenDressCategory();
    }

    @Then("Filtered category products should display")
    public void filtered_category_products_should_display() {
        Assert.assertTrue(productPage.isWomenDressProductsTitleDisplayed());
    }
}