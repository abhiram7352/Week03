package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // Specify the file to write to
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstrc1.java"; // Replace with your desired file path

        // Create InputStreamReader to read from System.in (console)
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // 'true' to append to the file
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String userInput;

            System.out.println("Enter your input (type 'exit' to stop):");

            // Read user input until 'exit' is typed
            while (true) {
                userInput = bufferedReader.readLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                // Write the user input to the file as a new line
                bufferedWriter.write(userInput);
                bufferedWriter.newLine(); // Adds a newline after each input
            }

            System.out.println("Input has been written to the file.");

        } catch (IOException e) {
            System.err.println("An error occurred while handling the file or reading input: " + e.getMessage());
        }
    }
}
