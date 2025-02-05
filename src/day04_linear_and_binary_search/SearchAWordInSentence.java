package day04_linear_and_binary_search;

//Creating a class name SearchAWordInSentence
public class SearchAWordInSentence {
    public static void main(String[] args) {
        String[] sentences = {
                "This is the first sentence.",
                "Here is another sentence.",
                "This sentence contains the word.",
                "Yet another sentence."
        };

        //word string to find word in sentences string array
        String word = "word";

        //Calling the findSentenceContainingWord method
        String result = findSentenceContainingWord(sentences, word);

        //printing the output
        System.out.println(result);
    }

    //creating a paramatrized method findSentenceContainingWord to find the sentences that contains word
    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        //returning not found in case if there is no sentence containing word
        return "Not Found";
    }
}
