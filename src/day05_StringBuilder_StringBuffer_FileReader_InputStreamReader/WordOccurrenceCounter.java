package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;
import java.io.*;

public class WordOccurrenceCounter {
    public static void main(String[] args) {
        // Specify the file path and the word to count
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\OOPs\\Assignment1List.java\\";
        String targetWord = "class";   // Replace with the word you want to count

        // Initialize the word count to 0
        int wordCount = 0;

        // Create FileReader and BufferedReader objects
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");

                // Check each word in the line
                for (String word : words) {
                    // If the word matches the target word, increment the counter
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }

            // Print the final count of occurrences
            System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");

        } catch (IOException e) {
            // Handle exceptions (e.g., file not found, I/O errors)
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
