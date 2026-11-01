package ru.testqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void canCalculateArea() {
        Square sq = new Square(5.0);
        double result = sq.area();
        Assertions.assertEquals(25.0, result);
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(20, new Square(5.0).perimeter());
    }

    @Test
    void cannotCreateSquareWithNegativeSide() {
        try{
            Square sq = new Square(-5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void testEquality() {
        Square sq1 = new Square(5.0);
        Square sq2 = new Square(5.0);
        Assertions.assertEquals(sq1, sq2);
    }

    @Test
    void testNonEquality() {
        Square sq1 = new Square(5.0);
        Square sq2 = new Square(3.0);
        Assertions.assertNotEquals(sq1, sq2);
    }

    @Test
    void testPass() {
        Square sq1 = new Square(5.0);
        Square sq2 = new Square(5.0);
        Assertions.assertTrue(sq1.equals(sq2));
    }
}
