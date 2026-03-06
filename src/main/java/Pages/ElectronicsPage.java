package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElectronicsPage extends BasePage {
    private static final Logger log = LogManager.getLogger(ElectronicsPage.class);

    public ElectronicsPage(WebDriver driver) {super(driver);}

    @FindBy(xpath ="//a[normalize-space()='Cell Phones & Accessories']")
    private WebElement cellPhoneCategory;

    @FindBy (xpath ="//a[normalize-space()='Advanced']")
    private WebElement advanceSearch;

    @FindBy (xpath = "//h1[normalize-space()='Electronics']")
    private WebElement electronicsTitlePage;

    @FindBy (xpath = "//a[normalize-space()='Cell Phones & Accessories']")
    private WebElement cellPhonesAccessoriesCategory;

    @FindBy (xpath = "//section[@class='brw-region brw-region--top']")
    private WebElement cellPhoneTitle;

    public void verifyIsInElectronicsPage() {
        // Tunggu elemen muncul (Timeout 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(electronicsTitlePage));

        // Melakukan Assertion
        Assert.assertTrue(electronicsTitlePage.isDisplayed(),
                "Electronics Title Is Not Display : Is Not In Electronics Page");
    }

    public void moveToCellPhoneAccessoriesCategory(){
        waitForElementToBeClickable(cellPhonesAccessoriesCategory);
        cellPhonesAccessoriesCategory.click();
    }

    public void verifyIsInCellPhoneAccessoriesCategory() {
        // Tunggu elemen muncul (Timeout 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cellPhoneTitle));

        // Melakukan Assertion
        Assert.assertTrue(cellPhoneTitle.isDisplayed(),
                "Cell Phone & Accessories Title Is Not Display : Is Not In Cell Phone & Accessories Category");
    }

    public void moveToAdvanceSearch(){
        waitForElementToBeClickable(advanceSearch);
        advanceSearch.click();
    }
}
