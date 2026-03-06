package tests;

import Core.BaseTest;
import Core.DriverManager;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void loginTest() {
        WebDriver driver = DriverManager.getDriver();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage = new HomePage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));
        homePage.verifyIsInHomepage();
    }

    }
