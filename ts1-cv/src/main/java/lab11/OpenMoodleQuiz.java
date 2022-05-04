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

public class OpenMoodleQuiz {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement openQuizClick;

    @FindBy(how = How.XPATH, using = "//input[@name='submitbutton']")
    private WebElement startQuiz;

    public OpenMoodleQuiz(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public StartMoodleQuiz moodleQuizStarting() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(openQuizClick));
        jsClick(openQuizClick);
        driverWait.until(ExpectedConditions.visibilityOf(startQuiz));
        jsClick(startQuiz);
        return new StartMoodleQuiz(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
