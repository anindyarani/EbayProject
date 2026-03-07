package tests;

import Core.BaseTest;
import Core.DriverManager;
import Pages.AdvanceSearchPage;
import Pages.ElectronicsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Scenario2 extends BaseTest {
    @Test(groups = {"smoke"})
    public void Scenario2() {
        WebDriver driver = DriverManager.getDriver();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ElectronicsPage electronicsPage = new ElectronicsPage(DriverManager.getDriver());
        AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(DriverManager.getDriver());


        loginPage.login(config.getProperty("username"), config.getProperty("password"));
        homePage.verifyIsInHomepage();

        // Ambil keyword dari properties
        String searchKeyword = config.getProperty("keyword2");

        homePage.searchProduct(searchKeyword);

        // Kirim keyword tersebut ke dalam method assertion
        homePage.verifyFirstResultContainsKeyword(searchKeyword);

    }
}
