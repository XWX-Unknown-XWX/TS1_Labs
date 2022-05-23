package ts1_selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchOut {

    private final WebDriver driver;

    ArrayList<ArticleInfo> articleInfos;

    List<String> articles = new ArrayList<>();

    @FindBy(how = How.XPATH, using = "//span[text()='Article']")
    private WebElement setArticle;

    @FindBy(how = How.XPATH, using = "//h1[@class='c-article-title']")
    private WebElement articleName;

    @FindBy(how = How.XPATH, using = "//a[text()='Published: ']//time")
    private WebElement articleDate;

    @FindBy(how = How.XPATH, using = "//p[contains(abbr,\"DOI\")]//span[@class='c-bibliographic-information__value']")
    private WebElement articleDOI;

    public SearchOut(WebDriver driver) {
        articles.add("https://link.springer.com/article/10.1007/s11219-016-9331-9");
        articles.add("https://link.springer.com/article/10.1007/s13198-017-0646-0");
        articles.add("https://link.springer.com/article/10.1007/s11219-021-09575-w");
        articles.add("https://link.springer.com/article/10.1007/s11859-007-0005-0");
        articleInfos = new ArrayList<>();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public SpringerArticles endSearching() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(setArticle));
        jsClick(setArticle);
        return new SpringerArticles(driver);
    }

    public void addArticlesToList(String article, ArrayList<ArticleInfo> articleInfos) {
        driver.get(article);
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.articleName = articleName.getText();
        articleInfo.datePublished = articleDate.getText();
        articleInfo.doi = articleDOI.getText();
        driver.navigate().back();
        articleInfos.add(articleInfo);
    }

    public SearchOut engageParametrizedSearch() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOf(setArticle));
        jsClick(setArticle);
        return this;
    }
    public ArrayList<ArticleInfo> readArticles(){
        addArticlesToList(articles.get(0), articleInfos);
        addArticlesToList(articles.get(1), articleInfos);
        addArticlesToList(articles.get(2), articleInfos);
        addArticlesToList(articles.get(3), articleInfos);
        return articleInfos;
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
