package com.ohgiraffers.level01.basic;

import java.util.Arrays;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index;

    public void addShape(Shape shape) {
        if (index >= shapes.length) {
            shapes = Arrays.copyOf(shapes, shapes.length * 2);
        }
        shapes[index++] = shape;
    }

    public void removeShape(Shape shape) {
        for (int i = 0; i < index; i++) {
            if (shapes[i].equals(shape)) {
                for (int j = i; j < index - 1; j++) {
                    shapes[j] = shapes[j + 1];
                }
                shapes[index - 1] = null;
                index--;
                break;
            }
        }
    }

    public void printAllShapes() {
        for (int i = 0; i < index; i++) {
            System.out.println("Shape: " + shapes[i].getClass().getSimpleName());
            System.out.println("Area: " + shapes[i].calculateArea());
            System.out.println("Perimeter: " + shapes[i].calculatePerimeter());
        }
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (int i = 0; i < index; i++) {
            totalArea += shapes[i].calculateArea();
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for (int i = 0; i < index; i++) {
            totalPerimeter += shapes[i].calculatePerimeter();
        }
        return totalPerimeter;
    }
}

