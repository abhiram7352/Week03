package day04_linear_and_binary_search;

public class RotationPointUsingBinarySearch {
    //Creating a static indexOfSmallestElement named method to find the rotation point
  public static int indexOfSmallestElement(int[] ar, int left, int right){
      while(left<right){
          int mid = (left+right)/2;
          if(ar[mid] > ar[right]){
              left =  mid + 1;
          }else if(ar[mid] < ar[right]){
              right = mid;
          }
      }
          return left;
  }

    public static void main(String[] args) {
      //creating an array
        int[] array = {3, 4, 5, 1, 2};
        int left = 0;
        int right = array.length-1;

        //Calling indexOfSmallestElement method and storing it's value in index named variable
        int index = indexOfSmallestElement(array, left, right);

        //Displaying the result;
        System.out.println("Index of the smallest element in the array (the rotation point): " + index);
    }
}
