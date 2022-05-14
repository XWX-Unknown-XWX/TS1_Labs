package sem_selenium.heureka_cz;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeurekaPage {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[text()='Elektronika']//ancestor::a[@class='e-heading-link']")
    private WebElement electronicsSearch;

    @FindBy(how = How.XPATH, using = "//a[@href='https://notebooky.heureka.cz/']")
    private WebElement notebookSearch;


    public HeurekaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        driver.get("https://www.heureka.cz/");
    }

    public LaptopsPage laptopsPage() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(electronicsSearch));
        jsClick(electronicsSearch);
        driverWait.until(ExpectedConditions.visibilityOf(notebookSearch));
        jsClick(notebookSearch);
        return new LaptopsPage(driver);
    }
    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
