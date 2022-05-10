package ts1_selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInSpringer {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='login-box-email']")
    private WebElement email;

    @FindBy(how = How.XPATH, using = "//input[@id='login-box-pw']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@title='Log in']")
    private WebElement logInClick;

    public LogInSpringer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public LoggedPage loggedPage() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("email");
        password.sendKeys("password");
        jsClick(logInClick);
        return new LoggedPage(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
