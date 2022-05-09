package ts1_selenium;

import lab09.TestCase;
import org.junit.jupiter.api.Test;

public class SpringerPageTest extends TestCase {

    @Test
    public void testingSpringerPage() {
        new SpringerMainPage(getDriver())
                .logInSpringer()
                .loggedPage()
                .advancedSearch()
                .searchOut()
                .endSearching()
                .firstPage()
                .downloadCitation()
                .secondPage()
                .downloadCitation()
                .thirdPage()
                .downloadCitation()
                .fourthPage()
                .downloadCitation();
        System.out.println();
    }
}
