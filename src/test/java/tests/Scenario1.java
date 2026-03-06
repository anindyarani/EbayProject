package tests;

import Core.BaseTest;
import Core.DriverManager;
import Pages.AdvanceSearchPage;
import Pages.ElectronicsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Scenario1 extends BaseTest {
    @Test(groups = {"smoke"})
    public void Scenario1() {
        WebDriver driver = DriverManager.getDriver();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ElectronicsPage electronicsPage = new ElectronicsPage(DriverManager.getDriver());
        AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(DriverManager.getDriver());


        loginPage.login(config.getProperty("username"), config.getProperty("password"));
        homePage.verifyIsInHomepage();
        homePage.moveToElectronicsPage();
        electronicsPage.verifyIsInElectronicsPage();
        electronicsPage.moveToCellPhoneAccessoriesCategory();
        electronicsPage.verifyIsInCellPhoneAccessoriesCategory();
        electronicsPage.moveToAdvanceSearch();
        advanceSearchPage.verifyIsInAdvanceSearch();



    }

}
