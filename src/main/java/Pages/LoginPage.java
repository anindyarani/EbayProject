package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {super(driver);}

    @FindBy (xpath = "//h1[@id='greeting-msg']")
    private WebElement signInTitle;

    @FindBy (id = "userid")
    private WebElement usernameTextField;

    @FindBy (id = "signin-continue-btn")
    private WebElement signInContinueButton;

    @FindBy (id = "pass")
    private WebElement passwordTextField;

    @FindBy (id = "sgnBt")
    private WebElement signInButton;

    @FindBy (id ="signin-error-msg")
    private WebElement errorMessageLogin;

    @FindBy (xpath ="//div[@class='gh-flyout is-left-aligned']//button[@class='gh-flyout__target']")
    private WebElement shopByCategoryDropdownMenu;

    @FindBy (xpath ="//a[.//h3[normalize-space()='Electronics']]")
    private WebElement electronicDropdownCategory;

    @FindBy (xpath ="//a[normalize-space()='Cell Phones & Accessories']")
    private WebElement cellPhoneCategory;

    @FindBy (xpath ="//a[normalize-space()='Advanced']")
    private WebElement advanceSearch;

    public void login(String username, String password){
        waitForElementToBeVisible(usernameTextField);
        usernameTextField.sendKeys(username);
        waitForElementToBeClickable(signInContinueButton);
        signInContinueButton.click();
        waitForElementToBeVisible(passwordTextField);
        passwordTextField.sendKeys(password);
        waitForElementToBeClickable(signInButton);
        signInButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
    }




















}
