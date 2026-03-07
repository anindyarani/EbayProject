package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {super(driver);
    }



    @FindBy(xpath ="//div[@class='gh-flyout is-left-aligned']//button[@class='gh-flyout__target']")
    private WebElement shopByCategoryDropdownMenu;

    @FindBy (xpath ="//a[.//h3[normalize-space()='Electronics']]")
    private WebElement electronicDropdownCategory;

    @FindBy (xpath = "//a[contains(@href, 'lgout=1')]")
    private WebElement signOutButton;

    @FindBy (xpath = "//button[contains(@class, 'gh-flyout__target') and .//span[contains(text(), 'Hi')]]")
    private WebElement greetingTitle;

    @FindBy (id= "gh-ac")
    private WebElement searchBar;

    @FindBy (id ="gh-cat")
    private WebElement searchCategory;

    @FindBy (id = "gh-search-btn")
    private WebElement searchButton;

    @FindBy (xpath = "//select[@name='_sacat']//option[text()='Cell Phones & Accessories']")
    private WebElement cellPhoneAccessoriesCategory;

    @FindBy(xpath = "(//ul[contains(@class,'srp-results')]//div[@role='heading']//span)[1]")
    private WebElement firstResult;




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
        waitForElementToBeClickable(cellPhoneAccessoriesCategory);
        cellPhoneAccessoriesCategory.click();

    }


    public void searchProduct(String keyword2){
        greetingTitle.click();
        wait.until(ExpectedConditions.invisibilityOf(signOutButton));
        waitForElementToBeVisible(searchBar);
        searchBar.sendKeys(keyword2);
        waitForElementToBeClickable(searchCategory);
        searchCategory.click();
        waitForElementToBeClickable(searchButton);
        searchButton.click();
    }

    public void verifyFirstResultContainsKeyword(String expectedKeyword) {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        longWait.until(ExpectedConditions.urlContains("nkw="));
        waitForElementToBeVisible(firstResult);
        String actualName = firstResult.getText().toLowerCase();
        Assert.assertTrue(actualName.contains(expectedKeyword.toLowerCase()),
                "Search Result Fail: Product '" + actualName +
                        "' does not contain keyword: '" + expectedKeyword + "'");
    }



}
