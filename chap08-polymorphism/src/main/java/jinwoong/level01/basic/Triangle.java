package jinwoong.level01.basic;

public class Triangle extends Shape implements Resizable {
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public void resize(double factor) {
        this.base *= factor;
        this.height *= factor;
        this.side1 *= factor;
        this.side2 *= factor;
        this.side3 *= factor;
    }

    @Override
    double calculateArea() {
        return this.base * this.height/2;
    }

    @Override
    double calculatePerimeter() {
        return this.side1 + this.side2 + this.side3;
    }
}
