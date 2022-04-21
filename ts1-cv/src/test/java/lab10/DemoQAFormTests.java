package lab10;

import lab09.TestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQAFormTests extends TestCase {

    @Test
    public void endToEndFillForm() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://demoqa.com/");
        WebElement formsDiv = driver.findElement(
                By.xpath("//h5[text()='Forms']//ancestor::div[@class='card mt-4 top-card']"));
        wait.until(ExpectedConditions.visibilityOf(formsDiv));
        jsClick(formsDiv);
        WebElement practiceFormSpam = driver.findElement(
                By.xpath("//span[text()='Practice Form']//../../li[@id='item-0']"));
        wait.until(ExpectedConditions.visibilityOf(practiceFormSpam));
        jsClick(practiceFormSpam);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    // Alternative solution to the 1st test (Using DemoQAMainPage class for this test)
    @Test
    public void formsTestPageObject() {
        new DemoQAMainPage(getDriver()).clickForms();
    }
}
