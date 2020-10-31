package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FirstThread extends Thread{

    public static final int firstFileNumber = 1;

    public void run() {
        int i = firstFileNumber;
        for (List<String> current: FileReader.getFirstHalf()){
            String operation = current.get(0);
            String numbers = current.get(1);
            Result.addResult("file "+i, LineProcessing.calculation(numbers, operation));
            i++;
        }
    }
}
