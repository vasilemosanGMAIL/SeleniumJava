import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagingWaits {
    public static String baseUrl = "https://www.automationtesting.co.uk";
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Maculatura\\Testing\\JavaAutomation\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void RunImplicitWait() throws InterruptedException {
        //Implicit waits, are global set once in a class
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl + "/loader.html");
        driver.findElement(By.cssSelector("button#loaderBtn")).click();

        driver.quit();
    }

    @Test
    public void RunExplicitWait() throws InterruptedException {
        driver.get(baseUrl + "/loader.html");
        //Explicit waits, are set to individual locators, every 500ms element is checked
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#loaderBtn")));

        driver.quit();
    }

    @Test
    public void RunFluentWait() throws InterruptedException {
        driver.get(baseUrl + "/loaderTwo.html");
        Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement para = fluent.until(driver1 -> driver1.findElement(By.cssSelector("#appears")));
        System.out.println(para.getText());
        Thread.sleep(2000);

        driver.quit();
    }
}