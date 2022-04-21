package lab10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static java.sql.DriverManager.getDriver;

public class DemoQAMainPage {

    private final WebDriver driver;
    @FindBy(how = How.XPATH, using = "//h5[text()='Forms']//ancestor::div[@class='card mt-4 top-card']")
    private WebElement formsDiv;

    public DemoQAMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        driver.get("https://demoqa.com/");
    }

    public DemoQAMainPage clickForms() {
        jsClick(formsDiv);
        return this;
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
