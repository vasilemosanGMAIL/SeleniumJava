import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TravelWebsite {
    public static String baseUrl = "https://www.easyjet.com/en";
    private WebDriver driver;

    @Before
    public void setUp() {
        //Chromedriver is managed by maven here
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
    public void Test1() throws InterruptedException {
        //Explicit waits, are set to individual locators, every 500ms element is checked
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ensCloseBanner"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='origin']"))).clear();//.sendKeys("London");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='origin']"))).sendKeys("London");
        //another syntax for explicit wait
        List<WebElement> origins = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 li>a>span")));

        for(WebElement origin:origins){
            if(origin.getText().contains("Luton")){
                System.out.println(origin.getText());
                origin.click();
            }
        }
        Thread.sleep(1000);

        //filling data in the destination
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='destination']"))).sendKeys("Antalya");
        //another syntax for explicit wait
        List<WebElement> destinations = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-2 li>a>span")));

        for(WebElement destination:destinations){
            if(destination.getText().contains("Antalya")){
                System.out.println(destination.getText());
                destination.click();
            }
        }
        Thread.sleep(1000);
    }

}
