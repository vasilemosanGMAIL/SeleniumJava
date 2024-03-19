package TestNGfolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class TestingParameters {
    private static String baseUrl = "https://www.automationtesting.co.uk/";
    private WebDriver driver;

    @BeforeSuite
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Parameters({"email", "password"})
    @Test
    public void signIn(String email, String password) throws InterruptedException {
        driver.get("http://teststore.automationtesting.co.uk");
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button#submit-login")).click();
    }


}
