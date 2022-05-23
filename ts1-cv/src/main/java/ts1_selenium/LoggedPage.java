package ts1_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedPage {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@id='search-options']")
    private WebElement settingsButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Advanced Search']")
    private WebElement advancedSearchSelect;

    @FindBy(how = How.XPATH, using = "//input[@id='query']")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//input[@id='search']")
    private WebElement searchButton;

    public LoggedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public ArticleInfo getArticleInfo(String articleName) {
        ArticleInfo articleInfo = new ArticleInfo();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchInput.sendKeys(articleName);
        searchButton.click();
        WebElement articleLink = driver.findElement(
                By.xpath("//a[contains(text(),'" + articleName + "')]"));
        jsClick(articleLink);
        WebElement articleDate = driver.findElement(
                By.xpath("//a[text()='Published: ']//time"));
        wait.until(ExpectedConditions.visibilityOf(articleDate));
        WebElement articleDOI = driver.findElement(
                By.xpath("//p[contains(abbr,\"DOI\")]//span[@class='c-bibliographic-information__value']"));
        articleInfo.articleName = articleName;
        articleInfo.datePublished = articleDate.getText();
        articleInfo.doi = articleDOI.getText();
        driver.navigate().back();
        System.out.println(articleInfo + "\n");
        return articleInfo;
    }

    public AdvancedSearch advancedSearch() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(settingsButton));
        jsClick(settingsButton);
        jsClick(advancedSearchSelect);
        return new AdvancedSearch(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
