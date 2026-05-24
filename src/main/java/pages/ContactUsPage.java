package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    WebElement contactBtn;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "subject")
    WebElement subject;

    @FindBy(name = "message")
    WebElement message;

    @FindBy(name = "upload_file")
    WebElement upload;

    @FindBy(name = "submit")
    WebElement submitBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    WebElement successMessage;

    public void openContactForm() {
        contactBtn.click();
    }

    public void enterName(String uname) {
        name.sendKeys(uname);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterSubject(String sub) {
        subject.sendKeys(sub);
    }

    public void enterMessage(String msg) {
        message.sendKeys(msg);
    }

    public void uploadFile(String path) {
        upload.sendKeys(path);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

//   public boolean isFormSubmitted() {
//        return successMessage.isDisplayed();
//   }
    
    public boolean isFormSubmitted() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'alert-success')]")));

        return message.isDisplayed();
    }
}