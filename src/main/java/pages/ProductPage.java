package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonActions;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement productsBtn;

    @FindBy(id = "search_product")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement searchBtn;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
    WebElement addCartBtn;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement viewCartLink;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    WebElement searchedProductsText;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement firstViewProductButton;

    @FindBy(xpath = "//div[contains(@class,'product-information')]")
    WebElement productInformation;

    @FindBy(xpath = "//a[@href='#Women']")
    WebElement womenCategory;

    @FindBy(xpath = "//a[@href='/category_products/1']")
    WebElement dressCategory;

    @FindBy(xpath = "//h2[contains(text(),'Women - Dress Products')]")
    WebElement womenDressProductsTitle;

//    public void clickProducts() {
//        productsBtn.click();
//    }
    
    public void clickProducts() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement products = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Products')]")));

//        products.click();
        CommonActions.clickElement(driver, products);
    }
    

    
//    public void searchProduct(String product) {
//        searchBox.clear();
//        searchBox.sendKeys(product);
//    }
    
    public void searchProduct(String product) {

        CommonActions.sendText(driver, searchBox, product);
    }

//    public void clickSearch() {
//        searchBtn.click();
//    }
    
    public void clickSearch() {

        CommonActions.clickElement(driver, searchBtn);
    }

    public boolean isSearchedProductDisplayed() {
        return searchedProductsText.isDisplayed();
    }

    public void addToCart() {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", addCartBtn);

//      addCartBtn.click();
        CommonActions.clickElement(driver, addCartBtn);
    }

    public void clickViewCart() {
        viewCartLink.click();
    }

//    public void clickFirstViewProduct() {
//        firstViewProductButton.click();
//    }
    
//    public void clickFirstViewProduct() {
//
//    	firstViewProductButton.click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[contains(@class,'product-information')]")));
//    }
    
    public void clickFirstViewProduct() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        firstViewProductButton));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'product-information')]")));
    }

//    public boolean isProductInformationDisplayed() {
//        return productInformation.isDisplayed();
//    }
    
    public boolean isProductInformationDisplayed() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOf(productInformation));

            return productInformation.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public void selectWomenDressCategory() {

//        womenCategory.click();
//
//        dressCategory.click();
    	
    	CommonActions.clickElement(driver, womenCategory);

    	CommonActions.clickElement(driver, dressCategory);
    }

    public boolean isWomenDressProductsTitleDisplayed() {
        return womenDressProductsTitle.isDisplayed();
    }
}