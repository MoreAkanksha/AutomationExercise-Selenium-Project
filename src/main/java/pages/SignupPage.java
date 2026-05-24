package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.CommonActions;

public class SignupPage {

	WebDriver driver;
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Signup / Login')]")
	WebElement signupLoginLink;
	
	@FindBy(xpath="//input[@data-qa='signup-name']")
	WebElement signupName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement signupEmail;

	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signupButton;
	
	@FindBy(xpath="//p[contains(text(),'Email Address already exist!')]")
	WebElement ExistingEmailMessage;
	
	
	@FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
    WebElement newUserSignupText;

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    WebElement accountInformationText;

    @FindBy(id = "id_gender1")
    WebElement titleMr;

    @FindBy(id = "id_gender2")
    WebElement titleMrs;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "newsletter")
    WebElement newsletter;

    @FindBy(id = "optin")
    WebElement specialOffer;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    public void openRegisterPage() {

        signupLoginLink.click();
    }

    public boolean isNewUserSignupTextVisible() {

        return newUserSignupText.isDisplayed();
    }

    public void enterSignupName(String name) {

        signupName.clear();
        signupName.sendKeys(name);
    }

    public void enterSignupEmail(String email) {

        signupEmail.clear();
        signupEmail.sendKeys(email);
    }

    public void clickSignupButton() {

        signupButton.click();
    }

    public boolean isAccountInformationDisplayed() {

        return accountInformationText.isDisplayed();
    }

    public void selectTitle(String title) {

        if (title.equalsIgnoreCase("Mr")) {

            titleMr.click();

        } else if (title.equalsIgnoreCase("Mrs")) {

            titleMrs.click();
        }
    }

    public void enterPassword(String pass) {

        password.sendKeys(pass);
    }

    public void selectDay(String day) {

        Select select = new Select(days);

        select.selectByValue(day);
    }

    public void selectMonth(String month) {

        Select select = new Select(months);

        select.selectByVisibleText(month);
    }

    public void selectYear(String year) {

        Select select = new Select(years);

        select.selectByValue(year);
    }

    public void selectDateOfBirth(String day, String month, String year) {

        selectDay(day);

        selectMonth(month);

        selectYear(year);
    }

//    public void selectNewsletterIfRequired(boolean required) {
//
//        if (required && !newsletter.isSelected()) {
//
//            newsletter.click();
//        }
//    }
    
    public void selectNewsletterIfRequired(boolean required) {

        if (required && !newsletter.isSelected()) {

            CommonActions.clickElement(driver, newsletter);
        }
    }
    
//    public void selectNewsletterIfRequired(boolean required) {
//
//        if (required && !newsletter.isSelected()) {
//
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//
//            js.executeScript("arguments[0].click();", newsletter);
//        }
//    }
    
    

//    public void selectSpecialOfferIfRequired(boolean required) {
//
//        if (required && !specialOffer.isSelected()) {
//
//            specialOffer.click();
//        }
//    }
    
    public void selectSpecialOfferIfRequired(boolean required) {

        if (required && !specialOffer.isSelected()) {

            CommonActions.clickElement(driver, specialOffer);
        }
    }
    
//    public void selectSpecialOfferIfRequired(boolean required) {
//
//        if (required && !specialOffer.isSelected()) {
//
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//
//            js.executeScript("arguments[0].click();", specialOffer);
//        }
//    }

    public void enterFirstName(String fname) {

        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {

        lastName.sendKeys(lname);
    }

    public void enterCompany(String companyName) {

        company.sendKeys(companyName);
    }

    public void enterAddress(String userAddress) {

        address.sendKeys(userAddress);
    }

    public void selectCountry(String countryName) {

        Select select = new Select(country);

        select.selectByVisibleText(countryName);
    }

    public void enterState(String stateName) {

        state.sendKeys(stateName);
    }

    public void enterCity(String cityName) {

        city.sendKeys(cityName);
    }

    public void enterZipcode(String zip) {

        zipcode.sendKeys(zip);
    }

    public void enterMobileNumber(String mobile) {

        mobileNumber.sendKeys(mobile);
    }

    public void clickCreateAccountButton() {

        createAccountButton.click();
    }
    

    public boolean isAccountCreatedMessageDisplayed() {

        return accountCreatedMessage.isDisplayed();
    }

    public boolean isExistingEmailMessageDisplayed() {

        return ExistingEmailMessage.isDisplayed();
    }

    public String getNameValidationMessage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript(
                "return arguments[0].validationMessage;",
                signupName
        );
    }

    public String getEmailValidationMessage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript(
                "return arguments[0].validationMessage;",
                signupEmail
        );
    }

    public String getPasswordValidationMessage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript(
                "return arguments[0].validationMessage;",
                password
        );
    }

    public String getMobileValidationMessage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript(
                "return arguments[0].validationMessage;",
                mobileNumber
        );
    }

    public void clickContinueButton() {

        continueButton.click();
    }
}


