package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;


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
            Shape circle = new Circle(8);
            Shape square = new Square(5);
            Shape triangle = new Triangle(3,5);
            //When
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            //Then
            Assertions.assertEquals(3,shapeCollector.getShapesListSize());
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
            Shape square = new Square(4);
            shapeCollector.addFigure(square);
            //When
            Shape shapeResult = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(square, shapeResult);
        }

        @Test
        public void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Square(2));
            shapeCollector.addFigure(new Circle(2));
            shapeCollector.addFigure(new Triangle(2,5));
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Square(2.0), Circle(2.0), Triangle(2.0, 5.0)", result);
        }
    }
}
