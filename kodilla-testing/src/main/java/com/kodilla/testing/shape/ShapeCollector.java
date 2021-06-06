package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapeCollection() {
        return shapes;
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n < shapes.size() && n >= 0){
            return shapes.get(n);
        } else {
            return null;
        }
    }

    public String showFigures() {
        String result = "";
        for (Shape show : shapes) {
            result += show.getShapeName();
        }
        return result;
    }

    public int getShapesListSize(){
        return  shapes.size();
    }
}
