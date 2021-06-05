package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {

    private String name = "Triangle";
    private double sideLengthA;
    private double heightTriangle;

    public Triangle(double sideLengthA, double heightTriangle) {
        this.sideLengthA = sideLengthA;
        this.heightTriangle = heightTriangle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.sideLengthA, sideLengthA) != 0) return false;
        if (Double.compare(triangle.heightTriangle, heightTriangle) != 0) return false;
        return Objects.equals(name, triangle.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(sideLengthA);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(heightTriangle);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 0.5 * sideLengthA * heightTriangle;
    }
}
