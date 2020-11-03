package com.company;

public class Calculator {

    private static double totalResult = 0;

    public static double getTotalResult() {
        return totalResult;
    }

    public static String getData(double number1, double number2, String operation) {
        switch (operation) {

            case "+":
                totalResult += number1 + number2;
                return (number1 + number2) + " ";

            case "-":
                totalResult += number1 - number2;
                return (number1 - number2) + " ";

            case "*":
                totalResult += number1 * number2;
                return number1 * number2 + " ";

            case "/":
                if (number2 == 0) {
                    return "You can't divide by zero ";
                } else {
                    totalResult += number1 / number2;
                    return number1 / number2 + " ";
                }

            case "^":
                totalResult += number1 * number1 + number2 * number2;
                return (number1 * number1 + number2 * number2) + " ";

            case "#":
                totalResult += (number1 + number2) / 2;
                return (number1 + number2) / 2 + " ";

            default:
                return "Wrong operation sign";
        }
    }

}
