package lab11;

import lab09.TestCase;
import org.junit.jupiter.api.Test;

public class MoodlePageTests extends TestCase {

    @Test
    public void fillMoodleTest() {
        new LoginMoodle(getDriver())
                .loggedMoodle()
                .clickForTheTSSubject()
                .clickCVTest()
                .moodleQuizStarting()
                .makingMoodleQuiz()
                .finishingReview()
                .moodleLoggingOut()
                .confirmLoggingOut();
        System.out.println();
    }
}
