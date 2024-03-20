package Section12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    public static WebDriver driver;
    private String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        String basePath = System.getProperty("user.dir");
        String propertiesFile = basePath + File.separator + "src" + File.separator + "test" + File.separator + "java" +
                File.separator + "Section12" + File.separator + "L02_config.properties";
        FileInputStream data = new FileInputStream(propertiesFile);
        prop.load(data);
    }

    public WebDriver getDriver() {
        //Here we can modify what browser to user chrome or edge by
        //updating browser value in the 'L02_config.properties' file
        if (prop.getProperty("browser").equals("chrome")) {
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

        return driver;
    }

    public String getUrl() {
        url = prop.getProperty("url");

        return url;
    }
}
