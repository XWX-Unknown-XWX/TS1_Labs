package ts1_selenium;

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

public class AdvancedSearch {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='all-words']")
    private WebElement withAllWords;

    @FindBy(how = How.XPATH, using = "//input[@id='least-words']")
    private WebElement oneOfTheWords;

    @FindBy(how = How.XPATH, using = "//select[@id='date-facet-mode']")
    private WebElement makeYearOption;

    @FindBy(how = How.XPATH, using = "//input[@id='facet-start-year']")
    private WebElement startYear;


    @FindBy(how = How.XPATH, using = "//button[@id='submit-advanced-search']")
    private WebElement startSearch;


    public AdvancedSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        driver.get("https://link.springer.com/advanced-search");
    }

    public SearchOut searchOut() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select inTheYear = new Select(this.makeYearOption);
        driverWait.until(ExpectedConditions.visibilityOf(withAllWords));
        withAllWords.sendKeys("Page Object Model");
        oneOfTheWords.sendKeys("Selenium Testing");
        jsClick(this.makeYearOption);
        inTheYear.selectByVisibleText("in");
        startYear.sendKeys("2022");
        jsClick(startSearch);
        return new SearchOut(driver);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
