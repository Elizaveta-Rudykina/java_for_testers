package ru.testqa.geometry.figures;

public record Square (double side) {

    public Square {
        if(side < 0) {
            throw new IllegalArgumentException("Square side should be non-negative");
        }
    }

    public double area() {
        return this.side * this.side;
    }

    public static void printSquareArea(Square square) {
        System.out.printf("Площадь квадрата со стороной %f = %f %n", square.side, square.area());
    }

    public double perimeter() {
        return this.side * 4;
    }
}
