package ts1_selenium;

public class ArticleInfo {
    public String articleName;
    public String doi;
    public String datePublished;

    @Override
    public String toString() {
        return "Publication{" +
                "name='" + articleName + '\'' +
                ", doi='" + doi + '\'' +
                ", date='" + datePublished + '\'' +
                '}';
    }
}
