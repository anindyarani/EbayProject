package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {super(driver);}

    @FindBy(xpath ="//div[@class='gh-flyout is-left-aligned']//button[@class='gh-flyout__target']")
    private WebElement shopByCategoryDropdownMenu;

    @FindBy (xpath ="//a[.//h3[normalize-space()='Electronics']]")
    private WebElement electronicDropdownCategory;

    @FindBy (xpath = "//a[contains(@href, 'lgout=1')]")
    private WebElement signOutButton;

    @FindBy (xpath = "//button[contains(@class, 'gh-flyout__target') and .//span[contains(text(), 'Hi')]]")
    private WebElement greetingTitle;


    public void verifyIsInHomepage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeClickable(greetingTitle);
        greetingTitle.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(signOutButton));
        } catch (TimeoutException e) {
            // Jika gagal, coba klik sekali lagi (kadang klik pertama hanya fokus, bukan membuka)
            greetingTitle.click();
            wait.until(ExpectedConditions.visibilityOf(signOutButton));
        }
        // Melakukan Assertion
        Assert.assertTrue(signOutButton.isDisplayed(),
                "Sign Out Button Is Not Display : Failed Login");
    }

    public void moveToElectronicsPage(){
        greetingTitle.click();
        wait.until(ExpectedConditions.invisibilityOf(signOutButton));
        waitForElementToBeClickable(shopByCategoryDropdownMenu);
        shopByCategoryDropdownMenu.click();
        waitForElementToBeClickable(electronicDropdownCategory);
        electronicDropdownCategory.click();
    }



}
