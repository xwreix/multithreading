package com.company;

import java.util.ArrayList;

public class FileProcessing extends Thread{
    private String lineNumbers = null;
    private String operation = null;
    private String resultFile = null;
    private String fileName = null;

    public FileProcessing(String fileName, String operation, String lineNumbers, String resultFile) {
        this.fileName = fileName;
        this.lineNumbers = lineNumbers;
        this.operation = operation;
        this.resultFile = resultFile;
    }

    public FileProcessing() {
    }

    @Override
    public void run() {
        ArrayList<Double> numbers = LineProcessing.lineToNumbers(lineNumbers);
        String result = Calculator.getData(numbers, operation);
        ResultWriter.addToResult(resultFile,fileName + ": " + result);
    }
}
