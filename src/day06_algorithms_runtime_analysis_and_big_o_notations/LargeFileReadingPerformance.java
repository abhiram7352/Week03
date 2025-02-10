package day06_algorithms_runtime_analysis_and_big_o_notations;


import java.io.*;

public class LargeFileReadingPerformance {

    // Read large file using FileReader (Character Stream)
    public static long readFileWithFileReader(String filePath) throws IOException {
        long startTime = System.currentTimeMillis(); // Record start time
        FileReader fileReader = new FileReader(filePath); // Initialize FileReader
        int ch;
        while ((ch = fileReader.read()) != -1) {
            // Read character by character
        }
        fileReader.close(); // Close FileReader
        long endTime = System.currentTimeMillis(); // Record end time
        return endTime - startTime; // Return time taken
    }

    // Read large file using InputStreamReader (Byte Stream)
    public static long readFileWithInputStreamReader(String filePath) throws IOException {
        long startTime = System.currentTimeMillis(); // Record start time
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath)); // Initialize InputStreamReader
        int ch;
        while ((ch = inputStreamReader.read()) != -1) {
            // Read byte and convert to character
        }
        inputStreamReader.close(); // Close InputStreamReader
        long endTime = System.currentTimeMillis(); // Record end time
        return endTime - startTime; // Return time taken
    }

    // Benchmark the performance of different file reading methods
    public static void benchmarkFileReading(String filePath) throws IOException {
        System.out.println("\nReading file: " + filePath);

        // Measure time for FileReader
        long fileReaderTime = readFileWithFileReader(filePath);
        System.out.println("FileReader (Character Stream) : " + fileReaderTime + " ms");

        // Measure time for InputStreamReader
        long inputStreamReaderTime = readFileWithInputStreamReader(filePath);
        System.out.println("InputStreamReader (Byte Stream) : " + inputStreamReaderTime + " ms");

        System.out.println("-------------------------------------------");
    }

    // Main method to run benchmarks for file reading
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Placement War\\All Certificates\\Large file.pdf"; // Replace with the path to your large file
        benchmarkFileReading(filePath); // Run benchmark for file reading
    }
}
