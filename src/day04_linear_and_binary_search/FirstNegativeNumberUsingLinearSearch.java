package day04_linear_and_binary_search;
//Creating a class named FirstNegativeNumberUsingLinearSearch
public class FirstNegativeNumberUsingLinearSearch {
    public static void main(String[] args) {


        int[] array={2, 0, 1, -9, 2, 34, -2};

        //Taking an answer variable and assigning -1 if no negative element found
        int ans = -1;

        //Performing linear search to find the index of first negative element
        for(int i=0; i<array.length; i++){
            if(array[i] < 0){
                ans = i;
                break;
            }
        }

        //Printing the output of the code
        System.out.println(ans);
    }
}
