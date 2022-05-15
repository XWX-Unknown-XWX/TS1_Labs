package ts1_selenium;

import lab09.TestCase;
import org.junit.jupiter.api.Test;

public class SpringerPageTest extends TestCase {
    @Test
    public void testingSpringerPage() {
        new SpringerMainPage(getDriver())
                .logInSpringer()
                .loggedPage("login","password")
                .advancedSearch()
                .searchOut()
                .endSearching()
                .firstPage()
                .saveFirstCitation()
                .secondPage()
                .saveSecondCitation()
                .thirdPage()
                .saveThirdCitation()
                .fourthPage()
                .saveFourthCitation();
        System.out.println(); //Select this line and run debug to see the testing process
    }
}
