package jinwoong.level01.basic;

import java.util.Arrays;

public class ShapeManager {
    static final String PRINT_MESSAGE = """
                Shape: %s
                Area: %f
                Perimeter: %f
                """;

    private Shape[] shapes = new Shape[10];
    private int index;

    public void addShape(Shape shape) {
        /* 배열에 전달 된 Shape를 추가. 단, 배열의 크기가 부족할 경우 2배로 늘려서 추가. */
        if (index >= shapes.length - 1) {
            shapes = Arrays.copyOf(shapes, shapes.length * 2);
        }
        shapes[index] = shape;
        index += 1;
    }


    public void removeShape(Shape shape) {
        /* 배열에서 전달 된 Shape를 찾아 제거. 단, 제거 된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
        for (int i = 0; i <= index; i++) {
            if (shapes[i] == shape) {
                for (int j = i + 1; j <= index; j++) {
                    shapes[j - 1] = shapes[j];
                }
            }
        }
        index -= 1;
    }

    public void printAllShapes() {
        for (int i = 0; i < index; i++) {
            Shape shape = shapes[i];
            String message = PRINT_MESSAGE.formatted(shape.getClass().getSimpleName(), shape.calculateArea(), shape.calculatePerimeter());
            System.out.print(message);
        }
        /* 배열에 저장 된 모든 도형의 이름, 넓이, 둘레를 출력 */
    }

    public double getTotalArea() {
        /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
        double sum = 0;
        for (int i = 0; i < index; i++) {
            sum += shapes[i].calculateArea();
        }
        return sum;
    }

    public double getTotalPerimeter() {
        /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
        double sum = 0;
        for (int i = 0; i < index; i++) {
            sum += shapes[i].calculatePerimeter();
        }
        return sum;
    }
}
