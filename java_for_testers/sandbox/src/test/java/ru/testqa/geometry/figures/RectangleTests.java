package ru.testqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {
    @Test
    void cannotCreateRectangleWithNegativeSides() {
        try{
            Rectangle rc = new Rectangle(-5.0, 7.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void testEquality() {
        Rectangle rc1 = new Rectangle(5.0, 7.0);
        Rectangle rc2 = new Rectangle(5.0, 7.0);
        Assertions.assertEquals(rc1, rc2);
    }

    @Test
    void testEquality2() {
        Rectangle rc1 = new Rectangle(5.0, 7.0);
        Rectangle rc2 = new Rectangle(7.0, 5.0);
        Assertions.assertEquals(rc1, rc2);
    }
}
