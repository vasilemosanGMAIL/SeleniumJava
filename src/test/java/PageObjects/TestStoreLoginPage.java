package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestStoreLoginPage {
    private WebDriver _driver;

    public TestStoreLoginPage(WebDriver driver){
        _driver = driver;
    }

    By signIn = By.cssSelector("[title] .hidden-sm-down");
    By email = By.cssSelector("section input[name='email']");
    By password = By.cssSelector("input[name='password']");
    By loginBtn = By.cssSelector("button#submit-login");

    public WebElement getSignIn() {
        return _driver.findElement(signIn);
    }
    public WebElement getEmail(){
        return _driver.findElement(email);
    }
    public WebElement getPassword(){
        return _driver.findElement(password);
    }
    public WebElement getLoginBtn(){
        return _driver.findElement(loginBtn);
    }


}
