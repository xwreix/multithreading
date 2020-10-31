package com.company;

import java.util.ArrayList;

public class LineProcessing {

    public static String calculation(String numbers, String operation){
        ArrayList<Double> twoNumbers = new ArrayList<>();
        try {
            for (String part : numbers.split("\\s")) {
                twoNumbers.add(Double.parseDouble(part));
            }
        }catch (NumberFormatException ex){
            return "The element wasn't a number";
        }

        double result = 0;

        switch (operation){
            case "+":
                result = twoNumbers.get(0)+ twoNumbers.get(1);
                break;
            case "-":
                result = twoNumbers.get(0)- twoNumbers.get(1);
                break;
            case "/":
                if(twoNumbers.get(1)==0)
                    return "You can't divide by zero";
                else {
                    result = twoNumbers.get(0) / twoNumbers.get(1);
                    break;
                }
            case "*":
                result= twoNumbers.get(0)*twoNumbers.get(1);
                break;
            case "#":
                result = (twoNumbers.get(0)+ twoNumbers.get(1))/2;
                break;
            case "^":
                result = twoNumbers.get(0)* twoNumbers.get(0)+ twoNumbers.get(1)* twoNumbers.get(1);
                break;
            default:
                return "Wring operation sign";
        }
        return result+"";
    }

}
