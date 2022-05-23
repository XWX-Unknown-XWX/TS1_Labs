package ts1_selenium;

import lab09.TestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagesParameterizedTest extends TestCase {

    public final static String CHROME_DRIVER =
            "/Users/dmitry1/Desktop/CVUT/4. semestr/TS1/Zdroje/ChromeDriver/chromedriver";

    @ParameterizedTest
    @MethodSource("getArticles")
    public void searchingWithParametrizedTest(ArticleInfo articleInfo) {
        ArticleInfo articlesExpected = new LogInSpringer(getDriver())
                .loggedPage("email", "password")
                .getArticleInfo(articleInfo.articleName);
        assertEquals(articlesExpected.datePublished, articleInfo.datePublished);
        assertEquals(articlesExpected.doi, articleInfo.doi);
    }

    private static List<ArticleInfo> getArticles() {
        return articleInfoList();
    }

    public static List<ArticleInfo> articleInfoList() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        driver = new ChromeDriver();
        List<ArticleInfo> articleInfos = new AdvancedSearch(driver)
                .searchOut()
                .engageParametrizedSearch()
                .readArticles();

        driver.quit();
        return articleInfos;
    }
}
