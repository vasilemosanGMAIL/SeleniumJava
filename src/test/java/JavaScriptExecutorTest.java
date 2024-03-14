import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {
    public static String baseUrl = "https://www.automationtesting.co.uk/";
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
    public void testJavaScriptExecutor1() throws InterruptedException{
        driver.get(baseUrl);
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 500)");
        Thread.sleep(1000);
    }

    @Test
    public void testJavaScriptExecutor2() throws InterruptedException{
        driver.get(baseUrl + "/contactForm.html");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Vasile");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Mosan");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("vasilemosan@gmail.com");
        driver.findElement(By.cssSelector("textarea[name='message']"))
                .sendKeys("This is a message from Vasile");
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        WebElement reset = driver.findElement(By.cssSelector("[type='reset']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        // we can run 2 JavaScript commands at once
        js.executeScript("arguments[0].click(), arguments[1].click()", reset, submit);

        Thread.sleep(1000);
    }
}
