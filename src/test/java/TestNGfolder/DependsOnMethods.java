package TestNGfolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class DependsOnMethods {
    private static String baseUrl = "https://teststore.automationtesting.co.uk/index.php?controller=authentication?back=https%3A%2F%2Fteststore.automationtesting.co.uk%2Findex.php";
    private WebDriver driver;

    @BeforeSuite
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }
    @AfterSuite
    void cleanUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void enterEmail() throws InterruptedException {
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        Thread.sleep(3000);
    }

    @Test
    public void enterPassword() throws InterruptedException {
        driver.findElement(By.cssSelector("section input[name='password']")).sendKeys("test123");
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = {"enterPassword"})
    public void clickBtn() throws InterruptedException {
        driver.findElement(By.cssSelector("button#submit-login")).click();
        Thread.sleep(3000);
    }

}
