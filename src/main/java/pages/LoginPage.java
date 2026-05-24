package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement signupLoginBtn;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement email;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(),'incorrect')]")
    WebElement errorMessage;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInText;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutBtn;

    public void clickSignupLogin() {

        signupLoginBtn.click();
    }

    public void enterEmail(String mail) {

        email.sendKeys(mail);
    }

    public void enterPassword(String pass) {

        password.sendKeys(pass);
    }

    public void clickLoginButton() {

        loginBtn.click();
    }

    public boolean verifyErrorMessage() {

        return errorMessage.isDisplayed();
    }

    public boolean verifyLoginSuccess() {

        return loggedInText.isDisplayed();
    }

    public void clickLogoutButton() {

        logoutBtn.click();
    }

    public boolean verifyLogoutSuccess() {

        return signupLoginBtn.isDisplayed();
    }

    public String getErrorMessageText() {

        return errorMessage.getText();
    }
}