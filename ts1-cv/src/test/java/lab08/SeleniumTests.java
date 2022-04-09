package lab08;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class SeleniumTests {
    @Test
    public void seleniumStartTest() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/Users/dmitry1/Desktop/CVUT/4. semestr/TS1/Zdroje/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}
