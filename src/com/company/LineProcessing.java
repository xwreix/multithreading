package com.company;

import java.util.ArrayList;

public class LineProcessing {

    public static ArrayList<Double> lineToNumbers(String lineNumbers) {
        ArrayList<Double> numbers = new ArrayList<>();

        try {
            for (String part : lineNumbers.split("\\s")) {
                numbers.add(Double.parseDouble(part));
            }
        } catch (NumberFormatException ex) {
            System.out.println("The element wasn't a number");
        }

        return numbers;
    }
}
