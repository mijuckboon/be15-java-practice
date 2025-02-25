package jinwoong.level01.basic;

public class Application {
    public static void main(String[] args) {
        /* 강사님 코드와 넓이 결과가 다르게 나오는 이유
         * 강사님: 0.5를 곱함 (0.5 * base * height)
         * 본인: 2로 나눔     (base * height / 2)
         * 소수를 직접 사칙연산하면 오차 발생 가능성이 높으므로, 나누는 쪽이 정확성 측면에서 더 좋음 */
        ShapeManager manager = new ShapeManager();

        /* 반지름(radius) 이 5인 Circle 객체 생성 */
        Shape circle = new Circle(5);
        /* 너비(width)가 4, 높이(height)가 5인 Rectangle 객체 생성 */
        Shape rectangle = new Rectangle(4, 5);
        /* 밑변(base)이 3, 높이(height)가 4, 첫 번째 변(side1)이 3, 두 번째 변(side2)이 4, 세 번째 변(side3)이 5인 Triangle 객체 생성 */
        Shape triangle = new Triangle(3, 4, 3, 4, 5);

        /* 도형 추가 */
        manager.addShape(circle);
        manager.addShape(rectangle);
        manager.addShape(triangle);

        System.out.println("===== 모든 도형 출력 =====");
        manager.printAllShapes();
        System.out.println("총 넓이 출력 : " + manager.getTotalArea());
        System.out.println("총 둘레 출력 : " + manager.getTotalPerimeter());

        /* 크기 조정 */
        ((Resizable) circle).resize(2);
        ((Resizable) rectangle).resize(2);
        ((Resizable) triangle).resize(2);

        System.out.println("===== 크기 조정 후 모든 도형 출력 =====");
        manager.printAllShapes();
        System.out.println("총 넓이 출력 : " + manager.getTotalArea());
        System.out.println("총 둘레 출력 : " + manager.getTotalPerimeter());

        System.out.println("===== Circle 삭제 후 모든 도형 출력 =====");
        manager.removeShape(circle);
        manager.printAllShapes();
        System.out.println("총 넓이 출력 : " + manager.getTotalArea());
        System.out.println("총 둘레 출력 : " + manager.getTotalPerimeter());
    }
}
