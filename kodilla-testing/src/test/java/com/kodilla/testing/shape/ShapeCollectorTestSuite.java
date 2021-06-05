package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    @DisplayName("Tests for shapes")
    class TestShapes {

        @Test
        public void addFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(6);
            //When
            shapeCollector.addFigure(shape);
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCollection().size());
        }

        @Test
        public void removeFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(8);
            shapeCollector.addFigure(shape);
            //When
            boolean result = shapeCollector.removeFigure(shape);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCollection().size());
        }

        @Test
        public void getFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(4);
            shapeCollector.addFigure(shape);
            //When
            Shape shapeResult = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(shape, shapeResult);
        }

        @Test
        public void showFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(6);
            shapeCollector.addFigure(shape);
            ArrayList<Shape> shapeList= new ArrayList<>();
            shapeList.add(shape);
            //When
            List<Shape> shapeResultList = shapeCollector.getShapeCollection();
            //Then
            Assertions.assertEquals(shapeList.toString(), shapeResultList.toString());
        }
    }
}