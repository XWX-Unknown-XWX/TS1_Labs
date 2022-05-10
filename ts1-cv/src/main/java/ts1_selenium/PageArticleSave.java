package ts1_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageArticleSave extends PageArticleInfo {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[text()='Download citation']")
    private WebElement downloadPage;

    public PageArticleSave(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public SpringerArticles saveFirstCitation() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(getFirstArticleTitle()));
        downloadPage.click();
        driver.navigate().back();
        return new SpringerArticles(driver);
    }

    public SpringerArticles saveSecondCitation() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(getSecondArticleTitle()));
        downloadPage.click();
        driver.navigate().back();
        return new SpringerArticles(driver);
    }

    public SpringerArticles saveThirdCitation() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(getThirdArticleTitle()));
        downloadPage.click();
        driver.navigate().back();
        return new SpringerArticles(driver);
    }

    public SpringerArticles saveFourthCitation() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(getFourthArticleTitle()));
        downloadPage.click();
        driver.navigate().back();
        return new SpringerArticles(driver);
    }
}
