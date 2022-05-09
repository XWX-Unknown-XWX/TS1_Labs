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

public class SpringerArticles {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[text()='APOGEN: automatic page object generator for web testing']")
    private WebElement firstTitle;

    @FindBy(how = How.XPATH, using = "//a[text()='Model-based testing leveraged for automated web tests']")
    private WebElement secondTitle;

    @FindBy(how = How.XPATH, using = "//a[text()='ESICM LIVES 2017']")
    private WebElement thirdTitle;

    @FindBy(how = How.XPATH, using = "//a[text()='ESICM LIVES 2020']")
    private WebElement fourthTitle;

    public SpringerArticles(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public PageArticleDownload firstPage() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(firstTitle));
        jsClick(firstTitle);
        return new PageArticleDownload(driver);
    }

    public PageArticleDownload secondPage() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(secondTitle));
        jsClick(secondTitle);
        return new PageArticleDownload(driver);
    }

    public PageArticleDownload thirdPage() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(thirdTitle));
        jsClick(thirdTitle);
        return new PageArticleDownload(driver);
    }

    public PageArticleDownload fourthPage() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(fourthTitle));
        jsClick(fourthTitle);
        return new PageArticleDownload(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
