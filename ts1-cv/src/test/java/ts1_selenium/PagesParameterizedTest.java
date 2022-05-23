package ts1_selenium;

import lab09.TestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagesParameterizedTest extends TestCase {

    public final static String CHROME_DRIVER_PATH =
            "/Users/dmitry1/Desktop/CVUT/4. semestr/TS1/Zdroje/ChromeDriver/chromedriver";

    @ParameterizedTest
    @MethodSource("getArticles")
    public void searchingWithParametrizedTest(ArticleInfo articleInfo) {
        ArticleInfo articlesExpected = new LogInSpringer(getDriver())
                .loggedPage("login", "password")
                .getArticleInfoForParamTest(articleInfo.articleName);
        assertEquals(articlesExpected.datePublished, articleInfo.datePublished);
        assertEquals(articlesExpected.doi, articleInfo.doi);
    }

    private static List<ArticleInfo> getArticles() {
        return articleInfoList();
    }

    public static List<ArticleInfo> articleInfoList() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        List<ArticleInfo> articleInfos = new AdvancedSearch(driver)
                .searchOut()
                .engageParametrizedSearch()
                .readArticles();
        System.out.println(); //Select this line and run debug to see the testing process
        driver.quit();
        return articleInfos;
    }
}
