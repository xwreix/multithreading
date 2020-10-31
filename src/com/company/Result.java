package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Result {
    private static double totalResult;
    private static FileWriter writer;

    static {
        try {
            writer = new FileWriter("result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addResult(String fileName, String result){
        try {
            totalResult +=Double.parseDouble(result);
            writer.write(fileName+" - " +result);
        }catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
    }

    public static void writeTotalResult(){
        try {
            writer.write("Total is "+totalResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(){
        System.out.println(writer);
    }

}
