package lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

    @Test
    public void returnNumber_isFive_True() {
        Foo foo = new Foo();
        Assertions.assertEquals(5, foo.returnNumber());
    }

//    @Test //FIXME: Working incorrect due that foo returns 5. Showing what we will get as output
//    public void returnNumber_isFour_True() {
//        Foo foo = new Foo();
//        Assertions.assertEquals(4, foo.returnNumber());
//    }
}