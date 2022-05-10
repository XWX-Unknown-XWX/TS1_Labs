package ts1_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class PageArticleInfo {

    //--Title--
    @FindBy(how = How.XPATH, using = "//h1[@class='c-article-title']")
    private WebElement firstArticleTitle, secondArticleTitle, thirdArticleTitle, fourthArticleTitle;

    //--DatePublished--
    @FindBy(how = How.XPATH, using = "//time[@datetime='2016-08-09']")
    private WebElement firstDatePublished;

    @FindBy(how = How.XPATH, using = "//time[@datetime='2021-11-27']")
    private WebElement secondDatePublished;

    @FindBy(how = How.XPATH, using = "//time[@datetime='2017-09-20']")
    private WebElement thirdDatePublished;

    @FindBy(how = How.XPATH, using = "//time[@datetime='2020-12-14']")
    private WebElement fourthDatePublished;

    //--DOI--
    @FindBy(how = How.XPATH, using = "//*[text()='https://doi.org/10.1007/s11219-016-9331-9']")
    private WebElement firstDOI;

    @FindBy(how = How.XPATH, using = "//*[text()='https://doi.org/10.1007/s11219-021-09575-w']")
    private WebElement secondDOI;

    @FindBy(how = How.XPATH, using = "//*[text()='https://doi.org/10.1186/s40635-017-0151-4']")
    private WebElement thirdDOI;

    @FindBy(how = How.XPATH, using = "//*[text()='https://doi.org/10.1186/s40635-020-00354-8']")
    private WebElement fourthDOI;

    //--Article--
    public WebElement getFirstArticleTitle() {
        return firstArticleTitle;
    }

    public WebElement getSecondArticleTitle() {
        return secondArticleTitle;
    }

    public WebElement getThirdArticleTitle() {
        return thirdArticleTitle;
    }

    public WebElement getFourthArticleTitle() {
        return fourthArticleTitle;
    }

    //--DatePublished--
    public WebElement getFirstDatePublished() {
        return firstDatePublished;
    }

    public WebElement getSecondDatePublished() {
        return secondDatePublished;
    }

    public WebElement getThirdDatePublished() {
        return thirdDatePublished;
    }

    public WebElement getFourthDatePublished() {
        return fourthDatePublished;
    }

    //--DOI--
    public WebElement getFirstDOI() {
        return firstDOI;
    }

    public WebElement getSecondDOI() {
        return secondDOI;
    }

    public WebElement getThirdDOI() {
        return thirdDOI;
    }

    public WebElement getFourthDOI() {
        return fourthDOI;
    }
}
