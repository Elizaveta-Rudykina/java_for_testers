package ru.testqa.geometry.figures;

import java.util.Objects;

public record Rectangle(double a, double b) {

    public Rectangle {
        if(a < 0 || b < 0) {
            throw new IllegalArgumentException("Rectangle sides should be non-negative");
        }
    }
    public static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + rectangleArea(a, b));
    }

    private static double rectangleArea(double a, double b) {
        return a*b;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(this.a, rectangle.a) == 0 && Double.compare(this.b, rectangle.b) == 0
                || Double.compare(this.b, rectangle.a) == 0 && Double.compare(this.b, rectangle.a) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
