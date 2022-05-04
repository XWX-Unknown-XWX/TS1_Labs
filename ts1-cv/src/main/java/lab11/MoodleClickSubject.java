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

public class MoodleClickSubject {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@aria-controls='collapse-4']")
    private WebElement CvClick;

    @FindBy(how = How.XPATH, using = "//span[text()='CV 11: Test pro Robota']")
    private WebElement Cv11Click;

    public MoodleClickSubject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public OpenMoodleQuiz clickCVTest() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(CvClick));
        jsClick(CvClick);
        driverWait.until(ExpectedConditions.visibilityOf(Cv11Click));
        jsClick(Cv11Click);
        return new OpenMoodleQuiz(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
