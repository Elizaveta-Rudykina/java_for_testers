package ru.testqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter() {
        Triangle tr = new Triangle(5.0, 10.0, 7.0);
        Assertions.assertEquals(22, tr.perimeter());
    }

    @Test
    void canCalculateArea() {
        Triangle tr = new Triangle(5.0, 10.0, 7.0);
        Assertions.assertEquals(Math.sqrt(264), tr.area());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try{
            Triangle tr = new Triangle(-5.0, 10.0, 7.0);
            Assertions.fail();
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cannotCreateTriangleWithNegativeSides() {
        try{
            Triangle tr = new Triangle(-5.0, -10.0, -7.0);
            Assertions.fail();
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cannotCreateTriangleWithoutInequality() {
        try{
            Triangle tr = new Triangle(5.0, 10.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException iae) {

        }
    }
}

