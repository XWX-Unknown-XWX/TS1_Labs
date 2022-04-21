package lab10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoQAMainPage {

    @FindBy(how = How.XPATH, using = "//h5[text()='Forms']//ancestor::div[@class='card mt-4 top-card']")
    private WebElement formsDiv;

    public DemoQAMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get("https://demoqa.com/");
    }

    public DemoQAMainPage clickForms() {
        formsDiv.click();
        return this;
    }
}
