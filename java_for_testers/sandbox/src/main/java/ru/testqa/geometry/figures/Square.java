package ru.testqa.geometry.figures;

public class Square {
    public static void printSquareArea(double a) {
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", a, area(a)));
    }

    public static double area(double a) {
        return a * a;
    }

    public static double perimeter(double a) {
        return a * 4;
    }
}
