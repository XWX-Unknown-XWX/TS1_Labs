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

public class SpringerMainPage {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='register-link flyout-caption']")
    private WebElement signUpOrLogIn;


    public SpringerMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        driver.get("https://link.springer.com/");
    }

    public LogInSpringer logInSpringer() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(signUpOrLogIn));
        jsClick(signUpOrLogIn);
        return new LogInSpringer(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
