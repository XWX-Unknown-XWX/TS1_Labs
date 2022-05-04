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

public class LogoutMoodle {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@id='action-menu-toggle-1']")
    private WebElement userProfileClick;

    @FindBy(how = How.XPATH, using = "//a[@data-title='logout,moodle']")
    private WebElement logoutExecutionButton;

    public LogoutMoodle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public ConfirmLoggingOut moodleLoggingOut() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(userProfileClick));
        jsClick(userProfileClick);
        driverWait.until(ExpectedConditions.visibilityOf(logoutExecutionButton));
        jsClick(logoutExecutionButton);
        return new ConfirmLoggingOut(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
