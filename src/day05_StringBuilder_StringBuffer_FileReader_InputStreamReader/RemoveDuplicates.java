package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;

import java.util.HashSet;
//Creating RemoveDuplicates class
public class RemoveDuplicates {

    public static void main(String[] args) {

        //Creating string named string literal
        String string = "qwsdfgbnmspwqhgdwefruge";

        //Creating character type of HashSet to keep track of the character
        HashSet<Character> hs = new HashSet<>();

        //Creating sb named StringBuilder to store unique character;
        StringBuilder sb = new StringBuilder();

        //Iterate over each character in the string
        for(int i=0; i<string.length(); i++){
            if(!hs.contains(string.charAt(i))){
                sb.append(string.charAt(i));   //Appending all character that are not in HashSet
                hs.add(string.charAt(i));      //Adding all character same character
            }
        }

        //Displaying the result
        System.out.println(sb);
    }
}
