package Polymorphism.Shapes;

public class Circle extends Shape {

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (perimeter == null) {
            area = 2 * Math.PI * radius;
        }
        return area;
    }

    @Override
    public Double calculateArea() {
        if (area == null) {
            area = Math.PI * radius * radius;
        }
        return area;
    }
}
