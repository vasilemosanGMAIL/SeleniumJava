package TestNGfolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class TestNGannotation {
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
            driver.close();
            driver.quit();
        }
    }

    @BeforeMethod
    void signin(){
        driver.get("http://teststore.automationtesting.co.uk");
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        driver.findElement(By.cssSelector("button#submit-login")).click();
    }

    @AfterMethod
    void signOut(){
        driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.linkText("CLOTHES")).click();
        Thread.sleep(2000);
    }

}
