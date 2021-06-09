package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverage() {
        double average = 0.0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            average += temperature.getValue();
        }
        return average / temperatures.getTemperatures().size();
    }

    public double calculateMedian() {
        Collection<Double> tempCollection = temperatures.getTemperatures().values();
        List<Double> valueList = new ArrayList<>(tempCollection);
        Collections.sort(valueList);

        int size = valueList.size();
        int index = 0;
        index = size / 2;
        if (size % 2 == 0) {
            return (valueList.get(index - 1) + valueList.get(index)) / 2;
        } else {
            return valueList.get(index);
        }
    }
}
