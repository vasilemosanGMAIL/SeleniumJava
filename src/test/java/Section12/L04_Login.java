package Section12;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class L04_Login extends BasePage{
    public L04_Login() throws IOException {
    }

    @Test
    void signin() {
        driver = getDriver();
        driver.get(getUrl());
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        driver.findElement(By.cssSelector("button#submit-login")).click();

        driver.quit();
    }
}
