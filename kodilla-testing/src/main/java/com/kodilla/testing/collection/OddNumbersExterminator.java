package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public static List<Integer> exterminate(ArrayList<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }
}
