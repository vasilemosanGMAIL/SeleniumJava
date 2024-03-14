import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        driver.get("https://expired.badssl.com/");
        Thread.sleep(5000);
    }
}
