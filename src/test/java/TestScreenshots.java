import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestScreenshots {
    public static String baseUrl = "https://www.automationtesting.co.uk/";
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
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

    public static void screenshotSetup(WebDriver webdriver) throws IOException {
        File scrFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

        String basePath = System.getProperty("user.dir");
        String screenshotPath = basePath + File.separator + "Resources" + File.separator + "Screenshots";
        File screenshotFile = new File(screenshotPath + File.separator + timestampt() + ".png");

        FileUtils.copyFile(scrFile, screenshotFile);
    }

    public static String timestampt() {
        return new SimpleDateFormat("yyy-MM-dd HH-mm-ss").format(new Date());
    }

    @Test
    public void takeScreenshot() throws InterruptedException, IOException {
        driver.get(baseUrl);
        Thread.sleep(1000);
        screenshotSetup(driver);
    }
}
