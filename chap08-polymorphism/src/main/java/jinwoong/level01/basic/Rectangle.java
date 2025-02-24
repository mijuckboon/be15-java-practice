package jinwoong.level01.basic;

public class Rectangle extends Shape implements Resizable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void resize(double factor) {
        this.width *= factor;
        this.height *= factor;
    }

    @Override
    double calculateArea() {
        return this.width * this.height;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (this.width + this.height);
    }

}
