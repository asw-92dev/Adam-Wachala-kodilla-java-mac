package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of test");
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
    @DisplayName("Tests for weather")
    class WeatherTests {
        @Test
        void testCalculateForecastWithMock() {
            //Given
            Temperatures temperaturesMock = mock(Temperatures.class);
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            //When
            int quantityOfSensors = weatherForecast.calculateForecast().size();
            //Then
            Assertions.assertEquals(5, quantityOfSensors);
        }

        @Test
        void testCalculateTempAverage() {
            //Given
            Temperatures temperaturesMock = mock(Temperatures.class);
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            //When
            double sum = 0.0;
            for (Double Map : temperaturesMap.values()) {
                sum += Map;
            }
            Double average = sum / temperaturesMap.size();

            //Then
            Assertions.assertEquals(25.56, average);
        }

        @Test
        void testCalculateTempMedian() {
            //Given
            Temperatures temperaturesMock = mock(Temperatures.class);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            //When
            ArrayList<Double> valueList = new ArrayList<Double>(temperaturesMap.values());

            int val = valueList.size() / 2;
            double median = valueList.get(val);
            //Then
            Assertions.assertEquals(26.1, median);
        }
    }
}
