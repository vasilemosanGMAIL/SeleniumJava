package TestCases;

import PageObjects.TestStoreLoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestStoreLoginTest {

    @Test
    public void login() {
        var driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://teststore.automationtesting.co.uk/");

        var logPage = new TestStoreLoginPage(driver);
        logPage.getSignIn().click();
        logPage.getEmail().sendKeys("test@teest.com");
        logPage.getPassword().sendKeys("test123");
        logPage.getLoginBtn().click();

        driver.quit();
    }
}