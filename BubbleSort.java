/*---------------------------------
-- Author: Forrest Meade
-- Date: 10/29/2014
-- Purpose: Bubble Sort an array
--------------------------------- */
public class BubbleSort {
  public static void main(String[] args) {
    int length; // length of array
    int temp; // temporary int holder variable
                         
    int array2[] = {1, 22, 10, 5, 3, 11, 45, 100, 345}; // test array 1
    int array[] = {345, 100, 45, 11, 3, 5, 1000, 22, 1}; // test array 2
    length = array.length; // sets length of array

                                
    /*
      loops through the entire array once
    */                                            
    for (int i = 0; i < (length); i++) {
      /*
        loops through the array except the last one and then number i before it
      */
      for (int j = 0; j < (length - i - 1); j++) {
        /*
          checks if current is bigger than the next one, then swaps them if it is.
        */
        if (array[j] > array[j+1]) /* For descending order use < */
        {
          temp = array[j]; // puts current into temp
          array[j]   = array[j+1]; // puts next into current array spot
          array[j+1] = temp; // puts temp into next array spot
        }
      }
    }

    System.out.println("Sorted list of numbers");

    /*
      prints the array in sorted order
    */
    for (int i = 0; i < length; i++) 
      System.out.println(array[i]);
  }
}
