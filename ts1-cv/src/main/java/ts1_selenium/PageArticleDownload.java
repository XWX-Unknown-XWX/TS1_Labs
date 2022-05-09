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

public class PageArticleDownload {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[text()='Download citation']")
    private WebElement downloadPage;
    public PageArticleDownload(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public SpringerArticles downloadCitation() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(downloadPage));
        downloadPage.click();
        driver.navigate().back();
        return new SpringerArticles(driver);
    }
}
