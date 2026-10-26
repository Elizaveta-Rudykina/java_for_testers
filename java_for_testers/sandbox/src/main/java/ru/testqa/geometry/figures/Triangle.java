package ru.testqa.geometry.figures;

public record Triangle(double a, double b, double c) {
    public double perimeter() {
        return this.a + this.b + this.c;
    }
    public double area() {
        double halfp = this.perimeter() / 2.0;
        return Math.sqrt(halfp * (halfp - this.a) * (halfp - this.b) * (halfp -c));
    }
}
