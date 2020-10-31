package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private static List<List<String>> fileString = new ArrayList();

    public static List<List<String>> getFirstHalf() {
        List<List<String>> FirstHalf = new ArrayList<>();
        for(int i =0; i<fileString.size()/2; i++){
            FirstHalf.add(fileString.get(i));
        }
        return FirstHalf;
    }

    public static List<List<String>> getSecondHalf() {
        List<List<String>> SecondHalf = new ArrayList<>();
        for(int i =fileString.size()/2; i<fileString.size(); i++){
            SecondHalf.add(fileString.get(i));
        }
        return SecondHalf;
    }

    public static void reader() {
        File directory = new File("C:/Users/RedmiBook/IdeaProjects/multithreading/files");
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                try {
                    fileString.add(Files.readAllLines(Path.of(file.getPath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        startThreads();
    }

    public static void startThreads() {
        FirstThread thread1 = new FirstThread();
        thread1.start();
        SecondThread thread2 = new SecondThread();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Result.writeTotalResult();
    }


}


