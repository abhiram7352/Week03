package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;

public class ReverseString {
    public static void main(String[] args) {
        //Creating a variable named input for string type
        String input = "Hello";

        //StringBuilder for reversing the string literal
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            sb.append(input.charAt(i));
        }
        //Displaying the output
        System.out.println(sb.reverse());

    }
}
