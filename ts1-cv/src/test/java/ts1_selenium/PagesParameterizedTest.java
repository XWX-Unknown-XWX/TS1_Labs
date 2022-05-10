package ts1_selenium;

import lab09.TestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PagesParameterizedTest extends TestCase {
    @ParameterizedTest
    @CsvSource({
            "APOGEN: automatic page object generator for web testing, " +
                    "09 August 2016, https://doi.org/10.1007/s11219-016-9331-9"
    })
    public void testFirstPage(String title, String date, String doi) {
        WebDriver driver = getDriver();
        PageArticleSave pageArticleSave = new PageArticleSave(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://link.springer.com/article/10.1007/s11219-016-9331-9");
        wait.until(ExpectedConditions.visibilityOf(pageArticleSave.getArticleTitle()));
        assertAll(
                () -> assertEquals(title, pageArticleSave.getArticleTitle().getText()),
                () -> assertEquals(date, pageArticleSave.getFirstDatePublished().getText()),
                () -> assertEquals(doi, pageArticleSave.getFirstDOI().getText())
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Model-based testing leveraged for automated web tests, " +
                    "27 November 2021, https://doi.org/10.1007/s11219-021-09575-w"
    })
    public void testSecondPage(String title, String date, String doi) {
        WebDriver driver = getDriver();
        PageArticleSave pageArticleSave = new PageArticleSave(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://link.springer.com/article/10.1007/s11219-021-09575-w");
        wait.until(ExpectedConditions.visibilityOf(pageArticleSave.getArticleTitle()));
        assertAll(
                () -> assertEquals(title, pageArticleSave.getArticleTitle().getText()),
                () -> assertEquals(date, pageArticleSave.getSecondDatePublished().getText()),
                () -> assertEquals(doi, pageArticleSave.getSecondDOI().getText())
        );
    }

    @ParameterizedTest
    @CsvSource({
            "ESICM LIVES 2017, " +
                    "20 September 2017, https://doi.org/10.1186/s40635-017-0151-4"
    })
    public void testThirdPage(String title, String date, String doi) {
        WebDriver driver = getDriver();
        PageArticleSave pageArticleSave = new PageArticleSave(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://link.springer.com/article/10.1186/s40635-017-0151-4");
        wait.until(ExpectedConditions.visibilityOf(pageArticleSave.getArticleTitle()));
        assertAll(
                () -> assertEquals(title, pageArticleSave.getArticleTitle().getText()),
                () -> assertEquals(date, pageArticleSave.getThirdDatePublished().getText()),
                () -> assertEquals(doi, pageArticleSave.getThirdDOI().getText())
        );
    }

    @ParameterizedTest
    @CsvSource({
            "ESICM LIVES 2020, " +
                    "14 December 2020, https://doi.org/10.1186/s40635-020-00354-8"
    })
    public void testFourthPage(String title, String date, String doi) {
        WebDriver driver = getDriver();
        PageArticleSave pageArticleSave = new PageArticleSave(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://link.springer.com/article/10.1186/s40635-020-00354-8");
        wait.until(ExpectedConditions.visibilityOf(pageArticleSave.getArticleTitle()));
        assertAll(
                () -> assertEquals(title, pageArticleSave.getArticleTitle().getText()),
                () -> assertEquals(date, pageArticleSave.getFourthDatePublished().getText()),
                () -> assertEquals(doi, pageArticleSave.getFourthDOI().getText())
        );
    }
}
