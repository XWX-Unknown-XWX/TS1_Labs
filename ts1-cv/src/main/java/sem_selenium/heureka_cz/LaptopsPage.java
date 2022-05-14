package sem_selenium.heureka_cz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LaptopsPage {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='price-range-min']")
    private WebElement minPrice;

    @FindBy(how = How.XPATH, using = "//input[@id='price-range-max']")
    private WebElement maxPrice;

    @FindBy(how = How.XPATH, using = "//span[text()='Ok']")
    private WebElement submitPrice;

    @FindBy(how = How.XPATH, using = "//input[@id='review-1']")
    private WebElement bestReview;

    @FindBy(how = How.XPATH, using = "//input[@id='availability-1']")
    private WebElement available;

    @FindBy(how = How.XPATH, using = "//button[text()='Zobrazit další možnosti']")
    private WebElement showListOfLaptops;

    @FindBy(how = How.XPATH, using = "//a[text()='Apple']")
    private WebElement selectManufacturer;

    @FindBy(how = How.XPATH, using = "//a[text()='Procesor']")
    private WebElement OpenProcessor;

    @FindBy(how = How.XPATH, using = "//a[text()='Apple M1']")
    private WebElement selectProcessorOne;

    @FindBy(how = How.XPATH, using = "//a[text()='Apple M1 Pro']")
    private WebElement selectProcessorTwo;

    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}
