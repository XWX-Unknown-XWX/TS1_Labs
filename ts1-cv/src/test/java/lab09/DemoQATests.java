package lab09;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQATests extends TestCase {
    @Test
    public void openDemoQA() {
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com");
    }

    @Test
    public void findElementTests() {
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement userForm = driver.findElement(By.id("userForm"));
        WebElement lastNameXpath = driver.findElement(By.xpath("//div/input[@id='lastName']"));
        System.out.println();
    }

    @Test
    public void fillFormTest() {
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastNameXpath = driver.findElement(By.xpath("//div/input[@id='lastName']"));
        WebElement email = driver.findElement(By.xpath("//div[@id='userEmail-wrapper']//input[@id='userEmail']"));
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        WebElement hobbiesCheckBox = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        firstName.sendKeys("Dmitrij");
        lastNameXpath.sendKeys("Rastvorov");
        email.sendKeys("dmitrijrastv@fel.cvut.cz");
        userNumber.sendKeys("+420323623923");
        executor.executeScript("arguments[0].click();", hobbiesCheckBox);
        System.out.println();
    }
}
