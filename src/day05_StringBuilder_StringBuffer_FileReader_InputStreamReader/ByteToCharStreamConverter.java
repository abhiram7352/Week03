package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;

import java.io.*;

public class ByteToCharStreamConverter {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\OOPs\\Assignment1List.java\\";
        // Create FileInputStream to read the file as a byte stream
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            // Wrap the FileInputStream in an InputStreamReader to convert byte stream to character stream
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8"); // Specify charset (e.g., UTF-8)

            // Wrap the InputStreamReader in a BufferedReader for efficient line-by-line reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read the file line by line and print it
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader and InputStreamReader
        } catch (FileNotFoundException e) {
            System.err.println("The specified file was not found: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.err.println("The specified encoding is not supported: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
