package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;

public class StringConcatenation {

    // Method to concatenate an array of strings using StringBuffer
    static String stringConcetenator(String[] string){

        // Create a new StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Loop through each string in the array
        for(int i=0; i<string.length; i++){
            sb.append(string[i]); // Append each string to the StringBuffer
        }
        return sb.toString(); // Convert the StringBuffer to a String and return it
    }

    public static void main(String[] args) {
        // Array of strings to be concatenated
        String[] string = {"I'm Abhiram Kumar ",
                "My dream is to become a Software Engineer ",
                "It was my small information ",
                "Please concadinate all my information in one sentence"};

        // Print the concatenated string
        System.out.println("Look at it again: " + stringConcetenator(string));
    }
}