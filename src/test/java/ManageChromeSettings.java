import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManageChromeSettings {
    public static String baseUrl = "https://www.automationtesting.co.uk/";
    private WebDriver driver;
    private ChromeOptions options;

    @Before
    public void setUp() {
        //manage certs and capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        options = new ChromeOptions();
        options.merge(cap);
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testChromeOptions() throws InterruptedException{
        driver.get(baseUrl);
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 500)");
        Thread.sleep(1000);
    }
    @Test
    public void testChromeCertificates() throws InterruptedException{
        driver.get("https://expired.badssl.com/");
        Thread.sleep(5000);
    }

    @Test
    public void testChromeCookies() throws InterruptedException{
        driver.get("http://teststore.automationtesting.co.uk/");
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button#submit-login")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("CLOTHES")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("img[alt='Hummingbird printed t-shirt']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();
        //Explicit waits, are set to individual locators, every 500ms element is checked
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > button"))).click();
        Thread.sleep(1000);

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();
        Thread.sleep(3000);
    }
}
