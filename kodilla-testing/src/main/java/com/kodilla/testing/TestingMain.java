package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // Testing Calculator class
        Calculator calculator = new Calculator();
        int numberA = 10;
        int numberB = 5;

        int sum = calculator.add(numberA, numberB);
        int substract = calculator.subtract(numberA, numberB);
        //Testing sum method:
        if (sum == 15) {
            System.out.println("Sum method in calculator works correctly: " + numberA + " + " + numberB + " = " + sum);
        } else {
            System.out.println("Sum method is not correct!");
        }
        //Testing substract method:
        if (substract == 5) {
            System.out.println("Substract method in calculator works correctly: " + numberA + " - " + numberB + " = " + substract);
        } else {
            System.out.println("Substract method is not correct!");
        }
    }
}
