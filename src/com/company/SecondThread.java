package com.company;

import java.util.List;

public class SecondThread extends Thread{

    public static final int firstFileNumber = 6;

    public void run() {
        int i = firstFileNumber;
        for (List<String> current: FileReader.getSecondHalf()){
            String operation = current.get(0);
            String numbers = current.get(1);
            Result.addResult("file "+i, LineProcessing.calculation(numbers, operation));
            i++;
        }
    }
}
