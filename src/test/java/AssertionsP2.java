import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssertionsP2 {
    public static String baseUrl = "https://www.automationtesting.co.uk";

    @Test
    public void WorkWithAsserts() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        WebElement elementTestStore = driver.findElement(
                By.xpath("//a[@href='http://teststore.automationtesting.co.uk/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementTestStore);
        elementTestStore.click();
        driver.findElement(By.cssSelector("img[alt='Hummingbird printed t-shirt']")).click();
        driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();
        Thread.sleep(2000);
        String total = driver.findElement(By.cssSelector(".product-total > .value")).getText();

        Assert.assertEquals("total price doesn't match", "$26.12", total);

        driver.quit();
    }
}
