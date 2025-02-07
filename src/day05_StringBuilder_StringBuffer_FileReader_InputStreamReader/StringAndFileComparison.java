package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StringAndFileComparison {
    public static void main(String[] args) {
        // Task 1: StringBuilder vs StringBuffer performance comparison
        System.out.println("Task 1: StringBuilder vs StringBuffer Performance");

        // List of strings to concatenate
        String str = "hello";

        // Concatenate using StringBuilder
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append(str);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken using StringBuilder: " + stringBuilderTime + " nanoseconds");

        // Concatenate using StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append(str);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken using StringBuffer: " + stringBufferTime + " nanoseconds");

        // Task 2: FileReader vs InputStreamReader for reading large file
        System.out.println("\nTask 2: FileReader vs InputStreamReader for Word Count");

        // Path to a large text file (adjust with a real 100MB file for testing)
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstrc1.java"; // Replace with the path of your 100MB file

        // Word count using FileReader
        try {
            long wordCountFileReader = countWordsUsingFileReader(filePath);
            System.out.println("Word count using FileReader: " + wordCountFileReader);
        } catch (IOException e) {
            System.err.println("Error while reading file using FileReader: " + e.getMessage());
        }

        // Word count using InputStreamReader
        try {
            long wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
            System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
        } catch (IOException e) {
            System.err.println("Error while reading file using InputStreamReader: " + e.getMessage());
        }
    }

    // Count words using FileReader
    public static long countWordsUsingFileReader(String filePath) throws IOException {
        long wordCount = 0;
        FileReader fileReader = new FileReader(filePath, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            wordCount += countWordsInLine(line);
        }

        bufferedReader.close();
        return wordCount;
    }

    // Count words using InputStreamReader
    public static long countWordsUsingInputStreamReader(String filePath) throws IOException {
        long wordCount = 0;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            wordCount += countWordsInLine(line);
        }

        bufferedReader.close();
        return wordCount;
    }

    // Utility function to count words in a line
    public static long countWordsInLine(String line) {
        String[] words = line.split("\\s+"); // Split by whitespace characters
        return words.length;
    }
}
