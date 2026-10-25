package ru.testqa.geometry;

import ru.testqa.geometry.figures.Rectangle;
import ru.testqa.geometry.figures.Square;

public class Geometry {
    static void main(String[] args) {
        Square.printSquareArea(5.0);
        Square.printSquareArea(7.0);

        Rectangle.printRectangleArea(3.0, 5.0);
    }
}
