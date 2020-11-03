package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileReader {

    public static void directoryReader() {
        Thread thread = new FileProcessing();
        List<List<String>> fileString = new ArrayList();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the path of directory: ");
        String path = in.nextLine();
        File directory = new File(path);
        System.out.println("Enter the path of result file: ");
        path = in.nextLine();
        File resultFile = new File(path);

        try {
            resultFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int counter =0;

        for (File file : Objects.requireNonNull(directory.listFiles())) {

            if (file.isFile()) {
                try {
                    fileString.add(Files.readAllLines(Path.of(file.getPath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            List<String> current = fileString.get(counter);
            thread = new FileProcessing(file.getName(), current.get(0), current.get(1), resultFile.getName());
            thread.start();
            counter++;
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ResultWriter.addToResult(resultFile.getName(), "total is "+Calculator.getTotalResult());
        in.close();
    }
}


