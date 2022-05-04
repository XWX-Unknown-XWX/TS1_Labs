package lab11;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartMoodleQuiz {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@class='answer']//textarea")
    private WebElement firstQuiz;

    @FindBy(how = How.XPATH, using = "//p[text()='Kolik je sekund v 24 hodinách?']//ancestor::div[@class='formulation clearfix']//input[@type='text']")
    private WebElement secondQuiz;

    @FindBy(how = How.XPATH, using = "//p[text()='Planetou sluneční soustavy není ']//select")
    private WebElement thirdQuiz;

    @FindBy(how = How.XPATH, using = "//p[text()='Mezi státy evropské unie patří ']//select")
    private WebElement fourthQuiz;
    public StartMoodleQuiz(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public FinishQuizReview makingMoodleQuiz() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Select thirdQuiz = new Select(this.thirdQuiz);
        Select fourthQuiz = new Select(this.fourthQuiz);
        driverWait.until(ExpectedConditions.visibilityOf(firstQuiz));
        firstQuiz.sendKeys("Dmitrij Rastvorov, Cviceni 11 p106");
        secondQuiz.sendKeys("86400");
        jsClick(this.thirdQuiz);
        thirdQuiz.selectByVisibleText("Oberon");
        jsClick(this.fourthQuiz);
        fourthQuiz.selectByVisibleText("Rumunsko");
        return new FinishQuizReview(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
