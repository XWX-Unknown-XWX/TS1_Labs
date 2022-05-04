package lab11;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginMoodle {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary w-100']")
    private WebElement internalLogin;

    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    private WebElement userName;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement submitButton;

    public LoginMoodle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        driver.get("https://moodle.fel.cvut.cz/local/kos/login.php");
    }

    public MoodleCoursePage loggedMoodle() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(internalLogin));
        jsClick(internalLogin);
        userName.sendKeys("loggin");
        userPassword.sendKeys("password");
        jsClick(submitButton);
        return new MoodleCoursePage(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
