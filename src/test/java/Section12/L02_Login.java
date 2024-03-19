package Section12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class L02_Login {
    private WebDriver driver;

    @BeforeSuite
    void setup() throws IOException {
        Properties prop = new Properties();
        //configure path to the properties file
        String basePath = System.getProperty("user.dir");
        String propertiesFile = basePath + File.separator + "src" + File.separator + "test" +  File.separator + "java" +
                File.separator + "Section12" + File.separator + "L02_config.properties";
        FileInputStream data = new FileInputStream(propertiesFile);
        prop.load(data);
        //Here we can modify what browser to user chrome or edge by
        //updating browser value in the 'L02_config.properties' file
        if(prop.getProperty("browser").equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (prop.getProperty("browser").equals("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            driver = new EdgeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }

    @AfterSuite
    void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void signin() {
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        driver.findElement(By.cssSelector("button#submit-login")).click();
    }

}
