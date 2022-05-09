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

public class LoggedPage {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@id='search-options']")
    private WebElement settingsButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Advanced Search']")
    private WebElement advancedSearchSelect;

    public LoggedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
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
