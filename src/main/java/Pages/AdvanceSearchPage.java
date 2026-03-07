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

public class AdvanceSearchPage extends BasePage {
    private static final Logger log = LogManager.getLogger(AdvanceSearchPage.class);

    public AdvanceSearchPage(WebDriver driver) {super(driver);}

    @FindBy(id = "_nkw")
    private WebElement keywordTextField;

    @FindBy (xpath = "//label[normalize-space()='Buy It Now']")
    private WebElement buyItNowRadioButton;

    @FindBy (xpath = "//label[normalize-space()='New']")
    private WebElement conditionNewRadioButton;

    @FindBy (xpath = "//fieldset[contains(@class, 'shippingOption')]//label[contains(., 'Free shipping')]")
    private WebElement freeShippingOption;

    @FindBy (xpath = "//select[@name='_sop']")
    private WebElement sortByBestMatchOption;

    @FindBy (xpath = "//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy (xpath = "//div[@class='adv-form__title large-section-title']")
    private WebElement findItemTitle;

    @FindBy (xpath = "//div[@class='field adv-field___sacat']//select[contains(@id,'s0-1-20-4')]")
    private WebElement categoriesDropDownMenu;

    @FindBy (xpath = "//select[contains(@id, '_sacat')]//option[text()='Cell Phones & Accessories']")
    private WebElement cellPhoneCategoriesDropdown;

    @FindBy (xpath = "//button[@class='x-flyout__button']")
    private WebElement buttonFilterApplied;

    @FindBy (xpath = "//label[normalize-space()='Sale items']")
    private WebElement saleItemCheckBox;

    public void verifyIsInAdvanceSearch() {
        // Tunggu elemen muncul (Timeout 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findItemTitle));

        // Melakukan Assertion
        Assert.assertTrue(findItemTitle.isDisplayed(),
                "Find Item Title Is Not Display : Is Not In Advanced Search Page");
    }


    public void advancedSearch(String keyword){
        waitForElementToBeVisible(keywordTextField);
        keywordTextField.sendKeys(keyword);
        waitForElementToBeClickable(categoriesDropDownMenu);
        categoriesDropDownMenu.click();
        waitForElementToBeVisible(cellPhoneCategoriesDropdown);
        cellPhoneCategoriesDropdown.click();
        waitForElementToBeClickable(buyItNowRadioButton);
        buyItNowRadioButton.click();
        waitForElementToBeClickable(conditionNewRadioButton);
        conditionNewRadioButton.click();
        waitForElementToBeClickable(saleItemCheckBox);
        saleItemCheckBox.click();
        waitForElementToBeVisible(freeShippingOption);
        freeShippingOption.click();
        waitForElementToBeClickable(searchButton);
        searchButton.click();
    }

    public void verifySearchSuccessfully() {
        // Tunggu elemen muncul (Timeout 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(buttonFilterApplied));

        // Melakukan Assertion
        Assert.assertTrue(buttonFilterApplied.isDisplayed(),
                "Save This Search Button Is Not Display : Search Failed");
    }
}
