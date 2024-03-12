import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import static java.lang.Thread.*;

public class LocatorsTests {
    public static String baseUrl = "https://www.automationtesting.co.uk";
//	String generatedString = RandomStringUtils.randomAlphabetic(10);

    @Test
    public void CheckLocators() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Maculatura\\Testing\\JavaAutomation\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/contactForm.html");
        //get element by name
        driver.findElement(By.name("first_name")).sendKeys("abcd");
        sleep(1000);

        driver.get(baseUrl);
        //get element by link
        driver.findElement(By.linkText("ACTIONS")).click();
        sleep(1000);
        //find element by CSS selector
        driver.get(baseUrl + "/buttons.html");
        driver.findElement(By.cssSelector("#btn_one")).click();
        sleep(1000);
        driver.switchTo().alert().accept();

        //Clicking on buttons
        //same selector with Xpath //button[#'btn_three'] or //*[@id="btn_three"]
        driver.findElement(By.cssSelector("button#btn_three")).click();
        sleep(1000);
        driver.switchTo().alert().accept();

        //Sending data to forms
        driver.get(baseUrl + "/contactForm.html");
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Vasile");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Mosan");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("vasilemosan@gmail.com");
        driver.findElement(By.cssSelector("textarea[name='message']"))
                .sendKeys("This is a message from Vasile");
        sleep(1000);

        //Checkboxes
        driver.get(baseUrl + "/dropdown.html");
        System.out.println("I am a message.");
        System.out.println(driver.findElement(By.cssSelector("input#cb_red")).isSelected());
        System.out.println(driver.findElement(By.cssSelector("input#cb_green")).isSelected());
        sleep(1000);
        //Checking if buttons are enabled
        driver.get(baseUrl + "/buttons.html");
        System.out.println("button is enabled? " + driver.findElement(By.cssSelector("button#btn_four")).isEnabled());
        sleep(1000);
        //Working with dropdowns
        driver.get(baseUrl + "/dropdown.html");
        //Select is not working
        //Select = menuItem = new Select(driver.findElement(By.cssSelector("#cars")));
        sleep(1000);
        //Radio buttons
        //[for='demo-priority-low']
        //[for='demo-priority-high']
        driver.findElement(By.cssSelector("[for='demo-priority-low']")).click();
        driver.findElement(By.cssSelector("[for='demo-priority-high']")).click();
        sleep(1000);

        //Assertions
        driver.get(baseUrl);
        String getTitle = driver.getTitle();
        Assert.assertEquals("Homepage", getTitle);

        //Pop ups
        driver.get(baseUrl + "/popups.html");
        sleep(1000);
        driver.findElement(By.cssSelector("[onclick='popup\\(\\)']")).click();
        String MainWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for (String child : handles) {
            if (!MainWindow.equalsIgnoreCase(child)) {
                sleep(1000);
                driver.switchTo().window(child);
                //closing pop up window
                driver.close();
            }
        }

        driver.switchTo().window(MainWindow);
        //Accordions
        driver.get(baseUrl + "/accordion.html");
        for(int i = 0; i<10; i++){
            driver.findElement(By.cssSelector(".accordion > div:nth-of-type(1)")).click();
            driver.findElement(By.cssSelector(".accordion > div:nth-of-type(3)")).click();
            driver.findElement(By.cssSelector(".accordion > div:nth-of-type(5)")).click();
        }

        //Hidden elements
        driver.get(baseUrl + "/hiddenElements.html");
        boolean hidden1 = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(2)")).isDisplayed();
        boolean hidden2  = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(3)")).isDisplayed();
        System.out.println("show if element is hidden: " + hidden1 + " ,show if element is hidden: " + hidden2);

        driver.quit();
    }

}
