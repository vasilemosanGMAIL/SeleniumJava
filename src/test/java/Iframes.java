import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
    public static String baseUrl = "https://www.automationtesting.co.uk";
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
    public void testIframe1() throws InterruptedException {
        driver.get(baseUrl + "/iframe.html");
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".toggle")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        //iframe with youtube video
        driver.switchTo().frame(1);
        driver.findElement(By.cssSelector("[aria-label='Play']")).click();

        Thread.sleep(2000);
    }
}
