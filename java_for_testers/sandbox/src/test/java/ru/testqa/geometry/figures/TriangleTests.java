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
}

