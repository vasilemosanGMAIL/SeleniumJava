import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserTabs {
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
    public void testBrowserTabs1() throws InterruptedException {
        driver.get(baseUrl + "/browserTabs.html");
        Thread.sleep(2000);
        for(int i = 0; i < 2; i++){
            driver.findElement(By.xpath(
                    "//input[@value='Open Tab']")).click();
        }
        //creating a new ArrayList objects, will be sorted by window ID
        List<String> windowsHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("There are " + windowsHandles.size() + " tabs open");


        for(String item : windowsHandles){
            Thread.sleep(2000);
            driver.switchTo().window(item);
        }
        //Here we are moving back to the default window
        Thread.sleep(2000);
        driver.switchTo().window(windowsHandles.get(0));
    }
}
