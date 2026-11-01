package ru.testqa.geometry.figures;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if(a<0 || b<0 || c<0) {
            throw new IllegalArgumentException("All triangle sides should be non-negative");
        }

        if(((a+b) < c) || ((a+c) < b) || ((b+c) < a)) {
            throw new IllegalArgumentException("Each side of triangle must be less than the sum of the other two sides");
        }
    }
    public double perimeter() {
        return this.a + this.b + this.c;
    }
    public double area() {
        double halfp = this.perimeter() / 2.0;
        return Math.sqrt(halfp * (halfp - this.a) * (halfp - this.b) * (halfp -c));
    }
}
