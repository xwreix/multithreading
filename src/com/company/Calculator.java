package com.company;

import java.util.ArrayList;

public class Calculator {

    private static double totalResult = 0;

    public static double getTotalResult() {
        return totalResult;
    }

    public static String getData(ArrayList<Double> numbers, String operation) {
        double currentResult = numbers.get(0);
        numbers.remove(0);

        switch (operation) {

            case "+":
                for (double element: numbers) {
                    currentResult += element;
                }
                break;

            case "-":
                for(double element: numbers) {
                    currentResult -= element;
                }
                break;

            case "*":
                for(double element: numbers) {
                    currentResult *= element;
                }
                break;

            case "/":
                for(double element: numbers) {
                    if(element == 0)
                    {
                        return "You can't divide by zero";
                    }
                    else {
                        currentResult /= element;
                    }
                }
                break;

            case "^":
                for(double element: numbers) {
                    currentResult += element*element;
                }
                break;

            case "#":
                for(double element: numbers) {
                    currentResult += element;
                }
                currentResult /= numbers.size()+1;
                break;

            default:
                return "Wrong operation sign";
        }

        totalResult += currentResult;
        return currentResult+ " ";
    }

}
